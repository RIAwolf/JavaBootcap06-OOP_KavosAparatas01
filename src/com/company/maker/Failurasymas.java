package com.company.maker;

import java.io.FileWriter;
import java.io.IOException;

public class Failurasymas {

    public static void main (String[] args){
        Failurasymas obj = new Failurasymas();
        obj.dirbam();;
    }

    public void dirbam(){
        FileWriter writer = null;
        try {
            writer = new FileWriter("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.write("Dirbam\n");
            writer.write("Suma :"+ 4+"\n");
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
