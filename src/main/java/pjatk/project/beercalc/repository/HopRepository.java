package pjatk.project.beercalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjatk.project.beercalc.model.Hop;

public interface HopRepository extends JpaRepository<Hop, Long> {
}
