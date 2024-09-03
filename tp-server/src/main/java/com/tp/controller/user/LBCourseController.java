package com.tp.controller.user;


import com.tp.dao.LbCreditDao;

import com.tp.dto.LbQueryDTO;
import com.tp.entity.LbCourse;
import com.tp.result.Result;
import com.tp.service.LBCourseService;
import com.tp.vo.CourseQueryVO;
import com.tp.vo.LBCreditVO;
import com.tp.vo.LbQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/lbcourse")
@Slf4j
@Api(tags= "公选课相关接口")
public class LBCourseController {

    @Autowired
    private LBCourseService lbCourseService;


    @GetMapping
    @ApiOperation("查询公选课情况")
    public Result<LBCreditVO> getLBCourseById(){

        LBCreditVO lbCreditVO = lbCourseService.getLBCourseById();

        return Result.success(lbCreditVO);
    }


    @GetMapping("/getLbCourse")
    @ApiOperation("查询公选课")
    public Result<List<LbQueryVO>> getCourse(LbQueryDTO courseQueryDTO){

        List<LbQueryVO> lbList = lbCourseService.getCourseList(courseQueryDTO);
        return Result.success(lbList);
    }

    @GetMapping("/{cid}")
    @ApiOperation("根据id查询")
    public Result<LbCourse> getCourseById(@PathVariable Integer cid){
        LbCourse lbCourse = lbCourseService.getCourseByCid(cid);
        return Result.success(lbCourse);
    }
}
