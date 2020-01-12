package com.uestc.miaoshi.dsqbazi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 使用@Entity注解，创建数据表
 */
@Entity
@Table(name="bazi")
public class Bazi {
    @Id
    @GeneratedValue
    private  Integer id;
    private String content;
    private String niangan;
    private String nianzhi;
    private String yuegan;
    private String yuezhi;
    private String rigan;
    private String rizhi;
    private String shigan;
    private String shizhi;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNiangan() {
        return niangan;
    }

    public void setNiangan(String niangan) {
        this.niangan = niangan;
    }

    public String getNianzhi() {
        return nianzhi;
    }

    public void setNianzhi(String nianzhi) {
        this.nianzhi = nianzhi;
    }

    public String getYuegan() {
        return yuegan;
    }

    public void setYuegan(String yuegan) {
        this.yuegan = yuegan;
    }

    public String getYuezhi() {
        return yuezhi;
    }

    public void setYuezhi(String yuezhi) {
        this.yuezhi = yuezhi;
    }

    public String getRigan() {
        return rigan;
    }

    public void setRigan(String rigan) {
        this.rigan = rigan;
    }

    public String getRizhi() {
        return rizhi;
    }

    public void setRizhi(String rizhi) {
        this.rizhi = rizhi;
    }

    public String getShigan() {
        return shigan;
    }

    public void setShigan(String shigan) {
        this.shigan = shigan;
    }

    public String getShizhi() {
        return shizhi;
    }

    public void setShizhi(String shizhi) {
        this.shizhi = shizhi;
    }

    //必须要有构造函数
    public Bazi() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
