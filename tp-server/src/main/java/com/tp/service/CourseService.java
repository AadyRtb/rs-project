package com.tp.service;

import com.tp.dto.CourseQueryDTO;
import com.tp.entity.Course;
import com.tp.vo.CourseQueryVO;

import java.util.List;

public interface CourseService {

    List<CourseQueryVO> getCourse(CourseQueryDTO courseQueryDTO);

    Course getCourseById(Integer id);
}
