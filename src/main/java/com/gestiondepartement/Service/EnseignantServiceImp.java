package com.gestiondepartement.Service;

import com.gestiondepartement.Entity.Enseignant;
import com.gestiondepartement.Repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantServiceImp implements EnseignantService {
    @Autowired
    EnseignantRepository enseignantRepository;

    @Override
    public List<Enseignant> getAllTeacher() {
        return enseignantRepository.findAll();
    }

    @Override
    public Enseignant addTeacher(Enseignant teacher) {
        return enseignantRepository.save(teacher);
    }

    @Override
    public Enseignant getTeacherById(long teacherId) {
        Enseignant enseignant = enseignantRepository.findByTeacherId(teacherId);
        return enseignant;
    }

    @Override
    public Enseignant updateTeacher(Enseignant teacher) {
        return enseignantRepository.saveAndFlush(teacher);
    }

    @Override
    public void deleteTeacher(long teacherId) {
        enseignantRepository.deleteById(teacherId);
    }
}
