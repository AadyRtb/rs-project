package com.rs.service;

import com.rs.dto.FoodPageQueryDTO;
import com.rs.dto.MenuDTO;
import com.rs.entity.Menu;
import com.rs.result.PageResult;
import com.rs.vo.MenuVo;



public interface MenuService {
    
    
    PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    void delete(Long id);

    void save(MenuDTO menuDTO);

    MenuVo getByBrand(String brand);

    Menu getById(Long id);
}
