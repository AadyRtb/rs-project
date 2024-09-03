package com.tp.service;

import com.tp.dto.LbQueryDTO;
import com.tp.entity.LbCourse;
import com.tp.vo.LBCreditVO;
import com.tp.vo.LbQueryVO;

import java.util.List;

public interface LBCourseService {
     List<LbQueryVO> getCourseList(LbQueryDTO courseQueryDTO);

    LBCreditVO getLBCourseById();

    LbCourse getCourseByCid(Integer cid);
}
