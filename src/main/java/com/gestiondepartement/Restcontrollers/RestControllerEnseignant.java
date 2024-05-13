package com.gestiondepartement.Restcontrollers;

import com.gestiondepartement.Entity.Enseignant;
import com.gestiondepartement.Service.EnseignantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class RestControllerEnseignant {
    @Autowired
    private EnseignantServiceImp teacherServiceImp;

    @GetMapping("/all")
    public List<Enseignant> getallTeachers(){
        return teacherServiceImp.getAllTeacher();
    }

    @PostMapping("/save")
    public Enseignant addTeacher(@RequestBody Enseignant teacher){
        return teacherServiceImp.addTeacher(teacher);
    }

    @GetMapping("/getone/{id}")
    public Enseignant getOneTeacher(@PathVariable Long id){
        return teacherServiceImp.getTeacherById(id);
    }

    @PutMapping("/update/{id}")
    public Enseignant updateTeacher(@PathVariable Long id, @RequestBody Enseignant teacher){
        Enseignant teacher1 = teacherServiceImp.getTeacherById(id);
        if (teacher1 != null){
            teacher.setId(id);
            return teacherServiceImp.updateTeacher(teacher);
        }else {
            throw new RuntimeException("Failled !!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteTeacher(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (teacherServiceImp.getTeacherById(id) == null){
            message.put("etat", "teacher not found");
            return message;
        }
        try {
            teacherServiceImp.deleteTeacher(id);
            message.put("etat", "teacher deleted");
            return message;
        }catch (Exception e){
            message.put("etat", "teacher not deleted");
            return message;
        }
    }
}
