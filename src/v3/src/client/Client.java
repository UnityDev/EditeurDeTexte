/**
 * @(#) Client.java
 */

package src.client;

import src.invoker.IHM;
import src.command.*;
import src.receiver.Enregistreur;
import src.receiver.Moteur;

import java.util.HashMap;

/**
 * Classe principale : instancie et relie les différents composants de
 * l'application.
 */
public class Client {

    private static Moteur moteur;
    private static IHM ihm;
    private static Enregistreur enregistreur;
    private static HashMap<String, Command> commandes;

    public static void main(String[] args) throws Exception {
        // initialisation
        moteur = new Moteur();
        ihm = new IHM();

        // création de l'enregistreur et des commandes
        enregistreur = new Enregistreur(moteur);
        commandes = new HashMap<String, Command>();

        Couper couper = new Couper(moteur, enregistreur);
        commandes.put("couper", couper);
        Copier copier = new Copier(moteur, enregistreur);
        commandes.put("copier", copier);
        Coller coller = new Coller(moteur, enregistreur);
        commandes.put("coller", coller);
        Selectionner selectionner = new Selectionner(moteur, ihm);
        commandes.put("selectionner", selectionner);

        commandes.put("afficher", new Afficher(moteur));

        Inserer inserer = new Inserer(moteur, ihm, enregistreur);
        commandes.put("inserer", inserer);

        commandes.put("undo", new Undo(enregistreur));
        commandes.put("redo", new Redo(enregistreur));

        ihm.setCommands(commandes);
        moteur.registerObserver(ihm);
        ihm.lancementEditeur();

    }

}