package com.rs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rs.dto.DrinkDTO;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.entity.Drink;
import com.rs.mapper.DrinkMapper;
import com.rs.result.PageResult;
import com.rs.service.DrinkService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {
    @Autowired
    private DrinkMapper drinkMapper;


    public void save(DrinkDTO drinkDTO){
        Drink drink=new Drink();
        BeanUtils.copyProperties(drinkDTO,drink);
        drinkMapper.insert(drink);
    }

    public PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO){
        PageHelper.startPage(foodPageQueryDTO.getPage(),foodPageQueryDTO.getPageSize());

        Page<Drink> page= drinkMapper.pageQuery(foodPageQueryDTO);
        long total=page.getTotal();
        List<Drink> records=page.getResult();
        System.out.println(new PageResult(total,records));
        return new PageResult(total,records);
    }

    public Drink getById(Long id) {
        System.out.println("调用drinkService");
        Drink drink = drinkMapper.getById(id);
        return drink;
    }

    public Drink getByName(String name) {
        Drink drink = drinkMapper.getByName(name);
        return drink;
    }

    @Override
    public void delete(Long id) {
        drinkMapper.delete(id);
        return;
    }

    /**
     * 编辑餐品信息
     * @param drinkDTO
     */
    public void update(DrinkDTO drinkDTO){
        Drink drink= new Drink();
        BeanUtils.copyProperties(drinkDTO,drink);
        drinkMapper.update(drink);
    }
}
