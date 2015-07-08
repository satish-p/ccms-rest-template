package com.aol.cmi.application;

import java.util.List;

import javax.servlet.Filter;

import net.bull.javamelody.MonitoringFilter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.aol.cmi.filter.JsonpCallbackFilter;
import com.aol.util.hog4j.MsStats;

@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {
	
	@Value("${cmi.jsonp.callback.param.name}")
	private String callbackParameterName;

    @Bean
    public Filter jsonpCallbackFilter() {
    	JsonpCallbackFilter jsonpCallbackFilter = new JsonpCallbackFilter();
    	jsonpCallbackFilter.setCallbackParameterName(callbackParameterName);
    	return jsonpCallbackFilter;
    }
    
    @Bean
    public Filter monitoringFilter() throws Exception {
    	return new MonitoringFilter();
    }


    @Bean
    public MsStats msStats() throws Exception {
    	return new MsStats("cmioffers");
    }
    
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
        addDefaultHttpMessageConverters(converters);
    }

    @Bean
    public MappingJackson2HttpMessageConverter converter() {
    	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        //do your customizations here...

        return converter;
    }
}
