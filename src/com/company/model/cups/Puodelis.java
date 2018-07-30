package com.company.model.cups;

import com.company.model.interfaces.IPuodelis;

public class Puodelis implements IPuodelis {
    private float maxVolume;

    public Puodelis(float volume){
        this.maxVolume= volume;
    }

    public void showInfo(){
        System.out.println("Maksimali puodelio talpa:"+this.maxVolume);
    }
}
