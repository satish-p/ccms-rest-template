package application;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.ServletRequestListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextListener;

import com.aol.logging.LogsSanitizer;
import com.aol.logging.MappingJackson2RequestLogger;
import com.aol.logging.RequestExtractor;
import com.aol.logging.RequestLog;
import com.aol.logging.RequestLogger;
import com.aol.logging.SimpleRequestExtractor;
import com.aol.logging.filter.RequestLoggingFilter;

@Configuration
public class LogsConfiguration {

	@Resource
	private List<String> sensitiveKeys;

	@Resource
	private List<String> loggingFilteredUris;

	@Bean
	public ServletRequestListener requestListener() {
		return new RequestContextListener();
	}
	
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public Filter loggingFilter() throws Exception {
    	RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter();
    	requestLoggingFilter.setLoggingFilteredUris(loggingFilteredUris);
    	requestLoggingFilter.setRequestExtractor(requestExtractor());
    	requestLoggingFilter.setRequestLogger(requestLogger());
    	requestLoggingFilter.setRequestLog(requestLog());
    	requestLoggingFilter.setLogsSanitizer(logsSanitizer());
    	return requestLoggingFilter;
    }

    @Bean
    public LogsSanitizer logsSanitizer() {
    	LogsSanitizer logsSanitizer = new LogsSanitizer();
    	logsSanitizer.setSensitiveKeys(sensitiveKeys);
		return logsSanitizer;
	}

    @Bean
    public RequestExtractor requestExtractor() {
		return new SimpleRequestExtractor();
	}

    @Bean
    public RequestLogger requestLogger() throws Exception {
		return new MappingJackson2RequestLogger();
	}
    
    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RequestLog requestLog() {
		return new RequestLog();
	}

}