package com.tp.controller.user;

import com.tp.dto.CourseQueryDTO;
import com.tp.entity.Course;
import com.tp.result.Result;
import com.tp.vo.CourseQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.tp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/course")
@Slf4j
@Api(tags= "课程相关接口")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/getCourse")
    @ApiOperation("获取课程信息")
    public Result<List<CourseQueryVO>> getCourse(CourseQueryDTO courseQueryDTO){

        List<CourseQueryVO> courseQueryVOList = courseService.getCourse(courseQueryDTO);
        return Result.success(courseQueryVOList);
    }

    @GetMapping("/{cid}")
    @ApiOperation("根据id获取课程信息")
    public Result<Course> getCourseById(@PathVariable Integer cid) {
        Course course = courseService.getCourseById(cid);
        return Result.success(course);
    }
}
