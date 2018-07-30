package com.company.recepies;

import com.company.interfaces.IReceptai;
import com.company.puodeliai.Produktai;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReceptaiIsInterneto implements IReceptai {

    private HashMap<String, Produktai> receptuZodynas;

    public ReceptaiIsInterneto(String path){
        receptuZodynas = new HashMap<String, Produktai>();
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
            Produktai pr = new Produktai(water,sugar,beans);
            receptuZodynas.put(name,pr);
        }

        sc.close();
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Produktai gaukRecepta(String raktas){

        return receptuZodynas.get(raktas);
    }
}
