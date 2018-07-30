package com.company.recepies;

import com.company.interfaces.IReceptai;
import com.company.puodeliai.Produktai;

import java.util.Scanner;

public class ReceptaiIsVartotojo implements IReceptai{
    @Override
    public Produktai gaukRecepta(String raktas) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite kiek sunaudos produktu gaminant "+raktas);
        System.out.println("Iveksite cukraus kieki");
        float sugar = sc.nextFloat();
        System.out.println("Iveskite vandens kieki");
        float water = sc.nextFloat();
        System.out.println("Iveskite pupeliu kieki");
        float beans = sc.nextFloat();
        return  new Produktai(sugar,water,beans);

    }
}
