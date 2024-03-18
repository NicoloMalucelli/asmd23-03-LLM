package code_generation.a;

import javax.swing.*;

public class Test {

    /*
    LLM: ChatGPT 3.5
    Method: zero-shot

    Scopo di questo esercizio è realizzare una GUI che realizza la possibilità di selezionare via via aree rettangolari, come segue:
     - l'utente clicka una cella, e lì ci compare un '1'
     - l'utente clicka un'altra cella, e a questo punto tutte le celle che stanno nel rettangolo che ha come estremi le due celle clickate assumono un '*'
     - si ricomincia col punto 1, finché non succede che tutte le celle hanno un '*', a quel punto le si disabilitano tutte

    requisiti non funzionali:
     - scorporamento via delegazione di tutti gli aspetti che non sono di view in una interfaccia (Logic) +classe esterna (LogicImpl)


    La classe GUI fornita, da modificare, include codice che potrebbe essere utile per la soluzione.

     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
