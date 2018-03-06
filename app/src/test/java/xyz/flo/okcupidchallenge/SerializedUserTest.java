package xyz.flo.okcupidchallenge;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import xyz.flo.okcupidchallenge.data.SerializedUser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SerializedUserTest {

    @Test
    public void test_deserialize() throws IOException {
        String testDataString = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("user.json"), StandardCharsets.UTF_8.name());
        final ObjectMapper objectMapper = new ObjectMapper();
        SerializedUser serializedUser = objectMapper.readValue(testDataString, SerializedUser.class);
        assertNotNull(serializedUser);
        assertEquals("bklyn2356", serializedUser.getUsername());
    }
}
