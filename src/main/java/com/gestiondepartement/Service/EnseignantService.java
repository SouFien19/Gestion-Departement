package com.gestiondepartement.Service;

import com.gestiondepartement.Entity.Enseignant;

import java.util.List;

public interface EnseignantService {
    List<Enseignant> getAllTeacher();
    Enseignant addTeacher(Enseignant teacher);
    Enseignant getTeacherById(long teacherId);
    Enseignant updateTeacher(Enseignant teacher);
    void deleteTeacher(long teacherId);
}
