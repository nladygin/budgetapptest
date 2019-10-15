package api.entity;

import org.springframework.stereotype.Component;

@Component
public class Credentials extends BaseEntity implements Entity {
    public final String username = "test@test";
    public final String password = "123456";
}
