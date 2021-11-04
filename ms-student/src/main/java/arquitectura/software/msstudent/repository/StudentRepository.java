package arquitectura.software.msstudent.repository;

import arquitectura.software.msstudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
