/**
 * @(#) Client.java
 */

package src.client;

import java.util.HashMap;

import src.invoker.IHM;
import src.receiver.Moteur;

import src.command.*;

/**
 * Classe principale de l'application, elle permet de relier les différents composants entre eux. De plus, c'est elle qui lance notre application!
 */
public class Client {

    private static Moteur moteur;
    private static IHM ihm;
    private static HashMap<String, Command> commmandes;

    public static void main(String[] args) throws Exception {
        // initialisation
        moteur = new Moteur();
        ihm = new IHM();

        // création des commandes
        commmandes = new HashMap<String, Command>();
        commmandes.put("couper", new Couper(moteur));
        commmandes.put("afficher", new Afficher(moteur));
        commmandes.put("copier", new Copier(moteur));
        commmandes.put("coller", new Coller(moteur));
        commmandes.put("selectionner", new Selectionner(moteur, ihm));
        commmandes.put("inserer", new Inserer(moteur, ihm));
        ihm.setCommands(commmandes);
        moteur.registerObserver(ihm);
        ihm.lancementEditeur();



    }

}