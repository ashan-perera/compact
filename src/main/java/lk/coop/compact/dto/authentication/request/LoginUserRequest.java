package lk.coop.compact.dto.authentication.request;

import lombok.Data;

@Data
public class LoginUserRequest {

    private String username;
    private String password;
    private LoginSaveRequest loginSaveRequest;

}
