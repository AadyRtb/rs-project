package com.tp.service.rs;


import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.dto.rs.SnackDTO;
import com.tp.entity.rs.Snack;
import com.tp.result.PageResult;

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
