package frontend.helper;


import frontend.config.Config;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@Component
public class Utils {


    public String makeAuthToken(String username, String password){
        return encodeURL("\"" + new String(Base64.encodeBase64((username + ":" + password).getBytes())) + "\"");
    }


    public void setCookie(String name, String value){
//        Cookie cookie = new Cookie.Builder(name, value)
//                .domain("192.168.137.13")
//                .expiresOn(new Date(2015, 10, 28))
//                .isHttpOnly(true)
//                .isSecure(false)
//                .path("/")
//                .build();
        Cookie cookie = new Cookie(name,value,"127.0.0.1","/",null,false,true);
        driver.manage().addCookie(cookie);
    }


    private static String encodeURL(String url) {
        try {
            return URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }



    @Autowired private WebDriver driver;
    @Autowired private Config config;
}
