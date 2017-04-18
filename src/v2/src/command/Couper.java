/**
 * @(#) Couper.java
 */

package src.command;

import src.receiver.Moteur;

/**
 * La commande qui exécute l'action couper() du buffer.
 */
public class Couper extends Command {

    public Couper(Moteur moteur) {
        this.moteur = moteur;
    }

    @Override
    public void execute() {
        moteur.couper();
    }

}