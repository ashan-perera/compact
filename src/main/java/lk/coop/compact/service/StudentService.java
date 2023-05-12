package lk.coop.compact.service;

import lk.coop.compact.dto.request.StudentSaveRequest;
import lk.coop.compact.dto.response.StudentResponse;

public interface StudentService {

    StudentResponse save(StudentSaveRequest studentSaveRequest);

}
