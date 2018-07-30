package com.company.model.recepies;

import com.company.model.interfaces.IReceptai;
import com.company.model.products.ProduktaiVO;

import java.util.Scanner;

public class ReceptaiIsVartotojo implements IReceptai{
    @Override
    public ProduktaiVO gaukRecepta(String raktas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite kiek sunaudos produktu gaminant "+raktas);
        System.out.println("Iveksite cukraus kieki");
        float sugar = sc.nextFloat();
        System.out.println("Iveskite vandens kieki");
        float water = sc.nextFloat();
        System.out.println("Iveskite pupeliu kieki");
        float beans = sc.nextFloat();
        return  new ProduktaiVO(sugar,water,beans);

    }
}
