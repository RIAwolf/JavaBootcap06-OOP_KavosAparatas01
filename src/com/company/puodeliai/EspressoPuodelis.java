package com.company.puodeliai;

import com.company.recepies.Receptai;

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

        super(Receptai.getInstance().gaukRecepta("Espresso"),"Espresso",0.15f);
    }
}
