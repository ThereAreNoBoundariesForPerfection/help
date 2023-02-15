package our.war.help.security.pojo;

import lombok.Data;

import java.util.List;
@Data
public class JwtResponse {
    private final String token;
    private final String type = "Bearer";
    private final Long id;
    private final String email;
    private final List<String> roles;
}
