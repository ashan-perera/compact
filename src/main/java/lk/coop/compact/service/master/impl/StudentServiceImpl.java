package lk.coop.compact.service.master.impl;

import lk.coop.compact.dto.master.request.StudentSaveRequest;
import lk.coop.compact.dto.master.response.StudentResponse;
import lk.coop.compact.entity.master.Student;
import lk.coop.compact.enums.Deleted;
import lk.coop.compact.enums.Status;
import lk.coop.compact.repository.master.StudentRepository;
import lk.coop.compact.service.master.StudentService;
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
        student.setLastName(studentSaveRequest.getLastName());
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
