package kz.bitlab.G126FirstProject.repository;

import kz.bitlab.G126FirstProject.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT st FROM Student st " +
            "WHERE st.name ilike concat('%', :s, '%') " +
            "OR st.surname ilike concat('%', :s, '%')")
    List<Student>getAllStudentsByWord(String s);
}
