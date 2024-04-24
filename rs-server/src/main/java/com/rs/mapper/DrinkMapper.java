package com.rs.mapper;

import com.github.pagehelper.Page;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.entity.Drink;
import com.rs.entity.Snack;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DrinkMapper {
    /**
     * 分页查询
     * @param foodPageQueryDTO
     * @return
     */
    Page<Drink> pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    @Insert("insert into drink (id,name,brand,price,temperature,sugar)"+
            "value" +
            "(#{id},#{name},#{brand},#{price},#{temperature},#{sugar})")
    void insert(Drink drink);

    @Select("select * from drink where id=#{id}")
    Drink getById(Long id);

    @Select("select * from drink where name=#{name}")
    Drink getByName(String name);
    void update(Drink drink);

    @Delete("delete from drink where id =#{id}")
    void delete(Long id);

    @Select("select name from drink where brand=#{brand}")
    List<String> selectNameByBrand(String brand);
}
