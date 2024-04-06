package com.rs.service;

import com.rs.dto.FoodDTO;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.entity.Food;
import com.rs.result.PageResult;

public interface FoodService {

    /**
     * 商品分页查询
     * @param foodPageQueryDTO
     * @return
     */
    PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    void save(FoodDTO foodDTO);

    Food getById(Long id);

    void delete(Long id);

    void update(FoodDTO foodDTO);
}
