package app.configuration;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class RestTemplateConfiguration {
	
	@Value("${http.connection.timeout}")
	private int connectionTimeout;

	@Value("${http.read.timeout}")
	private int readTimeout; 

	private ClientHttpRequestFactory httpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setHttpClient(httpClient());
		factory.setConnectTimeout(connectionTimeout);
		factory.setReadTimeout(readTimeout);
		return factory;
	}

	private HttpClient httpClient() {
		return HttpClientBuilder.create().setConnectionManager(new PoolingHttpClientConnectionManager()).build();
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(httpRequestFactory());
		restTemplate.setMessageConverters(messageConverters());
		return restTemplate;
	}

	private List<HttpMessageConverter<?>> messageConverters() {
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(jsonMessageConverter());
		return converters;
	}

	private HttpMessageConverter<?> jsonMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		converter.setObjectMapper(objectMapper );
		return converter;
	}
	
}
