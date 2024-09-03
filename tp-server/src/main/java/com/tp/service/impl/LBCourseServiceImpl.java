package com.tp.service.impl;


import com.tp.builder.LbCreditCounter;
import com.tp.context.BaseContext;
import com.tp.dao.LbCreditDao;
import com.tp.dto.LbQueryDTO;
import com.tp.entity.LbCourse;
import com.tp.mapper.LBCourseMapper;
import com.tp.service.LBCourseService;
import com.tp.vo.CourseQueryVO;
import com.tp.vo.LBCreditVO;
import com.tp.vo.LbQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LBCourseServiceImpl implements LBCourseService {

    @Autowired
    private LBCourseMapper lbCourseMapper;

    @Override
    public List<LbQueryVO> getCourseList(LbQueryDTO lbQueryDTO) {
        lbQueryDTO.setSid(BaseContext.getCurrentId());
        if (lbQueryDTO.getFlag() == 1 || lbQueryDTO.getFlag() == 2) {
            List<LbQueryVO> lbQueryList = lbCourseMapper.selectLbCourseList(lbQueryDTO);
            for (LbQueryVO lbQueryVO : lbQueryList ) {
                lbQueryVO.setState(lbQueryDTO.getFlag());
            }
            return lbQueryList;
        } else  {
            lbQueryDTO.setFlag(1);
            List<LbQueryVO> lbQueryList1 = lbCourseMapper.selectLbCourseList(lbQueryDTO);
            for (LbQueryVO lbQueryVO : lbQueryList1) {
                lbQueryVO.setState(lbQueryDTO.getFlag());
            }
            lbQueryDTO.setFlag(2);
            List<LbQueryVO> lbQueryList2 = lbCourseMapper.selectLbCourseList(lbQueryDTO);
            for (LbQueryVO lbQueryVO : lbQueryList2) {
                lbQueryVO.setState(lbQueryDTO.getFlag());
            }
            lbQueryList1.addAll(lbQueryList2);
            return lbQueryList1;
        }
    }

    @Override
    public LBCreditVO getLBCourseById() {
        List<LbCreditDao> lbCreditList = lbCourseMapper.selectLbCredit(BaseContext.getCurrentId());
        LbCreditCounter lbCreditCounter = new LbCreditCounter(lbCreditList);
        LBCreditVO lbCreditVO = lbCreditCounter.getLbCredit();
        return lbCreditVO;
    }

    @Override
    public LbCourse getCourseByCid(Integer cid) {
        return lbCourseMapper.selectCourseByCid(cid);
    }
}
