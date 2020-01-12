package com.uestc.miaoshi.dsqbazi.util;

import java.util.*;

public class BaziGenerator{

    public static String jia[]= {"甲子","甲戌","甲申","甲午","甲辰","甲寅"};
    public static String yi[]= {"乙丑","乙亥","乙酉","乙未","乙巳","乙卯"};
    public static String bing[] =    {"丙寅","丙子","丙戌","丙申","丙午","丙辰"};
    public static String ding[] =    {"丁卯","丁丑","丁亥","丁酉","丁未","丁巳"};
    public static String wu[] ={    "戊辰","戊寅","戊子","戊戌","戊申","戊午"};
    public static String ji[]= {    "己巳","己卯","己丑","己亥","己酉","己未"};
    public static String geng[] = {    "庚午","庚辰","庚寅","庚子","庚戌","庚申"};
    public static String xin[]={    "辛未","辛巳","辛卯","辛丑","辛亥","辛酉"};
    public static String ren[] = {    "壬申","壬午","壬辰","壬寅","壬子","壬戌"};
    public static String gui[]={    "癸酉","癸未","癸巳","癸卯","癸丑","癸亥"};
    public static String TIAN_GAN[] = {"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
    public static String DI_ZHI[] =   {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
    public static HashMap<String, Integer> tianganMap = new HashMap<>();
    public static HashMap<String, Integer> dizhiMap = new HashMap<>();
     static {
        for (int i = 0; i < TIAN_GAN.length; i++) {
            tianganMap.put(TIAN_GAN[i], i);
        }
        for (int i = 0; i < DI_ZHI.length; i++) {
            dizhiMap.put(DI_ZHI[i], i);
        }
    }

    public static List<String> jiazi = new ArrayList<  >();
     static {
        jiazi.addAll(Arrays.asList(jia));
        jiazi.addAll(Arrays.asList(yi));
        jiazi.addAll(Arrays.asList(bing));
        jiazi.addAll(Arrays.asList(ding));
        jiazi.addAll(Arrays.asList(wu));
        jiazi.addAll(Arrays.asList(ji));
        jiazi.addAll(Arrays.asList(geng));
        jiazi.addAll(Arrays.asList(xin));
        jiazi.addAll(Arrays.asList(ren));
        jiazi.addAll(Arrays.asList(gui));
    }


    /**
     * 甲已之年丙作首，乙庚之年戊为头，
     *
     * 丙辛必定庚发起，丁壬壬位顺行流，
     *
     * 更有戊癸何方觅，甲寅之上好追求。
     * @param niangan
     * @param yueling
     * @return
     */

    public static String getYuezhu(String niangan, String yueling) {
        String yuegan = null;
        int indexOfyueling = 0;
        indexOfyueling = dizhiMap.get(yueling) - 2;
        if (indexOfyueling < 0) indexOfyueling = 12 + indexOfyueling;
        if (niangan.equals("甲") || niangan.equals("己")) {
            yuegan = TIAN_GAN[(2+indexOfyueling)%10];
        } else if (niangan.equals("乙") || niangan.equals("庚")) {
            yuegan = TIAN_GAN[(4+indexOfyueling)%10];
        } else if (niangan.equals("丙") || niangan.equals("辛")) {
            yuegan = TIAN_GAN[(6+indexOfyueling)%10];
        } else if (niangan.equals("丁") || niangan.equals("壬")) {
            yuegan = TIAN_GAN[(8+indexOfyueling)%10];
        } else if (niangan.equals("戊") || niangan.equals("癸")) {
            yuegan = TIAN_GAN[indexOfyueling%10];
        }
        return yuegan+yueling;
    }


    /**
     * 甲已还生甲，乙庚丙作初，
     *
     * 丙辛从戊起，丁壬庚子居，
     *
     * 戊癸何方发？壬子是真途
     * @param rigan
     * @param hour
     * @return
     */

    public static String getShiZhu(String rigan, String hour) {
        String shigan = null;
        int indexOfHour = -1;
        indexOfHour = dizhiMap.get(hour);
        if (rigan.equals("甲") || rigan.equals("己")) {
            shigan = TIAN_GAN[indexOfHour%10];
        } else if (rigan.equals("乙") || rigan.equals("庚")) {
            shigan = TIAN_GAN[(2 +indexOfHour)%10];
        } else if (rigan.equals("丙") || rigan.equals("辛")) {
            shigan = TIAN_GAN[(4 +indexOfHour)%10];
        } else if (rigan.equals("丁") || rigan.equals("壬")) {
            shigan = TIAN_GAN[(6 +indexOfHour)%10];
        } else if (rigan.equals("戊") || rigan.equals("癸")) {
            shigan = TIAN_GAN[(8 +indexOfHour)%10];
        }
        return shigan + hour;
    }

    public static LinkedHashSet<String> get60JiaZi() {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        String str = "";
        int count = 0;
        int i = 0,j = 0;
        while (count < 60) {
            for (;count<60;i++,j++) {

                str = TIAN_GAN[i%10] + DI_ZHI[j%12];
                count++;
                set.add(str);
            }

        }
        return set;
    }

    public static String split = " " ;

     public static void main(String[]args){


        int count = 0;
         LinkedHashSet<String> all = new LinkedHashSet<>();
         LinkedHashSet<String> set = get60JiaZi();
         LinkedHashSet<String> setCopy = new LinkedHashSet<>(set);
        for (String nianzhu : set) {
            String niangan = nianzhu.substring(0,1);
            String bazi = null;
            for (int i = 0; i < DI_ZHI.length; i++) {
                String yuezhu = getYuezhu(niangan, DI_ZHI[i]);
                for (String rizhu : setCopy) {
                    String rigan = rizhu.substring(0 ,1 );
                    for (int j = 0; j < DI_ZHI.length; j++) {
                        String shizhu = getShiZhu(rigan, DI_ZHI[j]);
                        bazi = nianzhu + split + yuezhu + split + rizhu + split + shizhu;
                        if (count % 5 == 0) {
                            System.out.println(all);
                            all.clear();
                        }
                        all.add(bazi);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);


    }
}
