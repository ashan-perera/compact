package lk.coop.compact.controller.master;

import lk.coop.compact.dto.master.request.StudentSaveRequest;
import lk.coop.compact.dto.master.response.StudentResponse;
import lk.coop.compact.service.master.StudentService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;

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

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {

        return studentService.exportReport(format);

    }

    @PostMapping("/printMotorCard")
    private void printMotorCard() {

        studentService.printMotorCard();

    }

    @PostMapping("/printCovernote")
    private File printCovernote() {

        return studentService.printCovernote();

    }

}
