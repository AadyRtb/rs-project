package com.tp.service.rs;

import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.dto.rs.MenuDTO;
import com.tp.entity.rs.Menu;
import com.tp.result.PageResult;
import com.tp.vo.MenuVo;



public interface MenuService {
    
    
    PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    void delete(Long id);

    void save(MenuDTO menuDTO);

    MenuVo getByBrand(String brand);

    Menu getById(Long id);
}
