package com.arkarmoe.file_managment_system.controller;

import com.arkarmoe.file_managment_system.model.Project;
import com.arkarmoe.file_managment_system.report.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Arkar Moe
 * 11-Sept-2019
 * **/
@RequestMapping("/project")
@RestController
public class ProjectController {
    private Logger logger = LoggerFactory.getLogger(ProjectController.class);

    //export excel
    @GetMapping("/export")
    public ResponseEntity<InputStreamResource> downloadProjectReport(){
        logger.info("[START] Downloading the project export file.");

        try{

            List<Project> projectList = new ArrayList<>();
            projectList.add(new Project("AYY0001","Ayarwaddy","A","200km","Edotco",new Date(),2000.3));
            projectList.add(new Project("AYY0002","Ayarwaddy","A","200km","Edotco",new Date(),2000.3));
            projectList.add(new Project("AYY0003","Ayarwaddy","A","200km","Edotco",new Date(),2000.3));
            projectList.add(new Project("AYY0004","Ayarwaddy","A","200km","Edotco",new Date(),2000.3));
            projectList.add(new Project("AYY0005","Ayarwaddy","A","200km","Edotco",new Date(),2000.3));

            ResponseEntity<InputStreamResource> status = new Report().exportExcel(projectList);
            return status;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
