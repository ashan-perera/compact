package lk.coop.compact.dto.authentication.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthTokenResponse {

    private Object user;
    private String token;

}
