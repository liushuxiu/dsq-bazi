package com.uestc.miaoshi.dsqbazi.dao;

import com.uestc.miaoshi.dsqbazi.model.Bazi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaziRepostory extends JpaRepository<Bazi, Integer> {

    Bazi findByNianganAndAndNianzhiAndYueganAndYuezhiAndRiganAndRizhiAndShiganAndShizhi(
           String niangan, String nianzhi,
           String yuegan, String yuezhi,
           String rigan,  String rizhi,
           String shigan, String shizhi
           );

    Bazi findByContent(String content);
}
