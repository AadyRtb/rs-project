package com.rs.controller.admin;

import com.rs.dto.GoodDeleteDTO;
import com.rs.dto.OrderDTO;
import com.rs.entity.Food;
import com.rs.entity.Good;
import com.rs.entity.Menu;
import com.rs.entity.Order;
import com.rs.result.GoodsResult;
import com.rs.result.PageResult;
import com.rs.result.Result;
import com.rs.service.DrinkService;
import com.rs.service.FoodService;
import com.rs.service.MenuService;
import com.rs.service.SnackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/order")
@Slf4j
@Api(tags= "订单相关接口")
public class OrderController {


    @Autowired
    private MenuService menuService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private SnackService snackService;
    @Autowired
    private DrinkService drinkService;

    /**
     * 订单增加商品信息
     * @param orderDTO
     * @return
     */
    @PostMapping
    @ApiOperation("订单增加商品信息")
    public Result addGoodToOrder(OrderDTO orderDTO) {
        log.info("订单增加信息：{}", orderDTO);
        Good good;
        switch (orderDTO.getType()) {
            case 0:
                good = foodService.getById(orderDTO.getGoodId());
                break;
            case 1:
                good = snackService.getById(orderDTO.getGoodId());
                break;
            case 2:
                good = drinkService.getById(orderDTO.getGoodId());
                break;
            case 3:
                good = menuService.getById(orderDTO.getGoodId());
                break;
            default:
                good = new Good();
                break;
        }

        log.info("增加good：{}", good);
        Order.getOrder().addGood(good);
        log.info("订单信息：{}", Order.getOrder().getGoods() );
        return Result.success();
    }

    @GetMapping("/num")
    @ApiOperation("获取订单商品数量")
    public Result<Integer> getGoodNum()
    {
        log.info("订单数量：{}", Order.getOrder().getGoods().size());
        return Result.success(Order.getOrder().getGoods().size());
    }

    @GetMapping
    @ApiOperation("获取订单商品信息")
    public Result<GoodsResult> getAllGoods(){

        GoodsResult goodsResult=new GoodsResult(Order.getOrder().getGoods(),Order.getOrder().getPrice());


        return Result.success(goodsResult);
    }

    @DeleteMapping
    @ApiOperation("删除订单商品")
    public Result deleteGoods(GoodDeleteDTO goodDeleteDTO){
        List<Good> goodList=Order.getOrder().getGoods();
        for(int i=0;i<goodList.size();i++){
            if((goodList.get(i).getName().equals(goodDeleteDTO.getGoodName()))&&(goodList.get(i).getBrand().equals(goodDeleteDTO.getGoodBrand()))){
                log.info("删除商品：{}",goodList.get(i));
                Order.getOrder().getGoods().remove(i);
                break;
            }
        }
        return Result.success();
    }

}
