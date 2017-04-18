package src.command;

import src.invoker.IHM;
import src.receiver.Enregistreur;
import src.receiver.Moteur;

/**
 * La commande qui ajoute un caractère dans le buffer.
 */
public class Inserer extends Command {

    public Inserer(Moteur buffer, IHM ihm, Enregistreur enregistreur) {
        this.moteur = buffer;
        this.ihm = ihm;
        this.enregistreur = enregistreur;
    }

    @Override
    public void execute() {
        String str = ihm.getString();
        moteur.inserer(str);
        enregistreur.enregistrer(moteur.getBuffer());
    }

}