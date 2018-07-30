package com.company.model.cups;

import com.company.model.products.ProduktaiVO;

public abstract class KavosPuodelis extends Puodelis{
    private ProduktaiVO produktaiVO;
    private String name;
    private boolean isReady;


    public KavosPuodelis (ProduktaiVO products, String name, float volume){
        super(volume);
        this.name=name;
        this.produktaiVO =products;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public String getName() {
        return name;
    }

    public ProduktaiVO getProduktaiVO() {
        return produktaiVO;
    }

    public void gaminkKava(ProduktaiVO aparatoAtsargos){
        aparatoAtsargos.setWater(aparatoAtsargos.getWater()- this.produktaiVO.getWater());
    }
}
