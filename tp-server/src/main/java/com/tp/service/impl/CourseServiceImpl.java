package com.tp.service.impl;

import com.tp.context.BaseContext;
import com.tp.dto.CourseQueryDTO;
import com.tp.entity.Course;
import com.tp.entity.Student;
import com.tp.mapper.CourseMapper;
import com.tp.mapper.StudentMapper;
import com.tp.service.CourseService;
import com.tp.vo.CourseQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<CourseQueryVO> getCourse(CourseQueryDTO courseQueryDTO) {

        String id = BaseContext.getCurrentId();
        Student student = studentMapper.getById(id);
        String major = student.getMajor();
        courseQueryDTO.setMajor(major);
        courseQueryDTO.setSid(id);
        if (courseQueryDTO.getFlag() == 1 || courseQueryDTO.getFlag() == 2) {
            List<CourseQueryVO> courseList = courseMapper.selectCourse(courseQueryDTO);
            for (CourseQueryVO courseQueryVO : courseList) {
                courseQueryVO.setState(courseQueryDTO.getFlag());
            }
            return courseList;
        } else  {
            courseQueryDTO.setFlag(1);
            List<CourseQueryVO> courseList1 = courseMapper.selectCourse(courseQueryDTO);
            for (CourseQueryVO courseQueryVO : courseList1) {
                courseQueryVO.setState(courseQueryDTO.getFlag());
            }
            courseQueryDTO.setFlag(2);
            List<CourseQueryVO> courseList2 = courseMapper.selectCourse(courseQueryDTO);
            for (CourseQueryVO courseQueryVO : courseList2) {
                courseQueryVO.setState(courseQueryDTO.getFlag());
            }
            courseList1.addAll(courseList2);
            return courseList1;
        }

    }

    @Override
    public Course getCourseById(Integer id) {
        return courseMapper.getById(id);
    }

}
