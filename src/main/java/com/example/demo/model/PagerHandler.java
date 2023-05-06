package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class PagerHandler implements Serializable {
    private int total;
    private Object data;
    private int page;
    private int pers;
    private boolean hasNext;
}
