package com.example.demo.controller;


import com.example.demo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    final OrderService orderService;
    @Autowired
    public OrderController (OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/list")
    public Result getOrderList(@RequestBody MultiValueMap< String, String> valueMap){
        int page,pers;
        try{
            String pageString = valueMap.getFirst("page");
            String persString = valueMap.getFirst("pers");
            page = Integer.parseInt(pageString);
            pers =Integer.parseInt(persString);
        }catch (Exception e){
            page = 0;
            pers = 10;
        }
        if(pers >10){
            pers = 10;
        }
        Result result = orderService.getUserOrderList(page,pers);
        return result==null?new Result(200,"查询失败",null):result;
    }
    @PostMapping("/list2")
    public Result getUserLastOrderList(@RequestBody MultiValueMap< String, String> valueMap){
        int page,pers;
        try{
            String pageString = valueMap.getFirst("page");
            String persString = valueMap.getFirst("pers");
            page = Integer.parseInt(pageString);
            pers =Integer.parseInt(persString);
        }catch (Exception e){
            page = 0;
            pers = 10;
        }
        if(pers >10){
            pers = 10;
        }
        Result result = orderService.getUserLastOrderList(page,pers);
        return result==null?new Result(200,"查询失败",null):result;
    }
}
