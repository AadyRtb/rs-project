package com.rs.service;


import com.rs.dto.FoodPageQueryDTO;
import com.rs.dto.SnackDTO;
import com.rs.entity.Snack;
import com.rs.result.PageResult;

public interface SnackService {
    /**
     * 商品分页查询
     * @param foodPageQueryDTO
     * @return
     */
    PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO);

    void save(SnackDTO snackDTO);

    Snack getById(Long id);

    Snack getByName(String name);

    void delete(Long id);

    void update(SnackDTO snackDTO);
}
