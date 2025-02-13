package com.GinElmaC.Redis.Controller;

import com.GinElmaC.Redis.Bean.Project;
import com.GinElmaC.Redis.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    public ProjectService projectService;

    @GetMapping("/project/init")
    public void init(){
        projectService.initProject();
    }

    @GetMapping("/project/get/{page}")
    public String find(@PathVariable("page") Integer page){
        return projectService.findProject(page).stream().toString();
    }

}
