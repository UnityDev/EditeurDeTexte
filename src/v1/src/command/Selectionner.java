package src.command;

import src.invoker.IHM;
import src.receiver.Moteur;

/**
 * La commande qui exécute l'action selectionner() du buffer.
 */
public class Selectionner extends Command {

    public Selectionner(Moteur moteur, IHM ihm) {
        this.moteur = moteur;
        this.ihm = ihm;
    }

    @Override
    public void execute() {
        int d = ihm.getDebutSelection();
        int l = ihm.getLongueurSelection();
        moteur.setSelection(d, l);
    }

}