package com.company.recepies;

import com.company.interfaces.IReceptai;
import com.company.puodeliai.Produktai;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class ReceptaiIsFailo implements IReceptai{
    private HashMap<String, Produktai> receptuZodynas;

    @Override
    public Produktai gaukRecepta(String raktas) {
        return receptuZodynas.get(raktas);
    }

    public ReceptaiIsFailo(String path){
        receptuZodynas = new HashMap<String, Produktai>();
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(reader);

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
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
