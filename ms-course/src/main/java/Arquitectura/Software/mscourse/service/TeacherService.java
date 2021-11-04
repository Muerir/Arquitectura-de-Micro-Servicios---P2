package Arquitectura.Software.mscourse.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "ms-teacher")
public interface TeacherService {
    @RequestMapping(path = "v1/api/teacher/get",
                    method = RequestMethod.GET)
    Integer getTeacherCourse(@RequestParam Integer id);
}
