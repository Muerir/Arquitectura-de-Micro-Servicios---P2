package arquitectura.software.msstudent.api;

import arquitectura.software.msstudent.entity.Student;
import arquitectura.software.msstudent.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/student")
public class StudentController {

    private static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(path = "/test",
            method = RequestMethod.GET)
    public String testCustomer(){
        LOGGER.error("Error Logger");
        LOGGER.warn("WARN LOGGER");
        LOGGER.info("Probandi endpoint ms-student");
        return "MS - student";
    }

    @RequestMapping(path = "/save",
            method = RequestMethod.POST)
    public Student SaveStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @RequestMapping(path = "/all",
            method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public Student getStudent(@RequestParam Integer studentId) throws Exception {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()){
            Student student=optionalStudent.get();
            return student;
        }else {
            throw new Exception("No se encuentra el usuario");
        }

    }

    @RequestMapping (path = "/get",
            method = RequestMethod.GET)
    public Integer getTeacherCourse(@RequestParam Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return 1;
        }else{
            return 0;
        }
    }
}
