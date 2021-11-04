package Arquitectura.Software.mscourse.repository;

import Arquitectura.Software.mscourse.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
