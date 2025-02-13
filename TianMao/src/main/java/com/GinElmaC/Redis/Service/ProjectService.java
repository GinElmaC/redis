package com.GinElmaC.Redis.Service;

import com.GinElmaC.Redis.Bean.Project;

import java.util.List;

public interface ProjectService {
    public void initProject();
    public List<Project> findProject(int page);
    public void initAB(int page);
    public List<Project> findAB(int page);
}
