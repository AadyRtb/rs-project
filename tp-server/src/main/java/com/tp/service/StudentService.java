package com.tp.service;
import com.tp.dto.PasswordEditDTO;
import com.tp.dto.StudentLoginDTO;
import com.tp.entity.Student;

public interface StudentService {

    /**
     * 学生登录
     * @param studentLoginDTO
     * @return
     */
    Student login(StudentLoginDTO studentLoginDTO);

    void updatePassword(PasswordEditDTO passwordEditDTO);

    void updateCredit();

    Student getById(String currentId);

    Integer getUnFinished(String currentId);
}
