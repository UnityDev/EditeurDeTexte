/**
 * @(#) Coller.java
 */

package src.command;

import src.receiver.Enregistreur;
import src.receiver.Moteur;

/**
 * La commande qui exécute l'action coller() du buffer.
 */
public class Coller extends Command {

    public Coller(Moteur moteur, Enregistreur enregistreur) {
        this.moteur = moteur;
        this.enregistreur = enregistreur;
    }

    @Override
    public void execute() {
        moteur.coller();
        enregistreur.enregistrer(moteur.getBuffer());
    }

}