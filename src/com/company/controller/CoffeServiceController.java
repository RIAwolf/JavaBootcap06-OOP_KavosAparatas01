package com.company.controller;

import com.company.model.products.ProduktaiVO;

import java.util.ArrayList;

public class CoffeServiceController {

    public CoffeMakerController createMaker(){
        return new CoffeMakerController();
    }
    public void washMaker(CoffeMakerController maker){
        maker.washMaker();
    }
    public ArrayList<CoffeMakerController> crateMakers(int n){
        ArrayList<CoffeMakerController> result = new ArrayList<CoffeMakerController>();
        for(int i =0; i<n; i++){
            result.add(createMaker());
        }
        return result;
    }
    public void dumpContentFormMakers(ArrayList<CoffeMakerController> list){
        ProduktaiVO suma = new ProduktaiVO(0,0,0);
        for(int i =0; i< list.size();i++){
            CoffeMakerController temp = list.get(i);
            ProduktaiVO trash = temp.getProducts();

            temp.setProducts(null);

            suma.setWater(suma.getWater()+trash.getWater());
            suma.setSugar(suma.getSugar()+trash.getSugar());
            suma.setBeans(suma.getBeans()+trash.getBeans());
        }
        System.out.println("Isvalytu produktu informacija");
        System.out.println(suma.toString());
    }
    public void cleanMakers(ArrayList<CoffeMakerController> list){
        for(int i =0; i< list.size();i++){
            CoffeMakerController temp = list.get(i);
            washMaker(temp);
        }

    }
    public void assignSameProduct(ArrayList<CoffeMakerController> list, ProduktaiVO products){
        for(int i =0; i< list.size();i++) {
            CoffeMakerController temp = list.get(i);
            temp.setProducts(products);
        }
    }
    public void assignSeparateProduct(ArrayList<CoffeMakerController> list){
        for(int i =0; i< list.size();i++) {
            CoffeMakerController temp = list.get(i);
            temp.setProducts(new ProduktaiVO(10, 1000,1000));
        }
    }
}
