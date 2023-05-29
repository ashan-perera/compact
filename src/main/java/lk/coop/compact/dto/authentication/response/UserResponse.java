package lk.coop.compact.dto.authentication.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserResponse {

    private String id;
    private String username;
    private String email;
    private String phone;
    private String name;
    private String businessTitle;
    private String epfNo;
    private List<RoleResponse> roles;

}
