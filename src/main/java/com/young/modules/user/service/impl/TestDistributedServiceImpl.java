package com.young.modules.user.service.impl;

import com.young.facade.model.UserInfo;
import com.young.facade.service.IUserService;
import com.young.modules.primary.bean.UsersInfo;
import com.young.modules.primary.dao.UsersDao;
import com.young.modules.secondary.bean.Student;
import com.young.modules.secondary.dao.StudentDao;
import com.young.modules.user.service.TestDistributedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mc on 17/9/1.
 */

@Service
public class TestDistributedServiceImpl implements TestDistributedService{


   @Autowired
    StudentDao studentDao;

    @Autowired
    IUserService userService;
    @Transactional
    @Override
    public void TestDistribute(String isDistribute) {
        UserInfo usersInfo = new UserInfo();
        usersInfo.setFname("James");
        usersInfo.setLname("Harden");

        userService.insertUserInfo(usersInfo);

        Student student = new Student();
        student.setName("James");
        student.setAge(34);
        student.setSchool("Cleaveland");
        studentDao.insertStudent(student);
        if(!"1".equals(isDistribute)){
            throw  new RuntimeException("测试分布式事务");
        }
    }
}
