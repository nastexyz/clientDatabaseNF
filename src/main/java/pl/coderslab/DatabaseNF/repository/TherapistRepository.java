package pl.coderslab.DatabaseNF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.DatabaseNF.entity.Therapist;

import java.util.List;

@Repository
public interface TherapistRepository extends JpaRepository<Therapist, Long> {
    Therapist findByLogin(String login);
}
