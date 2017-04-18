/**
 * @(#) Client.java
 */

package src.client;

import src.command.*;
import src.invoker.IHM;
import src.receiver.Enregistreur;
import src.receiver.Moteur;

import java.util.HashMap;

/**
 * Classe principale de l'application, elle permet de relier les différents composants entre eux. De plus, c'est elle qui lance notre application!
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
        enregistreur = new Enregistreur();
        commandes = new HashMap<String, Command>();

        Couper couper = new Couper(moteur);
        CouperEnregistrable couperEnr = new CouperEnregistrable(moteur, enregistreur);
        commandes.put("couper", couper);
        commandes.put("couperEnr", couperEnr);
        
        Copier copier = new Copier(moteur);
        CopierEnregistrable copierEnr = new CopierEnregistrable(moteur, enregistreur);
        commandes.put("copier", copier);
        commandes.put("copierEnr", copierEnr);

        Coller coller = new Coller(moteur);
        CollerEnregistrable collerEnr = new CollerEnregistrable(moteur, enregistreur);
        commandes.put("coller", coller);
        commandes.put("collerEnr", collerEnr);

        Selectionner selectionner = new Selectionner(moteur, ihm);
        SelectionnerEnregistrable selectionnerEnr = new SelectionnerEnregistrable(moteur, ihm, enregistreur);
        commandes.put("selectionner", selectionner);
        commandes.put("selectionnerEnr", selectionnerEnr);

        commandes.put("afficher", new Afficher(moteur));

        Inserer inserer = new Inserer(moteur, ihm);
        InsererEnregistrable insererEnr = new InsererEnregistrable(moteur, ihm, enregistreur);
        commandes.put("inserer", inserer);
        commandes.put("insererEnr", insererEnr);

        commandes.put("debutEnregistrer", new DebutEnregistrer(enregistreur));
        commandes.put("finEnregistrer", new FinEnregistrer(enregistreur));
        commandes.put("rejouer", new Rejouer(enregistreur));

        ihm.setCommands(commandes);
        enregistreur.setCommands(commandes);
        moteur.registerObserver(ihm);
        enregistreur.registerObserver(ihm);
        ihm.lancementEditeur();
        // mise en place de l'src.observer
        
    }

}