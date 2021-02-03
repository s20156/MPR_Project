package pjatk.project.beercalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjatk.project.beercalc.model.Malt;

public interface MaltRepository extends JpaRepository<Malt, Long> {
}
