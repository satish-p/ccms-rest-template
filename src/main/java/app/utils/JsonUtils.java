package app.utils;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonUtils {

	public static String toJsonString(Object object) {
		try {
			if(object==null) {
				return null;
			}
			
			return new ObjectMapper().writeValueAsString(object);
			
		} catch (Exception e) {
		    LoggerFactory.getLogger(JsonUtils.class).warn(e.getMessage(), e);
			return null;
		}
    }
    
    
	public static String toJsonStringNonNull(Object object) {
		try {
			if(object==null) {
				return null;
			}
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			return objectMapper.writeValueAsString(object);
			
		} catch (Exception e) {
		    LoggerFactory.getLogger(JsonUtils.class).warn(e.getMessage(), e);
			return null;
		}
    }
    
    

}
