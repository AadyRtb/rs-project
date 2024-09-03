package com.tp.controller.admin;

import com.tp.dto.rs.DrinkDTO;
import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.entity.rs.Drink;
import com.tp.result.PageResult;
import com.tp.result.Result;
import com.tp.service.rs.DrinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/drink")
@Slf4j
@Api(tags= "饮料相关接口")
public class DrinkController {
    @Autowired
    private DrinkService drinkService;


    /**
     * 新增饮料
     * @param drinkDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增饮料")
    public Result save(@RequestBody DrinkDTO drinkDTO){
        log.info("新增饮料: {}",drinkDTO);
        drinkService.save(drinkDTO);
        return  Result.success();
    }

    /**
     * 分页查询
     * @param foodPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("饮料分页查询")
    public Result<PageResult> page(FoodPageQueryDTO foodPageQueryDTO){
        log.info("饮料分页查询，参数是：{}",foodPageQueryDTO);
        PageResult pageResult= drinkService.pageQuery(foodPageQueryDTO);
        return Result.success(pageResult);

    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查饮料信息")
    public Result<Drink> getById(@PathVariable Long id){
        log.info("饮料id查询，参数是：{}",id);
        Drink drink= drinkService.getById(id);
        return Result.success(drink);
    }

    /**
     * 根据id删除饮料
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除饮料")
    public Result delete(@PathVariable Long id){
        drinkService.delete(id);
        return Result.success();
    }

    /**
     * 编辑饮料信息
     * @param drinkDTO
     * @return
     */
    @PutMapping
    @ApiOperation("编辑饮料信息")
    public Result update(@RequestBody DrinkDTO drinkDTO)
    {
        log.info("编辑饮料信息：{}",drinkDTO);
        drinkService.update(drinkDTO);
        return  Result.success();
    }
}


