package lk.coop.compact.controller.master;

import lk.coop.compact.dto.master.request.StudentSaveRequest;
import lk.coop.compact.dto.master.response.StudentResponse;
import lk.coop.compact.service.master.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
