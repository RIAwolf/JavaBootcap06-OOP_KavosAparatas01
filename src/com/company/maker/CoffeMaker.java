package com.company.maker;

import com.company.interfaces.IAparatas;
import com.company.interfaces.IReceptai;
import com.company.puodeliai.*;
import com.company.recepies.ReceptaiIsFailo;
import com.company.recepies.ReceptaiIsInterneto;
import com.company.recepies.ReceptaiIsVartotojo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CoffeMaker implements IAparatas {

    private static IReceptai receptai;
    public static  IReceptai getReceptai(){
        return  receptai;
    }

    public static final int MAX_USES = 5;
    private Produktai products;
    private int useCount;


    public CoffeMaker() {
        products = new Produktai();
    }

    public CoffeMaker(float water, float sugar, float beans) {
        products = new Produktai(water, sugar, beans);
    }


    public void fillProducts(float water, float sugar, float beans) {

        // water = water + 10
        this.products.setWater(this.products.getWater() + water);
        this.products.setSugar(this.products.getSugar() + sugar);
        this.products.setBeans(this.products.getBeans() + beans);
    }

    public KavosPuodelis makeCoffee(KavosPuodelis puodelis) {
        // water = water - 0.3f

        this.products.setWater(this.products.getWater() - puodelis.getProduktai().getWater());
        this.products.setSugar(this.products.getSugar() - puodelis.getProduktai().getSugar());
        this.products.setBeans(this.products.getBeans() - puodelis.getProduktai().getBeans());
        puodelis.setReady(true);
        return puodelis;
    }


    public void proccessChoice(String coffeType) {


        KavosPuodelis puodelis = null;
        switch (coffeType) {
            case "black":
                puodelis =new JuodosPuodelis();
                puodelis.gaminkKava(this.products);
                break;
            case "latte":
                puodelis = makeCoffee(new LattePuodelis());


                break;
            case "espresso":
                puodelis = makeCoffee(new EspressoPuodelis());

                break;


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
                CoffeMaker.receptai = new ReceptaiIsVartotojo();
                break;
            case 2:
                CoffeMaker.receptai = new ReceptaiIsFailo("receptai.txt");
                break;
            case 3:
                CoffeMaker.receptai= new ReceptaiIsInterneto("http://www.riawolf.com/dev/receptai.txt");
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
