package Arquitectura.Software.mscourse.api;

import Arquitectura.Software.mscourse.entity.Course;
import Arquitectura.Software.mscourse.repository.CourseRepository;
import Arquitectura.Software.mscourse.service.StudentService;
import Arquitectura.Software.mscourse.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/course")
public class CourseController {

    private static Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(path = "/test",
            method = RequestMethod.GET)
    public String testCourse(){
        return "MS - course";
    }

    @RequestMapping (path = "/save",
                    method = RequestMethod.POST)
    public String saveCourse (@RequestBody Course course){

        Integer resultStudent=studentService.getStudentCourse(course.getStudentId());
        Integer resultTeacher=teacherService.getTeacherCourse(course.getTeacherId());
        if(resultStudent==1 && resultTeacher==1){
            courseRepository.save(course);
            return "Se ha registrado el curso";
        }else{
            return "Error, datos de estudiante o profesor no identificados";
        }
    }


}
