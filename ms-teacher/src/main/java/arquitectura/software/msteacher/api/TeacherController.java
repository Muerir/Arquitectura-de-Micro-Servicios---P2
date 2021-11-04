package arquitectura.software.msteacher.api;

import arquitectura.software.msteacher.entity.Teacher;
import arquitectura.software.msteacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;

    @RequestMapping(path = "/test",
            method = RequestMethod.GET)
    public String testCustomer(){
        return "MS - teacher";
    }

    @RequestMapping(path = "/save",
            method = RequestMethod.POST)
    public Teacher SaveTeacher(@RequestBody Teacher teacher){
        return teacherRepository.save(teacher);
    }

    @RequestMapping(path = "/update",
            method = RequestMethod.PUT)
    public Teacher updateTeacher (@RequestParam Integer teacherId, @RequestBody Teacher teacher) throws Exception {
        Teacher teacherOptional = teacherRepository.getById(teacherId);
        if (teacherOptional!=null) {
            teacherOptional.setName(teacher.getName());
            teacherOptional.setSubject(teacher.getSubject());
            return teacherRepository.save(teacherOptional);
        }else{
            throw new Exception("No se encontro al usuario");
        }
    }

    @RequestMapping(path = "/all",
            method = RequestMethod.GET)
    public List<Teacher> getAllTeacher(){
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    @RequestMapping (path = "/get",
            method = RequestMethod.GET)
    public Integer getTeacherCourse(@RequestParam Integer id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if(teacherOptional.isPresent()){
            return 1;
        }else{
            return 0;
        }
    }
}
