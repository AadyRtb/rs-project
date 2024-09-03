package com.tp.controller.admin;


import com.tp.dto.rs.FoodPageQueryDTO;
import com.tp.dto.rs.SnackDTO;
import com.tp.entity.rs.Snack;
import com.tp.result.PageResult;
import com.tp.result.Result;
import com.tp.service.rs.SnackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 员工管理
 */

@RestController
@RequestMapping("/admin/snack")
@Slf4j
@Api(tags= "小吃相关接口")
public class SnackController {
    @Autowired
    private SnackService snackService;


    /**
     * 新增小吃
     * @param snackDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新增小吃")
    public Result save(@RequestBody SnackDTO snackDTO){
        log.info("新增小吃: {}",snackDTO);
        snackService.save(snackDTO);
        return  Result.success();
    }

    /**
     * 分页查询
     * @param foodPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("小吃分页查询")
    public Result<PageResult> page(FoodPageQueryDTO foodPageQueryDTO){
        log.info("小吃分页查询，参数是：{}",foodPageQueryDTO);
        PageResult pageResult= snackService.pageQuery(foodPageQueryDTO);
        return Result.success(pageResult);

    }

    @GetMapping("/{id}")
    @ApiOperation("根据id查小吃信息")
    public Result<Snack> getById(@PathVariable Long id){
        Snack snack=snackService.getById(id);
        return Result.success(snack);
    }

    /**
     * 根据id删除小吃
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation("根据id删除小吃")
    public Result delete(@PathVariable Long id){
        snackService.delete(id);
        return Result.success();
    }

    /**
     * 编辑小吃信息
     * @param snackDTO
     * @return
     */
    @PutMapping
    @ApiOperation("编辑小吃信息")
    public Result update(@RequestBody SnackDTO snackDTO)
    {
        log.info("编辑小吃信息：{}",snackDTO);
        snackService.update(snackDTO);
        return  Result.success();
    }
}

