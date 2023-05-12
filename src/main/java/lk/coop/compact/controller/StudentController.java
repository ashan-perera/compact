package lk.coop.compact.controller;

import lk.coop.compact.dto.request.StudentSaveRequest;
import lk.coop.compact.dto.response.StudentResponse;
import lk.coop.compact.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    private StudentResponse save(@RequestBody StudentSaveRequest studentSaveRequest) {

        return studentService.save(studentSaveRequest);

    }

}
