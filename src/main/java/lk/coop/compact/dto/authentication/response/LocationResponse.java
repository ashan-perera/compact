package lk.coop.compact.dto.authentication.response;

import lombok.Data;

@Data
public class LocationResponse {

    private String id;
    private String initialName;
    private String code;
    private String email;
    private String startDate;
    private String endDate;

}
