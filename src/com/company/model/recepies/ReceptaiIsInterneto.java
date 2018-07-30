package com.company.model.recepies;

import com.company.model.interfaces.IReceptai;
import com.company.model.products.ProduktaiVO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class ReceptaiIsInterneto implements IReceptai {

    private HashMap<String, ProduktaiVO> receptuZodynas;

    public ReceptaiIsInterneto(String path){
        receptuZodynas = new HashMap<String, ProduktaiVO>();
        URL url=null;
        InputStream stream=null;
        try {
            url = new URL(path);
            stream = url.openStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(stream);

        while (sc.hasNext()){
            float water = sc.nextFloat();
            float sugar = sc.nextFloat();
            float beans = sc.nextFloat();
            String name = sc.next();
            ProduktaiVO pr = new ProduktaiVO(water,sugar,beans);
            receptuZodynas.put(name,pr);
        }

        sc.close();
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProduktaiVO gaukRecepta(String raktas){

        return receptuZodynas.get(raktas);
    }
}
