package lk.coop.compact.dto.authentication.request;

import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {

    private String userName;
    private String password;
    private String email;
    private String phone;
    private String name;
    private String businessTitle;
    private String epfNo;
    private Set<RoleSaveRequest> roles;

}
