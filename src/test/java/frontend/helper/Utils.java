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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class Utils {


    public String makeToday(String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }


    public Double cleanValue(String value){
        return Double.valueOf(value.replace("$","").replace("RUR", ""));
    }

/*
    public String makeAuthToken(String username, String password){
        return encodeURL("\"" + new String(Base64.encodeBase64((username + ":" + password).getBytes())) + "\"");
    }


    public void setCookie(String name, String value){
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
*/


    @Autowired private WebDriver driver;
    @Autowired private Config config;
}
