package sweb.disi.unitn.it.validation;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    void isValid() {
        UserValidator uv = new UserValidator("myUserId");

        assertEquals(true, uv.isValid(
                "{\"userId\":\"myUserId\"}"
        ));

        assertEquals(true, uv.isValid(
                "{\n" +
                        "  \"userId\": \"myUserId\",\n" +
                        "  \"data\": {\n" +
                        "    \"sensor1\": [\n" +
                        "      {\n" +
                        "        \"userId\": \"myUserId\",\n" +
                        "        \"ts\": 12311231000,\n" +
                        "        \"payload\": {\n" +
                        "          \"x\": 1,\n" +
                        "          \"y\": 2\n" +
                        "        },\n" +
                        "        \"meta\": {\n" +
                        "        }\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"ts\": 12341231000,\n" +
                        "        \"payload\": {\n" +
                        "          \"x\": 3,\n" +
                        "          \"y\": 4\n" +
                        "        },\n" +
                        "        \"meta\": {}\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"sensor2\": [\n" +
                        "      {\n" +
                        "        \"ts\": 12351231000,\n" +
                        "        \"payload\": {\n" +
                        "          \"x\": 5,\n" +
                        "          \"y\": 6\n" +
                        "        },\n" +
                        "        \"meta\": {}\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}"
        ));

        assertEquals(false, uv.isValid(
                "{\n" +
                        "  \"userId\": \"myUserId\",\n" +
                        "  \"data\": {\n" +
                        "    \"sensor1\": [\n" +
                        "      {\n" +
                        "        \"userId\": \"OtherUSERId\",\n" + //ERROR here!
                        "        \"ts\": 12311231000,\n" +
                        "        \"payload\": {\n" +
                        "          \"x\": 1,\n" +
                        "          \"y\": 2\n" +
                        "        },\n" +
                        "        \"meta\": {\n" +
                        "        }\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"ts\": 12341231000,\n" +
                        "        \"payload\": {\n" +
                        "          \"x\": 3,\n" +
                        "          \"y\": 4\n" +
                        "        },\n" +
                        "        \"meta\": {}\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"sensor2\": [\n" +
                        "      {\n" +
                        "        \"ts\": 12351231000,\n" +
                        "        \"payload\": {\n" +
                        "          \"x\": 5,\n" +
                        "          \"y\": 6\n" +
                        "        },\n" +
                        "        \"meta\": {}\n" +
                        "      }\n" +
                        "    ]\n" +
                        "  }\n" +
                        "}"
        ));
    }
}