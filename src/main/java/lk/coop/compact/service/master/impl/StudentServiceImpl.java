package lk.coop.compact.service.master.impl;

import lk.coop.compact.dto.master.request.StudentSaveRequest;
import lk.coop.compact.dto.master.response.StudentResponse;
import lk.coop.compact.entity.master.Student;
import lk.coop.compact.enums.Deleted;
import lk.coop.compact.enums.Status;
import lk.coop.compact.repository.master.StudentRepository;
import lk.coop.compact.service.master.StudentService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Override
    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        String path = "D:\\Reports";
        List<Student> students = studentRepository.findAll();

        File file = ResourceUtils.getFile("classpath:students.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ModifiedBy", "Co-op");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if(reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\students.html");
        }

        if(reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\students.pdf");
        }

        return "Report generated in path " + path;

    }

    @Override
    public File printMotorCard() {

        try {

            Date date = new Date();
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

            // printing the date in the readable format.
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dateStr = dateFormat.format(date);

            //creating calender instance
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            String timeStr = timeFormat.format(calendar.getTime());

            // adding 1 years, 0 months and minus date
            calendar.add(Calendar.YEAR, 1);
            calendar.add(Calendar.MONTH, 0);
            calendar.add(Calendar.DATE, -1);

            // getting the new date from calendar
            Date addedDate = calendar.getTime();

            // printing the new date
            String newDateInStr = dateFormat.format(addedDate);

//            File file = new File(System.getProperty("user.home") + "\\JasperTemp\\motorCard.jrxml");

            File file = ResourceUtils.getFile("classpath:motorCard.jrxml");

            HashMap map = new HashMap<String, String>();

            map.put("policyNo", "PYA4354365");
            map.put("chassisNo", "2H2XA59BWDY987665");
            map.put("engineNo", "52WVC10338");
            map.put("vehicleNo", "WP KS-0071");
            map.put("initialName", "Zviad Gamzakhurdia");
            map.put("periodFrom", dateStr);
            map.put("periodTo", newDateInStr);
            map.put("dateOfIssue", dateStr);
            map.put("timeOfIssue", timeStr);
            map.put("place", ("negombo").toUpperCase());
            map.put("nic", "945464466V");
            map.put("address", "No: 22, Fake rad, Fake city");
            map.put("employeeWithEpf", "4435");


            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JasperPrint print = JasperFillManager.fillReport(jasperReport, map);

            File dir = new File(System.getProperty("user.home") + "\\MT\\UW\\MotorPolicy\\");
            dir.mkdirs();

            JasperExportManager.exportReportToPdfFile(print,System.getProperty("user.home") + "\\MT\\UW\\MotorPolicy\\" + map.get("policyNo") + ".pdf");

            File files = new File(System.getProperty("user.home") + "\\MT\\UW\\MotorPolicy\\" + map.get("policyNo") + ".pdf");
            return files;

        } catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    public File printCovernote() {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateStr = dateFormat.format(date);

        try {

//            File file = new File(System.getProperty("user.home") + "\\JasperTemp\\covernote.jrxml");

            File file = ResourceUtils.getFile("classpath:covernote.jrxml");

            HashMap map = new HashMap<String, String>();

            map.put("covernoteNo", "2341");
            map.put("covernoteDate", "2022-11-12");
            map.put("noOfDays", 56);
            map.put("policyNo", "PYA4354PHO5");
            map.put("date", dateStr);
            map.put("insuredName", "A. B. C. D. Perera");
            map.put("address", "No: 22, Fake road, Fake city");
            map.put("insuranceClass", "Motor");
            map.put("productOfInsurance", "productOfInsurance");
            map.put("vehicleNo", "WP KS-0071");
            map.put("policySumInsured", "4534");
            map.put("policyTotalPremium", "23435");
            map.put("chassisNo", "2H2XA59BWDY987665");
            map.put("engineNo", "52WVC10338");
            map.put("vehiMake", "Nissan");
            map.put("vehiModel", "Sunny");
            map.put("reasonName", "Reason Name");

            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JasperPrint print = JasperFillManager.fillReport(jasperReport, map);

            File dir = new File(System.getProperty("user.home") + "\\MT\\UW\\Covernote\\");
            dir.mkdirs();

            JasperExportManager.exportReportToPdfFile(print, System.getProperty("user.home") + "\\MT\\UW\\Covernote\\" + map.get("covernoteNo") + ".pdf");

            File pdfFile = new File(System.getProperty("user.home") + "\\MT\\UW\\Covernote\\" + map.get("covernoteNo") + ".pdf");
            return pdfFile;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

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
