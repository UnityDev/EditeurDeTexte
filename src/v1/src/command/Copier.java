/**
 * @(#) Copier.java
 */

package src.command;

import src.receiver.Moteur;

/**
 * La commande qui exécute l'action copier() du buffer.
 */
public class Copier extends Command {

    public Copier(Moteur moteur) {
        this.moteur = moteur;
    }

    @Override
    public void execute() {
        moteur.copier();
    }

}