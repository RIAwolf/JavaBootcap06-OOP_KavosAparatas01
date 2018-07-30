package com.company.view;

import com.company.controller.CoffeMakerController;
import com.company.controller.interfaces.IAparatas;

import java.util.Scanner;

public class CoffeView {


    private IAparatas aparatas =null;

    private void showMenu() {
        System.out.println("0 - baigti darba");
        System.out.println("1 - gaminti kava");
        System.out.println("2 - rodyti aparato busena");
        System.out.println("3 - plauti aparata");
        System.out.println("4 - pildyti produktus");
        System.out.println("5 - saugoti status i faila");
        System.out.println("6 - pasirinkti receptu saltini");
    }
    public void setAparatas(IAparatas aparatas) {
        this.aparatas = aparatas;
    }
    public void dirbam() {

        Scanner sc = new Scanner(System.in);
        boolean arTesti = true;
        do {
            showMenu();
            int pasirinkimas = sc.nextInt();
            switch (pasirinkimas) {
                case 0:
                    arTesti = false;
                    break;
                case 1:
                    if (aparatas.isReady()) {
                        System.out.println("Iveskite kavos pavadinima: black, latte arba espresso");
                        String name = sc.next();
                        aparatas.proccessChoice(name.toLowerCase());
                    }
                    break;
                case 2:
                    aparatas.showStatus();
                    break;
                case 3:
                    aparatas.washMaker();
                    break;
                case 4:
                    System.out.println("Iveskite kiek pildome vandens(l)");
                    float water = sc.nextFloat();
                    System.out.println("Iveskite kiek pildome cukraus(g)");
                    float sugar = sc.nextFloat();
                    System.out.println("Ivesite kiek pildome pupeliu(g)");
                    float beans = sc.nextFloat();
                    aparatas.fillProducts(water, sugar, beans);
                    break;
                case 5:
                    aparatas.saveStatus();
                    break;
                case 6:
                    aparatas.selectDataSource();
                    break;
            }

        } while (arTesti);
    }
}
