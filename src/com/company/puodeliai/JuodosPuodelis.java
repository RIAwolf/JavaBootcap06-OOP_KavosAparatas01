package com.company.puodeliai;

import com.company.maker.CoffeMaker;
import com.company.recepies.ReceptaiIsInterneto;

public class JuodosPuodelis extends KavosPuodelis {
    public JuodosPuodelis() {

        super(
                CoffeMaker.getReceptai().gaukRecepta("Black"),
                "Black",
                0.3f
        );
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("");


        builder.append("                        (\n");
        builder.append("                          )     (\n");
        builder.append("                   ___...(-------)-....___\n");
        builder.append("               .-\"\"       )    (          \"\"-.\n");
        builder.append("         .-'``'|-._             )         _.-|\n");
        builder.append("        /  .--.|   `\"\"---...........---\"\"`   |\n");
        builder.append("       /  /    |                             |\n");
        builder.append("       |  |    |                             |\n");
        builder.append("        \\  \\   |                             |\n");
        builder.append("         `\\ `\\ |                             |\n");
        builder.append("           `\\ `|                             |\n");
        builder.append("           _/ /\\                             /\n");
        builder.append("          (__/  \\                           /\n");
        builder.append("       _..---\"\"` \\                         /`\"\"---.._\n");
        builder.append("    .-'           \\                       /          '-.\n");
        builder.append("   :               `-.__             __.-'              :\n");
        builder.append("   :                  ) \"\"---...---\"\" (                 :\n");
        builder.append("    '._               `\"--...___...--\"`              _.'\n");
        builder.append("      \\\"\"--..__                              __..--\"\"/\n");
        builder.append("       '._     \"\"\"----.....______.....----\"\"\"     _.'\n");
        builder.append("          `\"\"--..,,_____            _____,,..--\"\"`\n");
        builder.append("                        `\"\"\"----\"\"\"`");
        return builder.toString();
    }
}
