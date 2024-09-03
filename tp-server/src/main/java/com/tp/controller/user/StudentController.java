package com.tp.controller.user;

import com.tp.constant.JwtClaimsConstant;
import com.tp.context.BaseContext;
import com.tp.dto.PasswordEditDTO;
import com.tp.dto.StudentLoginDTO;
import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.entity.StudentInfo;
import com.tp.properties.JwtProperties;
import com.tp.result.PageResult;
import com.tp.result.Result;
import com.tp.service.StudentService;
import com.tp.utils.JwtUtil;
import com.tp.vo.StudentLoginVO;
import com.tp.vo.StudentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tp.entity.Student;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/student")
@Slf4j
@Api(tags= "学生相关接口")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     *
     * @param studentLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "学生登录")
    public Result<StudentLoginVO> login(@RequestBody StudentLoginDTO studentLoginDTO) {
        log.info("员工登录：{}", studentLoginDTO);

        Student student = studentService.login(studentLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        BaseContext.setCurrentId(student.getId());
        log.info("当前用户id：{}", BaseContext.getCurrentId());
        claims.put(JwtClaimsConstant.STU_ID, student.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getAdminSecretKey(),
                jwtProperties.getAdminTtl(),
                claims);

        StudentLoginVO studentLoginVO = StudentLoginVO.builder()
                .id(student.getId())
                .name(student.getName())
                .token(token)
                .build();

        ///
        StudentInfo studentInfo = StudentInfo.getStudentInfo();
        studentInfo.setId(student.getId());
        studentInfo.setName(student.getName());
        studentInfo.setMajor(student.getMajor());
        studentInfo.setNeedCredit(student.getNeedCredit());
        studentInfo.setTotalCredit(student.getTotalCredit());

        ///
        return Result.success(studentLoginVO);
    }

    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation(" 退出")
    public Result<String> logout() {
        return Result.success();
    }

    @PutMapping("/editPassword")
    @ApiOperation(" 修改密码")
    public Result<Object> editPassword(@RequestBody PasswordEditDTO passwordEditDTO) {
        log.info("密码： {}", passwordEditDTO);
        studentService.updatePassword(passwordEditDTO);
        return Result.success();
    }


    @PutMapping
    @ApiOperation("更新学分信息")
    public Result<String> updateCredit()
    {
        studentService.updateCredit();
        return Result.success();
    }

    @GetMapping
    @ApiOperation("查询学生信息")
    public Result<StudentVO> getStudent(){
        Student student = studentService.getById(BaseContext.getCurrentId());
        student.setPassword("*********");
        StudentVO studentVO = new StudentVO(student);
        studentVO.setUnFinished(studentService.getUnFinished(BaseContext.getCurrentId()));
        return Result.success(studentVO);
    }

}
