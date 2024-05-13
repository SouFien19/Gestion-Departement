package com.gestiondepartement.Repository;

import com.gestiondepartement.Entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    Enseignant findByTeacherId(long teacherId);
}
