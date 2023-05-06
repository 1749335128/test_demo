package com.example.demo.service;

import com.example.demo.common.Result;

public interface OrderServiceDao {
    Result getUserOrderList(int page,int pers);
    Result getUserLastOrderList(int page,int pers);
}
