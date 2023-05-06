package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class OrderResp implements Serializable {
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date created_at;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updated_at;
    private String nickname;
    private String mobile;
    private String product_name;
    private String total_price;
    private int count;
    private int status;
    private int pay_type;
}
