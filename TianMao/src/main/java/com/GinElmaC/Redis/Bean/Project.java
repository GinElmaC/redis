package com.GinElmaC.Redis.Bean;

import java.io.Serializable;

public class Project implements Serializable {
    private String name;
    private Integer id;
    private Double price;
    private String detile;

    public Project() {
    }

    public Project(String name, Integer id, Double price, String detile) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.detile = detile;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return detile
     */
    public String getDetile() {
        return detile;
    }

    /**
     * 设置
     * @param detile
     */
    public void setDetile(String detile) {
        this.detile = detile;
    }

    public String toString() {
        return "Project{name = " + name + ", id = " + id + ", price = " + price + ", detile = " + detile + "}";
    }
}
