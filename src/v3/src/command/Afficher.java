/**
 * @(#) Coller.java
 */

package src.command;

import src.receiver.Moteur;

/**
 * La commande qui exécute l'action coller() du buffer.
 */
public class Afficher extends Command {

    public Afficher(Moteur moteur) {
        this.moteur = moteur;
    }

    @Override
    public void execute() {
        moteur.afficher();
    }

}