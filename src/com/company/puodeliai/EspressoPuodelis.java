package com.company.puodeliai;

import com.company.maker.CoffeMaker;
import com.company.recepies.ReceptaiIsInterneto;

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

        super(CoffeMaker.getReceptai().gaukRecepta("Espresso"),"Espresso",0.15f);
    }
}
