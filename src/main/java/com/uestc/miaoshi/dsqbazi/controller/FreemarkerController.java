package com.uestc.miaoshi.dsqbazi.controller;


import com.uestc.miaoshi.dsqbazi.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;



/**
 * @author john
 * @date 2019/12/20 - 16:54
 */

@Controller
@RequestMapping("freemarker")
public class FreemarkerController {

    @GetMapping("/test1")
    public String freemarker1(Map<String, Object> map) {
        map.put("name", "java");
        //返回模板文件名称
        return "test1";
    }

    @GetMapping("/test2")
    public String freemarker2(Map<String, Object> map) {
        //向数据模型放数据
        map.put("name", "john");
        Student stu1 = new Student();
        stu1.setName("小明");
        stu1.setAge(18);
        stu1.setMoney(1000.86f);
        stu1.setBirthday(new Date());
        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setMoney(200.1f);
        stu2.setAge(19);
//        stu2.setBirthday(new Date());
        List<Student> friends = new ArrayList<>();
        friends.add(stu1);
        stu2.setFriends(friends);
        stu2.setBestFriend(stu1);
        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);
        //向数据模型放数据
        map.put("stus", stus);
        //准备map数据
        HashMap<String, Student> stuMap = new HashMap<>();
        stuMap.put("stu1", stu1);
        stuMap.put("stu2", stu2);
        //向数据模型放数据
        map.put("stu1", stu1);
        //向数据模型放数据
        map.put("stuMap", stuMap);
        //返回模板文件名称
        return "test1";
    }

}
