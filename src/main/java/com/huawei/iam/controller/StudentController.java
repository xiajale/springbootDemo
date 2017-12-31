package com.huawei.iam.controller;

import com.huawei.iam.dto.HttpResult;
import com.huawei.iam.dto.Student;
import com.huawei.iam.exception.ExceptionEnum;
import com.huawei.iam.exception.IAMException;
import com.huawei.iam.repository.StudentRepository;
import com.huawei.iam.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouyibin on 2017/12/30.
 */
@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/students")
    public HttpResult studentList() throws Exception {
        int i = studentRepository.findAll().size();
        if(i == 1){
            logger.error(ExceptionEnum.CUSTOME_ERROR.getMessage());
            throw new IAMException(ExceptionEnum.CUSTOME_ERROR);
        }
        return HttpUtil.success(studentRepository.findAll());
    }

    @PostMapping(value = "/students")
    public Student studentAdd(@RequestBody @Valid Student student){
        return studentRepository.save(student);
    }

    @GetMapping(value = "/students/{id}")
    public Student studentById(@PathVariable String id){
        return studentRepository.findOne(id);
    }

    @Transactional
    @PutMapping(value = "/students")
    public Student studentPutById(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping(value = "/students/{id}")
    public void studentDel(@PathVariable String id){
        studentRepository.delete(id);
    }
}
