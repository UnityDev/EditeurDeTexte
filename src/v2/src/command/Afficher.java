/**
 * @(#) Coller.java
 */

package src.command;

import src.receiver.Moteur;

/**
 * Commande qui permet d'afficher notre buffer dans la console
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