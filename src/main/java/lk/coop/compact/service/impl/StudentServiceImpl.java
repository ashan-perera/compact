package lk.coop.compact.service.impl;

import lk.coop.compact.dto.request.StudentSaveRequest;
import lk.coop.compact.dto.response.StudentResponse;
import lk.coop.compact.entity.Student;
import lk.coop.compact.enums.Deleted;
import lk.coop.compact.enums.Status;
import lk.coop.compact.repository.StudentRepository;
import lk.coop.compact.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse save(StudentSaveRequest studentSaveRequest) {

        Student student = new Student();

        student.setFirstName(studentSaveRequest.getFirstName());
        student.setFirstName(studentSaveRequest.getLastName());
        student.setStatus(Status.ACTIVE);
        student.setIsDeleted(Deleted.NO);

        Student save = studentRepository.save(student);

        return convert(save);

    }

    private static StudentResponse convert(Student student) {

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId(student.getId());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setCreatedBy(student.getCreatedBy());
        studentResponse.setCreatedDateTime(student.getCreatedDateTime());
        studentResponse.setModifiedBy(student.getModifiedBy());
        studentResponse.setModifiedDateTime(student.getModifiedDateTime());

        return studentResponse;

    }

}
