package lk.coop.compact.service.master;

import lk.coop.compact.dto.master.request.StudentSaveRequest;
import lk.coop.compact.dto.master.response.StudentResponse;
import net.sf.jasperreports.engine.JRException;

import java.io.File;
import java.io.FileNotFoundException;

public interface StudentService {

    StudentResponse save(StudentSaveRequest studentSaveRequest);

    String exportReport(String reportFormat) throws FileNotFoundException, JRException;

    File printMotorCard();

    File printCovernote();

}
