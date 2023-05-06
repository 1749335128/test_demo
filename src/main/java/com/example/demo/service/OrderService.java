package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.mapper.OrderServiceMapper;
import com.example.demo.model.OrderResp;
import com.example.demo.model.PagerHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService   implements OrderServiceDao {

    final OrderServiceMapper serviceMapper;

    @Autowired
    public OrderService(OrderServiceMapper serviceMapper) {
        this.serviceMapper = serviceMapper;
    }

    @Override
    public Result getUserLastOrderList(int page, int pers) {
        int start = (page - 1) * pers;//起始位置
        int total = serviceMapper.getOrderUserCount();
        PagerHandler pagerHandler = new PagerHandler();
        pagerHandler.setTotal(total);
        pagerHandler.setPers(pers);
        pagerHandler.setHasNext(start + pers < total);//判断是否还有订单
        if (start > total) {
            pagerHandler.setData(null);
            return new Result(10000, "查询为空", pagerHandler);
        } else {
            List<OrderResp> orderRespList = serviceMapper.getUserLastOrderList(start, pers);
            pagerHandler.setData(orderRespList);
            return new Result(10000, "操作成功", pagerHandler);
        }
    }

    @Override
    public Result getUserOrderList(int page, int pers) {
//        业务逻辑
        int start = (page - 1) * pers;//起始位置
        int total = serviceMapper.getOrderListCount();
        PagerHandler pagerHandler = new PagerHandler();
        pagerHandler.setTotal(total);
        pagerHandler.setPers(pers);
        pagerHandler.setHasNext(start + pers < total);//判断是否还有订单
        if (start > total) {
            pagerHandler.setData(null);
            return new Result(10000, "查询为空", pagerHandler);
        } else {
            List<OrderResp> orderRespList = serviceMapper.getOrderList(start, pers);
            pagerHandler.setData(orderRespList);
            return new Result(10000, "操作成功", pagerHandler);
        }
    }
}
