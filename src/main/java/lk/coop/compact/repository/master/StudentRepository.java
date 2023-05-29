package lk.coop.compact.repository.master;

import lk.coop.compact.entity.master.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
