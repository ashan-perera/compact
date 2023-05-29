package lk.coop.compact.dto.authentication.request;

import lombok.Data;

@Data
public class RoleSaveRequest {

    private String id;
    private String name;
    private String description;

}
