package com.rs.mapper;

import com.github.pagehelper.Page;
import com.rs.dao.MenuDao;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.dto.MenuDTO;
import com.rs.entity.Food;
import com.rs.entity.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {
    /**
     * 分页查询
     * @param foodPageQueryDTO
     * @return
     */
    Page<MenuDTO> pageQuery(FoodPageQueryDTO foodPageQueryDTO);


    void insert(Menu menu);


    MenuDTO getById(Long id);

    @Select("select * from menu where name=#{name}")
    MenuDTO getByName(String name);
    void update(Menu menu);

    @Delete("delete from menu where id =#{id}")
    void delete(Long id);


}
