package com.rs.mapper;

import com.github.pagehelper.Page;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.entity.Food;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodMapper {

    /**
     * 分页查询
     * @param foodPageQueryDTO
     * @return
     */
    List<Food> pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    @Insert("insert into food (id,name,brand,price)"+
            "value" +
            "(#{id},#{name},#{brand},#{price})")
    void insert(Food food);

    @Select("select * from food where id=#{id}")
    Food getById(Long id);

    @Select("select * from food where name=#{name}")
    Food getByName(String name);
    void update(Food food);

    @Delete("delete from food where id =#{id}")
    void delete(Long id);

    @Select("select name from food where brand=#{brand}")
    List<String> selectNameByBrand(String brand);
}
