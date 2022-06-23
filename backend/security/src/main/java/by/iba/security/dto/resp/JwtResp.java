package by.iba.security.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResp {

    private String tokenType = "Bearer";
    private String token;
    private String username;
    public JwtResp(String token, String username) {
        this.token = token;
        this.username = username;
    }
}
