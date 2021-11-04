package Arquitectura.Software.mscourse.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;

@Service
@FeignClient (name = "ms-student")
public interface StudentService {
    @RequestMapping(path = "v1/api/student/get",
                    method = RequestMethod.GET)
    Integer getStudentCourse(@RequestParam Integer id);
}
