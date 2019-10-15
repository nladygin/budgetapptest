package api.entity;

import org.springframework.stereotype.Component;


@Component
public class Password extends BaseEntity implements Entity {

    public final String original = "123456";
    public final String password = "1234567";
    public final String confirm = "1234567";


}
