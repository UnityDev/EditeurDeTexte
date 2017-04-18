/**
 * @(#) Copier.java
 */

package src.command;

import src.receiver.Enregistreur;
import src.receiver.Moteur;

/**
 * La commande qui exécute l'action copier() du buffer.
 */
public class Copier extends Command {

    public Copier(Moteur moteur, Enregistreur enregistreur) {
        this.moteur = moteur;
        this.enregistreur = enregistreur;
    }

    @Override
    public void execute() {
        moteur.copier();
        enregistreur.enregistrer(moteur.getBuffer());
    }

}