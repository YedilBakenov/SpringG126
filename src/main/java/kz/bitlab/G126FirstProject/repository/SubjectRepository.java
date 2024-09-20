package kz.bitlab.G126FirstProject.repository;


import kz.bitlab.G126FirstProject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
