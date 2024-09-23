package kz.bitlab.G126FirstProject.repository2;

import kz.bitlab.G126FirstProject.model2.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
