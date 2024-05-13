package com.gestiondepartement.endpoint;

import allapis.springbootsoap.com.*;
import com.gestiondepartement.Entity.Etudiant;
import com.gestiondepartement.Service.EtudiantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EtudiantEndPoint {
    private static final String NameSpace_URI="http://com.springbootsoap.allapis";
    @Autowired
    private EtudiantService etudiantService;
    @PayloadRoot(namespace = NameSpace_URI, localPart= "addStudentRequest")
    @ResponsePayload
    public AddStudentResponse addStudent (@RequestPayload AddStudentResponse request) {
        AddStudentResponse response=new AddStudentResponse();
        ServiceStatusStudent serviceStatus=new ServiceStatusStudent();
        Etudiant student =new Etudiant();
        BeanUtils.copyProperties((request.getStudentInfo()), student);
        etudiantService.addStudent(student);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
        response.setServiceStatusStudent(serviceStatus);
        return response;
    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "getStudentByIdRequest")
    @ResponsePayload
    public GetStudentResponse getStudent (@RequestPayload GetStudentByIdRequest request) {
        GetStudentResponse response=new GetStudentResponse();
        StudentInfo studentInfo =new StudentInfo();

        BeanUtils.copyProperties(etudiantService.getStudentById(request.getStudentId()), studentInfo);
        response.setStudentInfo(studentInfo);
        return response;

    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudent (@RequestPayload UpdateStudentRequest request) {
        Etudiant student =new Etudiant();
        BeanUtils.copyProperties(request.getStudentInfo(), student);
        etudiantService.updateStudent(student);
        ServiceStatusStudent serviceStatus =new ServiceStatusStudent();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Update Successfully");
        UpdateStudentResponse response= new UpdateStudentResponse();
        response.setServiceStatusStudent(serviceStatus);
        return response;
    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "deleteStudentRequest")
    @ResponsePayload
    public DeleteStudentResponse deleteStudent (@RequestPayload DeleteStudentRequest request) {
        etudiantService.deleteStudent(request.getStudentId());
        ServiceStatusStudent serviceStatus =new ServiceStatusStudent();

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content deleted Successfully");
        DeleteStudentResponse response = new DeleteStudentResponse();
        response.setServiceStatusStudent(serviceStatus);
        return response;
    }
}
