package com.gestiondepartement.endpoint;

import allapis.springbootsoap.com.*;
import com.gestiondepartement.Entity.Enseignant;
import com.gestiondepartement.Service.EnseignantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EnseignantEndPoint {
    private static final String NameSpace_URI="http://com.springbootsoap.allapis";
    @Autowired
    private EnseignantService enseignantService;
    @PayloadRoot(namespace = NameSpace_URI, localPart= "addTeacherRequest")
    @ResponsePayload
    public AddTeacherResponse addTeacher (@RequestPayload AddTeacherResponse request) {
        AddTeacherResponse response =new AddTeacherResponse();
        ServiceStatusTeacher serviceStatus =new ServiceStatusTeacher();
        Enseignant teacher =new Enseignant();
        BeanUtils.copyProperties((request.getTeacherInfo()), teacher);
        enseignantService.addTeacher(teacher);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Added Successfully");
        response.setServiceStatusTeacher(serviceStatus);
        return response;
    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "getTeacherByIdRequest")
    @ResponsePayload
    public GetTeacherResponse getTeacher (@RequestPayload GetTeacherByIdRequest request) {
        GetTeacherResponse response =new GetTeacherResponse();
        TeacherInfo teacherInfo =new TeacherInfo();

        BeanUtils.copyProperties(enseignantService.getTeacherById(request.getTeacherId()), teacherInfo);
        response.setTeacherInfo(teacherInfo);
        return response;

    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "updateTeacherRequest")
    @ResponsePayload
    public UpdateTeacherResponse updateTeacher (@RequestPayload UpdateTeacherRequest request) {
        Enseignant teacher =new Enseignant();
        BeanUtils.copyProperties(request.getTeacherInfo(), teacher);
        enseignantService.updateTeacher(teacher);
        ServiceStatusTeacher serviceStatus =new ServiceStatusTeacher();
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content Update Successfully");
        UpdateTeacherResponse response = new UpdateTeacherResponse();
        response.setServiceStatusTeacher(serviceStatus);
        return response;
    }
    @PayloadRoot (namespace = NameSpace_URI, localPart= "deleteTeacherRequest")
    @ResponsePayload
    public DeleteTeacherResponse deleteTeacher (@RequestPayload DeleteTeacherRequest request) {
        enseignantService.deleteTeacher(request.getTeacherId());
        ServiceStatusTeacher serviceStatus = new ServiceStatusTeacher();

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Content deleted Successfully");
        DeleteTeacherResponse response = new DeleteTeacherResponse();
        response.setServiceStatusTeacher(serviceStatus);
        return response;
    }
}

