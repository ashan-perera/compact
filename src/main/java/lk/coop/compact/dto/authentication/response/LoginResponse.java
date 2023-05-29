package lk.coop.compact.dto.authentication.response;

import lk.coop.compact.enums.Login;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String id;
    private String ipAddress;
    private UserResponse user;
    private Login loginType;
    private String createdDate;

}
