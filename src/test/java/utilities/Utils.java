package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static <T> T deserializeJson(String fileName, Class <T> T) throws IOException {
        InputStream input = Utils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(input, T);
    }
}
