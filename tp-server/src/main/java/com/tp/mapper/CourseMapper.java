package com.tp.mapper;

import com.tp.dao.LbCreditDao;
import com.tp.dto.CourseQueryDTO;
import com.tp.entity.Course;
import com.tp.vo.CourseQueryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {

    /**
     * 查询所有课程
     * @param courseQueryDTO
     * @return
     */
    List<CourseQueryVO>   selectCourse(CourseQueryDTO courseQueryDTO);


    @Select("select * from course where cid = #{id}")
    Course getById(Integer id);
}
