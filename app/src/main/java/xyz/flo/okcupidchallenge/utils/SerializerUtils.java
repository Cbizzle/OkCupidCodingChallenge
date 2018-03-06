package xyz.flo.okcupidchallenge.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Holds on to static references for serialization
 */
public class SerializerUtils {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    static  {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
