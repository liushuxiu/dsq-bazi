package com.uestc.miaoshi.dsqbazi.service;

import com.uestc.miaoshi.dsqbazi.dao.BaziRepostory;
import com.uestc.miaoshi.dsqbazi.model.Bazi;
import com.uestc.miaoshi.dsqbazi.util.BaziGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.*;

@Service
public class BaziService {

    @Autowired
    private BaziRepostory baziRepostory;
//    //创建等待队列
//    BlockingQueue<Runnable> blockingQueue=new ArrayBlockingQueue<Runnable>(2000000);
//    ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(100,100,30, TimeUnit.MILLISECONDS,blockingQueue);

    public void insertAll() {

        LinkedHashSet<String> all = new LinkedHashSet<>();
        LinkedHashSet<String> set = BaziGenerator.get60JiaZi();
        LinkedHashSet<String> setCopy = new LinkedHashSet<>(set);
        for (String nianzhu : set) {
            String niangan = nianzhu.substring(0,1);
            String nianzhi = nianzhu.substring(1);
            for (int i = 0; i < BaziGenerator.DI_ZHI.length; i++) {
                String yuezhu = BaziGenerator.getYuezhu(niangan, BaziGenerator.DI_ZHI[i]);
                for (String rizhu : setCopy) {
                    String rigan = rizhu.substring(0 ,1 );
                    String rizhi = rizhu.substring(1);
                    for (int j = 0; j < BaziGenerator.DI_ZHI.length; j++) {
                        String shizhu = BaziGenerator.getShiZhu(rigan, BaziGenerator.DI_ZHI[j]);
                        String bazi = nianzhu + BaziGenerator.split + yuezhu + BaziGenerator.split + rizhu + BaziGenerator.split + shizhu;
                        Bazi instance = new Bazi();
                        instance.setNiangan(niangan);
                        instance.setNianzhi(nianzhi);
                        instance.setYuegan(yuezhu.substring(0, 1));
                        instance.setYuezhi(yuezhu.substring(1));
                        instance.setRigan(rigan);
                        instance.setRizhi(rizhi );
                        instance.setShigan(shizhu.substring(0,1));
                        instance.setShizhi(shizhu.substring(1));
                        instance.setContent(bazi);
                        baziRepostory.save(instance);
                    }
                }
            }
        }
    }

}
