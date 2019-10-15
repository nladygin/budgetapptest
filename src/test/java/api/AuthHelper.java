package api;

import api.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;



@Component
public class AuthHelper {


    public User getUser() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("auth.json").getFile());
            ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, User.class);
    }


}

