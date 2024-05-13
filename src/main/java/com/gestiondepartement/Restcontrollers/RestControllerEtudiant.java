package com.gestiondepartement.Restcontrollers;

import com.gestiondepartement.Entity.Etudiant;
import com.gestiondepartement.Service.EtudiantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student")
public class RestControllerEtudiant {
    @Autowired
    private EtudiantServiceImp studentServiceImp;

    @GetMapping("/all")
    public List<Etudiant> getallStudents(){
        return studentServiceImp.getAllStudents();
    }

    @PostMapping("/save")
    public Etudiant addStudent(@RequestBody Etudiant student){
        return studentServiceImp.addStudent(student);
    }

    @GetMapping("/getone/{id}")
    public Etudiant getOneStudent(@PathVariable Long id){
        return studentServiceImp.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Etudiant updateStudent(@PathVariable Long id, @RequestBody Etudiant student){
        Etudiant student1 = studentServiceImp.getStudentById(id);
        if (student1 != null){
            student.setId(id);
            return studentServiceImp.updateStudent(student);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteStudent(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (studentServiceImp.getStudentById(id) == null){
            message.put("etat", "student not found");
            return message;
        }
        try {
            studentServiceImp.deleteStudent(id);
            message.put("etat", "student deleted");
            return message;
        }catch (Exception e){
            message.put("etat", "student not deleted");
            return message;
        }
    }
}
