package com.noelcurtis.serialize;

import org.codehaus.jackson.map.SerializationConfig;

import java.util.List;

/**
 * User: noelcurtis
 * Date: 3/5/12
 * Time: 3:52 PM
 */
public class ObjectMapper {

    public static  ObjectMapper sharedInstance = null;

    private org.codehaus.jackson.map.ObjectMapper objectMapper;

    public org.codehaus.jackson.map.ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    protected ObjectMapper(){
        this.objectMapper = new org.codehaus.jackson.map.ObjectMapper();
        this.objectMapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
    }

    public static ObjectMapper getSharedInstance() {
        if (sharedInstance == null){
            sharedInstance = new ObjectMapper();
        }
        return sharedInstance;
    }
}
