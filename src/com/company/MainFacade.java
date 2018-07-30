package com.company;

import com.company.controller.interfaces.IAparatas;
import com.company.controller.CoffeMakerController;
import com.company.view.CoffeView;


import java.util.Scanner;

public class MainFacade {

    /*
        Sukurti meniu punkta kuris leistu aparato busena issaugoti tekstiniame faile
        panaudoti git branch ir github pull request
     */

    public static void main(String[] args) {
        IAparatas aparatas = new CoffeMakerController();

        CoffeView obj = new CoffeView();

        obj.setAparatas(aparatas);
        obj.dirbam();


    }


}
