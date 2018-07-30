package com.company.controller;

import com.company.controller.interfaces.IAparatas;
import com.company.model.cups.EspressoPuodelis;
import com.company.model.cups.JuodosPuodelis;
import com.company.model.cups.KavosPuodelis;
import com.company.model.cups.LattePuodelis;
import com.company.model.interfaces.IReceptai;
import com.company.model.products.ProduktaiVO;
import com.company.model.recepies.ReceptaiIsFailo;
import com.company.model.recepies.ReceptaiIsInterneto;
import com.company.model.recepies.ReceptaiIsVartotojo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class CoffeMakerController implements IAparatas {

    private static IReceptai receptai;
    public static  IReceptai getReceptai(){
        return  receptai;
    }

    public static final int MAX_USES = 5;

    public ProduktaiVO getProducts() {
        return products;
    }

    public void setProducts(ProduktaiVO products) {
        this.products = products;
    }

    private ProduktaiVO products;

    private HashMap<String,Class> klasiuSarasas;
    private int useCount;


    public CoffeMakerController() {
        klasiuSarasas = new HashMap<>();

        klasiuSarasas.put("black",JuodosPuodelis.class);
        klasiuSarasas.put("latte",LattePuodelis.class);
        klasiuSarasas.put("espresso",EspressoPuodelis.class);
        products = new ProduktaiVO();
    }

    public CoffeMakerController(float water, float sugar, float beans) {
        products = new ProduktaiVO(water, sugar, beans);
    }


    public void fillProducts(float water, float sugar, float beans) {

        // water = water + 10
        this.products.setWater(this.products.getWater() + water);
        this.products.setSugar(this.products.getSugar() + sugar);
        this.products.setBeans(this.products.getBeans() + beans);
    }

    public KavosPuodelis makeCoffee(KavosPuodelis puodelis) {
        // water = water - 0.3f

        this.products.setWater(this.products.getWater() - puodelis.getProduktaiVO().getWater());
        this.products.setSugar(this.products.getSugar() - puodelis.getProduktaiVO().getSugar());
        this.products.setBeans(this.products.getBeans() - puodelis.getProduktaiVO().getBeans());
        puodelis.setReady(true);
        return puodelis;
    }


    public void proccessChoice(String coffeType) {


        KavosPuodelis puodelis = null;
        if(!klasiuSarasas.containsKey(coffeType.toLowerCase())){
            System.out.println("Tokios kavos nera");
            return;
        }
        try {
            puodelis = (KavosPuodelis) klasiuSarasas.get(coffeType.toLowerCase()).newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (puodelis != null) {
            System.out.println(puodelis);
            useCount++;
            this.products.setWater(Math.max(this.products.getWater(), 0));
            this.products.setSugar(Math.max(this.products.getSugar(), 0));
            this.products.setBeans(Math.max(this.products.getBeans(), 0));

        }
    }


    public void washMaker() {
        this.useCount = 0;
    }

    @Override
    public void selectDataSource() {
        System.out.println("Pasirinkite duomenu saltini");
        System.out.println("1 -  is vartotojo ivedimo");
        System.out.println("2 -  is lokalaus failo");
        System.out.println("3 -  is interneto");

        Scanner sc = new Scanner(System.in);
        int pasirinkimas = sc.nextInt();
        switch (pasirinkimas){
            case 1:
                CoffeMakerController.receptai = new ReceptaiIsVartotojo();
                break;
            case 2:
                CoffeMakerController.receptai = new ReceptaiIsFailo("receptai.txt");
                break;
            case 3:
                CoffeMakerController.receptai= new ReceptaiIsInterneto("http://www.riawolf.com/dev/receptai.txt");
                break;
        }
    }


    public boolean isReady() {

        boolean result = true;
        if (useCount >= MAX_USES) {
            result = false;
            System.out.println("Reikia plauti");
        }
        if (this.products.getWater() <= 0) {
            result = false;
            System.out.println("Truksta vandens");
        }
        if (this.products.getSugar() <= 0) {
            result = false;
            System.out.println("Truksta cukraus");
        }
        if (this.products.getBeans() <= 0) {
            result = false;
            System.out.println("Truksta pupeliu");
        }

        return result;
    }


    public void showProducts() {
        System.out.println("=========Product status=========");
        System.out.println("Sugar amount left:" + this.products.getSugar());
        System.out.println("Water amount left:" + this.products.getWater());
        System.out.println("Beans amount left:" + this.products.getBeans());

    }


    public void showStatus() {
        System.out.println("=========Maker status============");
        System.out.println("Usages left:" + (MAX_USES - this.useCount));
        System.out.println("is machine ready:" + isReady());
        this.showProducts();
    }

    public void saveStatus() {
        StringBuilder builder = new StringBuilder("");
        builder.append("=========Maker status============\n");
        builder.append("Usages left:");
        builder.append(MAX_USES - this.useCount);
        builder.append("\n");
        builder.append("is machine ready:");
        builder.append(isReady());
        builder.append("\n");
        builder.append("=========Product status=========\n");
        builder.append("Sugar amount left:");
        builder.append(this.products.getSugar());
        builder.append("\n");
        builder.append("Water amount left:");
        builder.append(this.products.getWater());
        builder.append("\n");
        builder.append("Beans amount left:");
        builder.append(this.products.getBeans());

        FileWriter writer = null;
        try {
            writer = new FileWriter("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
