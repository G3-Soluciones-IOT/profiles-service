package pe.edu.upc.center.jameoFit.profiles.infrastructure.persistence.jpa.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.center.jameoFit.profiles.domain.model.Entities.Objective;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {}
