package com.aol.cmi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JsonUtils {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

	public static String toJsonString(Object object) {
		try {
			if(object==null) {
				return null;
			}
			
			return OBJECT_MAPPER.writeValueAsString(object);
			
		} catch (Exception e) {
			LOGGER .warn(e.getMessage(), e);
			return null;
		}
    }
    
    
	public static String toJsonStringNonNull(Object object) {
		try {
			if(object==null) {
				return null;
			}
			
			OBJECT_MAPPER.setSerializationInclusion(Include.NON_NULL);
			return OBJECT_MAPPER.writeValueAsString(object);
			
		} catch (Exception e) {
			LOGGER .warn(e.getMessage(), e);
			return null;
		}
    }
    
    

}
