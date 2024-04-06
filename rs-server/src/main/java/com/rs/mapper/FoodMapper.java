package com.rs.mapper;

import com.github.pagehelper.Page;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.entity.Food;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FoodMapper {

    /**
     * 分页查询
     * @param foodPageQueryDTO
     * @return
     */
    Page<Food> pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    @Insert("insert into food (id,name,brand,price,sell)"+
            "value" +
            "(#{id},#{name},#{brand},#{price},#{sell})")
    void insert(Food food);

    @Select("select * from food where id=#{id}")
    Food getById(Long id);

    void update(Food food);

    @Delete("delete from food where id =#{id}")
    void delete(Long id);
}
