package com.tp.builder;

import com.tp.dao.LbCreditDao;
import com.tp.vo.LBCreditVO;

import java.util.List;

public class LbCreditCounter {
    private List<LbCreditDao> list;

    public LbCreditCounter(List<LbCreditDao> list) {
        this.list = list;
    }
    public List<LbCreditDao> getList() {
        return list;
    }

    public void setList(List<LbCreditDao> list) {
        this.list = list;
    }

    public float getTotalLibCredit(){
        float lg=0,yx=0,jg=0,my=0,sx=0,sk=0;//对应各个公选课的学分
        for(LbCreditDao lbCreditDao : list){
            switch (lbCreditDao.getType()){
                case "理工类":lg+=lbCreditDao.getSumCredit();break;
                case "医学类":yx+=lbCreditDao.getSumCredit();break;
                case "经济管理类":jg+=lbCreditDao.getSumCredit();break;
                case "美育教育类":my+=lbCreditDao.getSumCredit();break;
                case "思想政治及新时代素质教育类":sx+=lbCreditDao.getSumCredit();break;
                case "人文社科类":sk+=lbCreditDao.getSumCredit();break;
                default:break;
            }
        }
        float temp=lg+yx+jg+sk;
        if(my>2) my=2;
        if(sx>2) sx=2;
        if(temp>3) temp=3;
        return temp+my+sx;
    }

    public LBCreditVO getLbCredit(){
        float lg=0,yx=0,jg=0,my=0,sx=0,sk=0;//对应各个公选课的学分
        for(LbCreditDao lbCreditDao : list){
            switch (lbCreditDao.getType()){
                case "理工类":lg+=lbCreditDao.getSumCredit();break;
                case "医学类":yx+=lbCreditDao.getSumCredit();break;
                case "经济管理类":jg+=lbCreditDao.getSumCredit();break;
                case "美育教育类":my+=lbCreditDao.getSumCredit();break;
                case "思想政治及新时代素质教育类":sx+=lbCreditDao.getSumCredit();break;
                case "人文社科类":sk+=lbCreditDao.getSumCredit();break;
                default:break;
            }
        }
        LBCreditVO lbCreditVO=LBCreditVO.builder()
                .jg(jg)
                .yx(yx)
                .lg(lg)
                .sk(sk)
                .sx(sx)
                .my(my)
                .build();
        return lbCreditVO;
    }

}
