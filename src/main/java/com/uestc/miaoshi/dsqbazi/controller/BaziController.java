package com.uestc.miaoshi.dsqbazi.controller;

import com.google.gson.Gson;
import com.uestc.miaoshi.dsqbazi.dao.BaziRepostory;
import com.uestc.miaoshi.dsqbazi.model.Bazi;
import com.uestc.miaoshi.dsqbazi.service.BaziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RequestMapping
public class BaziController {
    
    @Autowired
    private BaziRepostory repostory;

    @Autowired
    private BaziService service;

    static Gson  gson = new Gson();

    @GetMapping("/")
    public String index() {
       return "index";
    }

    @GetMapping("/xx")
    public void insert() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.insertAll();
            }
        }).start();
       return;
    }

    @GetMapping("bazi")
    public String getBazi(String bazi) {
        Bazi content = repostory.findByContent(bazi);
        return gson.toJson(content);
    }

    @GetMapping("/query")
    public String query ( String niangan, String nianzhi,
                          String yuegan, String yuezhi,
                          String rigan,  String rizhi,
                          String shigan, String shizhi) {

        Bazi bazi = repostory.findByNianganAndAndNianzhiAndYueganAndYuezhiAndRiganAndRizhiAndShiganAndShizhi(
                niangan, nianzhi,
                yuegan, yuezhi,
                rigan, rizhi,
                shigan, shizhi
        );

        return bazi.getContent();
    }
    
}
