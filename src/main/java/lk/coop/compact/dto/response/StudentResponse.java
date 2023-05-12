package lk.coop.compact.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class StudentResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String createdBy;
    private Date createdDateTime;
    private String modifiedBy;
    private Date modifiedDateTime;

}
