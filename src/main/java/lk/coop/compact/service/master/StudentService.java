package lk.coop.compact.service.master;

import lk.coop.compact.dto.master.request.StudentSaveRequest;
import lk.coop.compact.dto.master.response.StudentResponse;

public interface StudentService {

    StudentResponse save(StudentSaveRequest studentSaveRequest);

}
