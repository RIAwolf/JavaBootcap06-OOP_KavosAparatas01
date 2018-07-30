package com.company.model.cups;

import com.company.controller.CoffeMakerController;

public class EspressoPuodelis extends KavosPuodelis {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");
        builder.append("  .-=-.\n");
        builder.append(" ,|`~'|\n");
        builder.append(" `|   | \n");
        builder.append("   `~'");
        return builder.toString();
    }

    public EspressoPuodelis(){

        super(CoffeMakerController.getReceptai().gaukRecepta("Espresso"),"Espresso",0.15f);
    }
}
