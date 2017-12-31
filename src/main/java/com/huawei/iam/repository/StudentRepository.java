package com.huawei.iam.repository;

import com.huawei.iam.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by zhouyibin on 2017/12/30.
 */
public interface StudentRepository extends JpaRepository<Student, String> {

    public List<Student> findByAge(int age);
}
