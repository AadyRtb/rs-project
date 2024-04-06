package com.rs.mapper;


import com.github.pagehelper.Page;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.entity.Food;
import com.rs.entity.Snack;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SnackMapper {
    /**
     * 分页查询
     * @param foodPageQueryDTO
     * @return
     */
    Page<Snack> pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    @Insert("insert into snack (id,name,brand,price,sause)"+
            "value" +
            "(#{id},#{name},#{brand},#{price},#{sause})")
    void insert(Snack snack);

    @Select("select * from snack where id=#{id}")
    Snack getById(Long id);

    void update(Snack snack);

    @Delete("delete from snack where id =#{id}")
    void delete(Long id);
}
