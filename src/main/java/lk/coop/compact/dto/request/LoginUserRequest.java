package lk.coop.compact.dto.request;

import lombok.Data;

@Data
public class LoginUserRequest {

    private String username;
    private String password;
    private LoginSaveRequest loginSaveRequest;

}
