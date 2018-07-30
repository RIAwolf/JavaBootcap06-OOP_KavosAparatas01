package com.company.model.recepies;

import com.company.model.interfaces.IReceptai;
import com.company.model.products.ProduktaiVO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class ReceptaiIsFailo implements IReceptai{
    private HashMap<String, ProduktaiVO> receptuZodynas;

    @Override
    public ProduktaiVO gaukRecepta(String raktas) {
        return receptuZodynas.get(raktas);
    }

    public ReceptaiIsFailo(String path){
        receptuZodynas = new HashMap<String, ProduktaiVO>();
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
            ProduktaiVO pr = new ProduktaiVO(water,sugar,beans);
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
