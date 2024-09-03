package com.tp.service.rs.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.dto.rs.SnackDTO;
import com.tp.entity.rs.Snack;
import com.tp.mapper.rs.SnackMapper;
import com.tp.result.PageResult;
import com.tp.service.rs.SnackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SnackServiceImpl implements SnackService {
    @Autowired
    private SnackMapper snackMapper;


    public void save(SnackDTO snackDTO){
        Snack snack=new Snack();

        BeanUtils.copyProperties(snackDTO,snack);


        snackMapper.insert(snack);
    }

    public PageResult pageQuery(FoodPageQueryDTO foodPageQueryDTO){
        PageHelper.startPage(foodPageQueryDTO.getPage(),foodPageQueryDTO.getPageSize());

        Page<Snack> page= snackMapper.pageQuery(foodPageQueryDTO);
        long total=page.getTotal();
        List<Snack> records=page.getResult();
        System.out.println(new PageResult(total,records));
        return new PageResult(total,records);
    }

    public Snack getById(Long id) {
        Snack snack = snackMapper.getById(id);
        return snack;
    }

    public Snack getByName(String name) {
        Snack snack = snackMapper.getByName(name);
        return snack;
    }

    @Override
    public void delete(Long id) {
        snackMapper.delete(id);
        return;
    }

    /**
     * 编辑餐品信息
     * @param snackDTO
     */
    public void update(SnackDTO snackDTO){
        Snack snack= new Snack();
        BeanUtils.copyProperties(snackDTO,snack);
        snackMapper.update(snack);
    }
}
