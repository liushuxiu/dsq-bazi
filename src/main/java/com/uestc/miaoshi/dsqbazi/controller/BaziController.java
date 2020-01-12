package com.uestc.miaoshi.dsqbazi.controller;

import com.uestc.miaoshi.dsqbazi.dao.BaziRepostory;
import com.uestc.miaoshi.dsqbazi.model.Bazi;
import com.uestc.miaoshi.dsqbazi.service.BaziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaziController {
    
    @Autowired
    private BaziRepostory repostory;

    @Autowired
    private BaziService service;

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
