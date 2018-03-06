package xyz.flo.okcupidchallenge;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import xyz.flo.okcupidchallenge.data.OkCupidData;
import xyz.flo.okcupidchallenge.data.SerializedUser;
import xyz.flo.okcupidchallenge.data.User;
import xyz.flo.okcupidchallenge.data.UserMapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OkCupidDataTest {

    @Test
    public void test_deserialize() throws IOException {
        String testDataString = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("okCupidData.json"), StandardCharsets.UTF_8.name());
        final ObjectMapper objectMapper = new ObjectMapper();
        OkCupidData okCupidData = objectMapper.readValue(testDataString, OkCupidData.class);
        assertNotNull(okCupidData);
        assertNotNull(okCupidData.getSerializedUsers());
        assertEquals(18, okCupidData.getSerializedUsers().size());
    }

    @Test
    public void test_userMapper() throws IOException {
        String testDataString = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("user.json"), StandardCharsets.UTF_8.name());
        final ObjectMapper objectMapper = new ObjectMapper();
        SerializedUser serializedUser = objectMapper.readValue(testDataString, SerializedUser.class);
        UserMapper userMapper = new UserMapper();
        User testUser = userMapper.serializedUserToUser(serializedUser);
        assertNotNull(testUser);
        assertEquals("bklyn2356", testUser.getUsername());
    }
}
