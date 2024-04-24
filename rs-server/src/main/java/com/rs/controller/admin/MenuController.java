package com.rs.controller.admin;


import com.rs.dto.FoodPageQueryDTO;
import com.rs.dto.MenuDTO;
import com.rs.result.PageResult;
import com.rs.result.Result;
import com.rs.service.MenuService;
import com.rs.vo.MenuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/menu")
@Slf4j
@Api(tags= "套餐相关接口")
public class MenuController {
    @Autowired
    private MenuService menuService;


    /**
     * 新增套餐
     * @param menuDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增套餐")
    public Result save(@RequestBody MenuDTO menuDTO){
        log.info("新增套餐: {}",menuDTO);
        menuService.save(menuDTO);
        return  Result.success();
    }

    /**
     * 分页查询
     * @param foodPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("套餐分页查询")
    public Result<PageResult> page(FoodPageQueryDTO foodPageQueryDTO){
        log.info("商品分页查询，参数是：{}",foodPageQueryDTO);
        PageResult pageResult= menuService.pageQuery(foodPageQueryDTO);
        return Result.success(pageResult);

    }



//
//    @GetMapping("/{id}")
//    @ApiOperation("根据id查食品信息")
//    public Result<Food> getById(@PathVariable Long id){
//        Food food= menuService.getById(id);
//        return Result.success(food);
//    }

    /**
     * 根据id删除套餐
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除套餐")
    public Result delete(@PathVariable Long id){
        menuService.delete(id);
        return Result.success();
    }

    @ApiOperation("查询品牌商品")
    @GetMapping("/goods")
    public Result<MenuVo> getGoodsByBrand(String brand){
        MenuVo menuVo=menuService.getByBrand(brand);
        log.info("品牌查询，参数是：{}",menuVo);
        return Result.success(menuVo);
    }
//
//    /**
//     * 编辑餐品信息
//     * @param foodDTO
//     * @return
//     */
//    @PutMapping
//    @ApiOperation("编辑餐品信息")
//    public Result update(@RequestBody FoodDTO foodDTO)
//    {
//        log.info("编辑餐品信息：{}",foodDTO);
//        menuService.update(foodDTO);
//        return  Result.success();
//    }
}
