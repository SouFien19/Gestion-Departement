package com.gestiondepartement.Service;

import com.gestiondepartement.Entity.Etudiant;
import com.gestiondepartement.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImp implements EtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> getAllStudents() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addStudent(Etudiant student) {
        return etudiantRepository.save(student);
    }

    @Override
    public Etudiant getStudentById(long studentId) {
        Etudiant etudiant = etudiantRepository.findByStudentId(studentId);
        return etudiant;
    }

    @Override
    public Etudiant updateStudent(Etudiant student) {
        return etudiantRepository.saveAndFlush(student);
    }

    @Override
    public void deleteStudent(long studentId) {
        etudiantRepository.deleteById(studentId);
    }
}
