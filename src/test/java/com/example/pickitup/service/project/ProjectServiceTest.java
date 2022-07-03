<<<<<<< HEAD
package com.example.pickitup.service.project;

import com.example.pickitup.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
@Slf4j
public class ProjectServiceTest {
    @Autowired
    private ProjectService projectService;

//    @Test
//    public void getListJJimTest(){
//        log.info(projectService.getListJJim().toString());
//    }
//
//    @Test
//    public void getListPointTest(){
//        log.info(projectService.getListPoint().toString());
//    }

    @Test
    public void getListApplyTest() throws ParseException {
        log.info(projectService.getListApply().toString());
    }

    @Test
    public void getListCourseTest() throws ParseException {
        log.info(projectService.getListCourse("산").toString());
    }

}
=======
package com.example.pickitup.service.project;

import com.example.pickitup.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

@SpringBootTest
@Slf4j
public class ProjectServiceTest {
    @Autowired
    private ProjectService projectService;

//    @Test
//    public void getListJJimTest(){
//        log.info(projectService.getListJJim().toString());
//    }
//
//    @Test
//    public void getListPointTest(){
//        log.info(projectService.getListPoint().toString());
//    }

    @Test
    public void getListApplyTest() throws ParseException {
        log.info(projectService.getListApply().toString());
    }

    @Test
    public void getListCourseTest() throws ParseException {
        log.info(projectService.getListCourse("산").toString());
    }

}
>>>>>>> 383d576e94bb33cf289090cbcbef6df83f1d4878
