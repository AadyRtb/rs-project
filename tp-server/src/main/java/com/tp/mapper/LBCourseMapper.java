package com.tp.mapper;

import com.tp.dao.LbCreditDao;
import com.tp.dto.LbQueryDTO;
import com.tp.entity.LbCourse;
import com.tp.vo.LbQueryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LBCourseMapper {

    @Select("SELECT type,sum(credit) as sumCredit FROM liberal_course,lb_record\n" +
            "where liberal_course.cid=lb_record.cid\n" +
            "and sid=#{sid}\n" +
            "group by type;")
    List<LbCreditDao> selectLbCredit(String sid);

    List<LbQueryVO> selectLbCourseList(LbQueryDTO courseQueryDTO);

    @Select("select * from liberal_course where cid=#{cid}")
    LbCourse selectCourseByCid(Integer cid);
}
