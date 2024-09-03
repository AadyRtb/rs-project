package com.tp.service.rs;

import com.tp.dto.rs.FoodDTO;
import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.entity.rs.Food;
import com.tp.result.PageResult;

public interface FoodService {

    /**
     * 商品分页查询
     * @param foodPageQueryDTO
     * @return
     */
    PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    void save(FoodDTO foodDTO);

    Food getById(Long id);
    Food getByName(String name);

    void delete(Long id);

    void update(FoodDTO foodDTO);
}
