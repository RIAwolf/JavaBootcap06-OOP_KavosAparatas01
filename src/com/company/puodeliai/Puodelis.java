package com.company.puodeliai;

import com.company.interfaces.IPuodelis;

public class Puodelis implements IPuodelis {
    private float maxVolume;

    public Puodelis(float volume){
        this.maxVolume= volume;
    }

    public void showInfo(){
        System.out.println("Maksimali puodelio talpa:"+this.maxVolume);
    }
}
