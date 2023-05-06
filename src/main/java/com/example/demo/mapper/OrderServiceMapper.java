package com.example.demo.mapper;

import com.example.demo.model.OrderResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderServiceMapper{
    //跟据条件获取订单总数量
    @Select("select count(1) from p_order")
    int getOrderListCount();
    //跟据计算后的开始位置和数据条数获取订单
    @Select("select o.id,o.created_at,o.updated_at,u.nickname,u.mobile,o.product_name,o.total_price,o.count,o.status from p_order as o,p_user as u where o.user_id = u.id order by created_at LIMIT #{start},#{pers};")
    List<OrderResp> getOrderList(@Param("start") int start, @Param("pers") int pers);
    //先通过分组和时间筛选出订单表中每个用户的最后一笔订单的(时间和用户id)，再使用内连接进行关联查询
    @Select("select o.id,o.created_at,o.updated_at,u.nickname,u.mobile,o.product_name,o.total_price,o.count,o.status from p_order as o,p_user as u INNER JOIN(select max(created_at) as maxtime,user_id from p_order group by user_id)as temp where o.created_at = temp.maxtime and o.user_id = temp.user_id and o.user_id = u.id limit #{start},#{pers};")
    List<OrderResp> getUserLastOrderList(@Param("start") int start, @Param("pers") int pers);
    //筛选订单表中多少用户有最后一笔订单
    @Select("select count(t.num) from (select count(1) as num from p_order group by user_id)as t")
    int getOrderUserCount();
}
