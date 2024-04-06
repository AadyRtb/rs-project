package com.rs.controller.admin;

import com.rs.dto.FoodDTO;
import com.rs.dto.FoodPageQueryDTO;
import com.rs.entity.Food;
import com.rs.result.PageResult;
import com.rs.result.Result;
import com.rs.service.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * 员工管理
 */

@RestController
@RequestMapping("/admin/food")
@Slf4j
@Api(tags= "餐品相关接口")
public class FoodController {
    @Autowired
    private FoodService foodService;


    /**
     * 新增餐品
     * @param foodDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增餐品")
    public Result save(@RequestBody FoodDTO foodDTO){
        log.info("新增食品: {}",foodDTO);
        foodService.save(foodDTO);
        return  Result.success();
    }

    /**
     * 分页查询
     * @param foodPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("餐品分页查询")
    public Result<PageResult> page(FoodPageQueryDTO foodPageQueryDTO){
        log.info("商品分页查询，参数是：{}",foodPageQueryDTO);
        PageResult pageResult= foodService.pageQuery(foodPageQueryDTO);
        return Result.success(pageResult);

    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查食品信息")
    public Result<Food> getById(@PathVariable Long id){
        Food food=foodService.getById(id);
        return Result.success(food);
    }

    /**
     * 根据id删除餐品
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除餐品")
    public Result delete(@PathVariable Long id){
        foodService.delete(id);
        return Result.success();
    }

    /**
     * 编辑餐品信息
     * @param foodDTO
     * @return
     */
    @PutMapping
    @ApiOperation("编辑餐品信息")
    public Result update(@RequestBody FoodDTO foodDTO)
    {
        log.info("编辑餐品信息：{}",foodDTO);
        foodService.update(foodDTO);
        return  Result.success();
    }
}


