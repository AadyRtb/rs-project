package com.tp.mapper;

import com.tp.dto.CreditUpdateDTO;
import com.tp.entity.Student;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
    /**
     * 根据用户名查询员工
     * @param id
     * @return
     */
    @Select("select * from student where id = #{id}")
    Student getById(String id);

    /**
     *  更新信息
     * @param student
     */
    void update(Student student);

    /**
     * 更新学分
     * @param creditUpdateDTO
     */
    @Update(" update student set total_credit=#{totalCredit} ,need_credit=#{needCredit} where id=#{sid}")
    void updateCredit(CreditUpdateDTO creditUpdateDTO);

    /**
     * 获取要求的学分
     * @param id
     * @return
     */
    @Select(" select required_credit from major,student\n" +
            "   where student.major=major.mname\n" +
            "   and student.id= #{id} ;")
    Float getRequiredCredit(String id);

    /**
     * 获取已修读的学分
     * @param id
     * @return
     */
    @Select("SELECT SUM(credit)  FROM record , course\n" +
            "where record.cid=course.cid and record.sid=#{id} ;")
    Float getTotalCredit(String id);

    @Select("SELECT count(*) FROM student,major,major_course\n" +
            "where student.major=major.mname\n" +
            "and major.mid=major_course.mid\n" +
            "and major_course.type=0\n" +
            "and student.id=#{currentId} \n" +
            "and cid not in(SELECT record.cid FROM record , course\n" +
            "                    where record.cid=course.cid\n" +
            "                    and record.sid=#{currentId});")
    Integer getUnFinished(String currentId);
}
