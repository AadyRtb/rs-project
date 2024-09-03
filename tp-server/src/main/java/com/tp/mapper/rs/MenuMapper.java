package com.tp.mapper.rs;

import com.github.pagehelper.Page;
import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.dto.rs.MenuDTO;
import com.tp.entity.rs.Menu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
