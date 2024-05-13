package com.gestiondepartement.Service;

import com.gestiondepartement.Entity.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllStudents();
    Etudiant addStudent (Etudiant student);
    Etudiant getStudentById(long studentId);
    Etudiant updateStudent(Etudiant student);
    void deleteStudent(long studentId);
}