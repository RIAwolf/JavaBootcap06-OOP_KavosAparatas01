package com.company.puodeliai;

import com.company.recepies.Receptai;

public class LattePuodelis extends KavosPuodelis {

    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder("");
        builder.append("\n");
        builder.append("         {\n");
        builder.append("      {   }\n");
        builder.append("       }_{ __{\n");
        builder.append("    .-{   }   }-.\n");
        builder.append("   (   }     {   )\n");
        builder.append("   |`-.._____..-'|\n");
        builder.append("   |             ;--.\n");
        builder.append("   |            (__  \\\n");
        builder.append("   |             | )  )\n");
        builder.append("   |             |/  /\n");
        builder.append("   |             /  / \n");
        builder.append("   |            (  /\n");
        builder.append("   \\             y'\n");
        builder.append("    `-.._____..-'");
        return builder.toString();
    }

    public LattePuodelis(){
        super(Receptai.getInstance().gaukRecepta("Latte"),"Latte",0.35f);
    }
}
