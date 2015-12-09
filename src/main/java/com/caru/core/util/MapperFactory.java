package com.caru.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class MapperFactory {
    public static ObjectMapper json() {
    	ObjectMapper om = new ObjectMapper();
    	om.registerModule(new JodaModule());
       	om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    	om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    	om.disable(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
    	om.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    	om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    	
    	return om;
    }

    public static ObjectMapper indented() {
        ObjectMapper objectMapper = json();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper;
    }
}

