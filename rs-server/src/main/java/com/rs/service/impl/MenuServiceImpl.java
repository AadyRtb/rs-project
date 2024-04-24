package com.rs.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.rs.builder.MenuBuilder;
import com.rs.builder.MenuDirector;
import com.rs.dao.MenuDao;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.dto.MenuDTO;
import com.rs.dto.SnackDTO;
import com.rs.entity.Food;
import com.rs.entity.Menu;
import com.rs.entity.Snack;
import com.rs.mapper.DrinkMapper;
import com.rs.mapper.FoodMapper;
import com.rs.mapper.MenuMapper;
import com.rs.mapper.SnackMapper;
import com.rs.result.PageResult;
import com.rs.service.MenuService;
import com.rs.vo.MenuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private DrinkMapper drinkMapper;
    @Autowired
    private SnackMapper snackMapper;


    public void save(MenuDTO menuDTO){
        MenuBuilder builder=new MenuBuilder(foodMapper,snackMapper,drinkMapper);
        MenuDirector director=new MenuDirector(builder);
        Menu menu=director.constructByName(menuDTO.getFoodName(), menuDTO.getSnackName(), menuDTO.getDrinkName());
//        Food food=foodMapper.getByName(menuDTO.getFoodName());
//        menu=director.construct(food,snackMapper.getByName( menuDTO.getSnackName()),drinkMapper.getByName(menuDTO.getDrinkName()));
        menu.setPrice(menuDTO.getPrice());
        menu.setName(menuDTO.getName());
        menu.setBrand(menuDTO.getBrand());
        System.out.println(menu);
        menuMapper.insert(menu);
    }


    public MenuVo getByBrand(String brand) {
        MenuVo menuVo=new MenuVo();
        menuVo.setFoodName(foodMapper.selectNameByBrand(brand));
        menuVo.setSnackName(snackMapper.selectNameByBrand(brand));
        menuVo.setDrinkName(drinkMapper.selectNameByBrand(brand));
        return menuVo;
    }

    @Override
    public Menu getById(Long id) {
        MenuDTO menuDTO= menuMapper.getById(id);
        MenuBuilder builder=new MenuBuilder(foodMapper,snackMapper,drinkMapper);
        MenuDirector director=new MenuDirector(builder);
        Menu menu=director.constructByName(menuDTO.getFoodName(), menuDTO.getSnackName(), menuDTO.getDrinkName());
        menu.setPrice(menuDTO.getPrice());
        menu.setName(menuDTO.getName());
        menu.setBrand(menuDTO.getBrand());
        menu.setId(menuDTO.getId());
        menu.setStatus(1);
        menu.setSell(menuDTO.getSell());
        return menu;
    }

    public PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO){
        PageHelper.startPage(foodPageQueryDTO.getPage(),foodPageQueryDTO.getPageSize());

        Page<MenuDTO> page= menuMapper.pageQuery(foodPageQueryDTO);

        long total=page.getTotal();
        List<MenuDTO> records=page.getResult();
        System.out.println(new PageResult(total,records));
        return new PageResult(total,records);
    }


    @Override
    public void delete(Long id) {
        menuMapper.delete(id);
    }
}
