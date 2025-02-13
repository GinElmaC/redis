package com.GinElmaC.Redis.Service.Impl;

import com.GinElmaC.Redis.Bean.Project;
import com.GinElmaC.Redis.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class ProjectServiceImpl implements ProjectService {
    public static String KEY = "jhs";
    public static String KEY_A = "jhs_a";
    public static String KEY_B = "jhs_b";

    @Autowired
    public RedisTemplate redisTemplate;

    public List<Project> getProjectList(){
        List<Project> projects = new ArrayList<>();
        Random r = new Random();
        for(int i = 0;i<100;i++){
            int id = r.nextInt(10000)+1;
            double price = r.nextDouble()+1.0;
            Project project = new Project(KEY+id,id,price,KEY+price);
            projects.add(project);
        }
        return projects;
    }

    @Override
    public void initProject() {
        new Thread(()->{
            while(true){
                List<Project> projectList = this.getProjectList();
                redisTemplate.delete(KEY);
                redisTemplate.opsForList().leftPushAll(KEY,projectList);
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t1").start();
    }

    @Override
    public List<Project> findProject(int page) {
        int size = 5;
        List<Project> projectList = null;
        int start = (page-1)*size;
        int end = start+size-1;

        try {
            projectList = redisTemplate.opsForList().range(projectList,start,end);
            if(projectList == null){
                //TODO 走db查询
            }
        } catch (Exception e) {
            //redis查询出错，可能是redis网络问题
            //TODO 走db查询
        }
        return projectList;
    }

    @Override
    public void initAB(int page) {
        new Thread(()->{
            while(true){
                List<Project> projectList = this.getProjectList();
                //先更新B
                redisTemplate.delete(KEY_B);
                redisTemplate.opsForList().leftPushAll(KEY_B,projectList);
                //在更新A
                redisTemplate.delete(KEY_A);
                redisTemplate.opsForList().leftPushAll(KEY_A,projectList);
                try {
                    TimeUnit.MINUTES.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"t1").start();
    }

    @Override
    public List<Project> findAB(int page) {
        int size = 5;
        List<Project> projectList = null;
        int start = (page-1)*size;
        int end = start+size-1;

        try {
            //先查询A
            projectList = redisTemplate.opsForList().range(KEY_A,start,end);
            if(projectList != null && projectList.size() != 0){
                return projectList;
            }
            //再查询B
            projectList = redisTemplate.opsForList().range(KEY_B,start,end);
            if(projectList != null && projectList.size() != 0){
                return projectList;
            }
            //TODO 走DB查询
        } catch (Exception e) {
            //redis查询出错，可能是redis网络问题
            //TODO 走DB查询
        }
        return projectList;
    }
}
