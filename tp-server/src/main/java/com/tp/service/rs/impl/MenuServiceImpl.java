package com.tp.service.rs.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tp.builder.MenuBuilder;
import com.tp.builder.MenuDirector;
import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.dto.rs.MenuDTO;
import com.tp.entity.rs.Menu;
import com.tp.mapper.rs.DrinkMapper;
import com.tp.mapper.rs.FoodMapper;
import com.tp.mapper.rs.MenuMapper;
import com.tp.mapper.rs.SnackMapper;
import com.tp.result.PageResult;
import com.tp.service.rs.MenuService;
import com.tp.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        menu.setSell(0);
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
