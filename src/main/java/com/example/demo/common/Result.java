package com.example.demo.common;
/*
    Author: God.c
    Time: 2022/4/14 20:23
    description:
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@Data
@AllArgsConstructor
public class Result {
    private Integer code; //状态码
    private String message; //信息
    private Object data; //数据

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.data = map;
        return this;
    }

}
