package com.tp.service.impl;

import com.tp.builder.LbCreditCounter;
import com.tp.constant.MessageConstant;
import com.tp.context.BaseContext;
import com.tp.dao.LbCreditDao;
import com.tp.dto.CreditUpdateDTO;
import com.tp.dto.PasswordEditDTO;
import com.tp.dto.StudentLoginDTO;
import com.tp.entity.Student;
import com.tp.mapper.CourseMapper;
import com.tp.mapper.LBCourseMapper;
import com.tp.mapper.StudentMapper;
import com.tp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import com.tp.exception.AccountNotFoundException;
import com.tp.exception.PasswordErrorException;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private LBCourseMapper lbCourseMapper;

    /**
     * 员工登录
     *
     * @param studentLoginDTO
     * @return
     */
    public Student login(StudentLoginDTO studentLoginDTO) {
        String id = studentLoginDTO.getId();
        String password = studentLoginDTO.getPassword();

        //1、根据用户名查询数据库中的数据
        Student student = studentMapper.getById(id);

        //2、处理各种异常情况（用户名不存在、密码不对、账号被锁定）
        if (student == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        //密码比对
        // TODO 后期需要进行md5加密，然后再进行比对
        password= DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password);
        if (!password.equals(student.getPassword())) {
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }



        //3、返回实体对象
        return  student;
    }

    @Override
    public void updatePassword(PasswordEditDTO passwordEditDTO)  {
        passwordEditDTO.setStuId(BaseContext.getCurrentId());
        System.out.println("修改密码"+passwordEditDTO);
        Student student= studentMapper.getById(passwordEditDTO.getStuId());
        passwordEditDTO.setOldPassword(DigestUtils.md5DigestAsHex(passwordEditDTO.getOldPassword().getBytes()));
        if(!student.getPassword().equals(passwordEditDTO.getOldPassword())){//        if(!passwordEditDTO.getOldPassword().equals(passwordEditDTO.getOldPassword())){
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        Student stu =Student.builder().password(DigestUtils.md5DigestAsHex(passwordEditDTO.getNewPassword().getBytes()))
                .id(passwordEditDTO.getStuId())
                .build();
        studentMapper.update(stu);
    }

    @Override
    public void updateCredit() {
        CreditUpdateDTO creditUpdateDTO = new CreditUpdateDTO();
        String sid = BaseContext.getCurrentId();
        creditUpdateDTO.setSid(sid);
        //获取该学生的公选课学分
        List<LbCreditDao> lbCreditList = lbCourseMapper.selectLbCredit(sid);
        LbCreditCounter lbCreditCounter = new LbCreditCounter(lbCreditList);
        Float lbCredit = lbCreditCounter.getTotalLibCredit();

        //获取该学生的总学分
        Float totalCredit = studentMapper.getTotalCredit(sid);
        totalCredit = totalCredit + lbCredit;

        //获取该学生的要求学分
        Float requireCredit = studentMapper.getRequiredCredit(sid);
        Float needcredit =  requireCredit - totalCredit;
        if (needcredit < 0) needcredit = 0f;
        creditUpdateDTO.setTotalCredit(totalCredit);
        creditUpdateDTO.setNeedCredit(needcredit);
        studentMapper.updateCredit(creditUpdateDTO);
    }

    @Override
    public Student getById(String currentId) {
        return studentMapper.getById(currentId);



    }

    @Override
    public Integer getUnFinished(String currentId) {
        return studentMapper.getUnFinished(currentId);
    }


}
