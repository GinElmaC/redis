package com.ginelmac.springbootredisbloom.Bean;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_customer
 */
public class Customer implements Serializable {
    private Integer id;

    private String cname;

    private Integer age;

    private String phone;

    private Byte sex;

    private Date birth;

    public Customer() {
    }

    public Customer(Integer id, String cname, Integer age, String phone, Byte sex, Date birth) {
        this.id = id;
        this.cname = cname;
        this.age = age;
        this.phone = phone;
        this.sex = sex;
        this.birth = birth;
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
     * @return cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置
     * @param cname
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return sex
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置
     * @param birth
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String toString() {
        return "Customer{id = " + id + ", cname = " + cname + ", age = " + age + ", phone = " + phone + ", sex = " + sex + ", birth = " + birth + "}";
    }

    private static final long serialVersionUID = 1L;

}
