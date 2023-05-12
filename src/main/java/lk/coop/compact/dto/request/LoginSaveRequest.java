package lk.coop.compact.dto.request;

import lk.coop.compact.enums.Login;
import lombok.Data;

@Data
public class LoginSaveRequest {

    private String ipAddress;
    private String userName;
    private Login loginType;

}
