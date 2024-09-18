package kz.bitlab.G126FirstProject.repository;

import kz.bitlab.G126FirstProject.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CityRepository extends JpaRepository<City, Integer> {
}
