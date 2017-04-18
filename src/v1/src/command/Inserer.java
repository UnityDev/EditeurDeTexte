package src.command;

import src.invoker.IHM;
import src.receiver.Moteur;

/**
 * La commande qui exécute l'action inserer() du buffer.
 */
public class Inserer extends Command {

    public Inserer(Moteur buffer, IHM ihm) {
        this.moteur = buffer;
        this.ihm = ihm;
    }

    @Override
    public void execute() {
        String str = ihm.getString();
        moteur.inserer(str);

    }

}