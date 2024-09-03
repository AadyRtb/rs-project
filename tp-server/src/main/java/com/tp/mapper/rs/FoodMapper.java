package com.tp.mapper.rs;

import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.entity.rs.Food;
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

    /**
     * 新增食品
     * @param food
     */
    @Insert("insert into food (id,name,brand,price)"+
            "value" +
            "(#{id},#{name},#{brand},#{price})")
    void insert(Food food);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from food where id=#{id}")
    Food getById(Long id);

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    @Select("select * from food where name=#{name}")
    Food getByName(String name);

    /**
     *  更新食品
     * @param food
     */
    void update(Food food);

    /**
     * 删除食品
     * @param id
     */
    @Delete("delete from food where id =#{id}")
    void delete(Long id);

    /**
     * 根据品牌查询名字
     * @param brand
     * @return
     */
    @Select("select name from food where brand=#{brand}")
    List<String> selectNameByBrand(String brand);
}
