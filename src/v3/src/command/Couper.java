/**
 * @(#) Couper.java
 */

package src.command;

import src.receiver.Enregistreur;
import src.receiver.Moteur;

/**
 * La commande qui exécute l'action couper() du buffer.
 */
public class Couper extends Command {

    public Couper(Moteur moteur, Enregistreur enregistreur) {
        this.moteur = moteur;
        this.enregistreur = enregistreur;
    }

    @Override
    public void execute() {
        moteur.couper();
        enregistreur.enregistrer(moteur.getBuffer());
    }

}