package com.tp.service.rs.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tp.dto.rs.FoodDTO;
import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.entity.rs.Food;
import com.tp.mapper.rs.FoodMapper;
import com.tp.result.PageResult;
import com.tp.service.rs.FoodService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;


    public void save(FoodDTO foodDTO){
        Food food=new Food();

        BeanUtils.copyProperties(foodDTO,food);
        food.setSell(0);

        foodMapper.insert(food);
    }

    public PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO){
        PageHelper.startPage(foodPageQueryDTO.getPage(),foodPageQueryDTO.getPageSize());
       List<Food> foodList=foodMapper.pageQuery(foodPageQueryDTO);
       List<Food> fl=new ArrayList<>();
       fl=foodList;
        Page<Food> page= (Page)fl;
        long total=page.getTotal();
        List<Food> records=page.getResult();
        System.out.println(new PageResult(total,records));
        return new PageResult(total,records);
    }

    public Food getById(Long id) {
        Food food = foodMapper.getById(id);
        return food;
    }

    public Food getByName(String name) {
        Food food = foodMapper.getByName(name);
        return food;
    }

    @Override
    public void delete(Long id) {
        foodMapper.delete(id);
        return;
    }

    /**
     * 编辑餐品信息
     * @param foodDTO
     */
    public void update(FoodDTO foodDTO){
        Food food= new Food();
        BeanUtils.copyProperties(foodDTO,food);
        foodMapper.update(food);
    }
}
