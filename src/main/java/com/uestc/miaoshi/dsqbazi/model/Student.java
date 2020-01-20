package com.uestc.miaoshi.dsqbazi.model;


import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author john
 * @date 2019/12/20 - 16:52
 */
@Data
@ToString
public class Student {
    private String name;//姓名
    private int age;//年龄
    private Date birthday;//生日
    private Float money;//钱包
    private List<Student> friends;//朋友列表
    private Student bestFriend;//最好的朋友
}
