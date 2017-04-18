/**
 * @(#) IHM.java
 */

package src.invoker;

import java.util.HashMap;
import java.util.Scanner;

import src.command.Command;
import src.observer.Observable;
import src.observer.Observateur;
import src.receiver.Moteur;

public class IHM implements Observateur {

    // Déclaration des différentes constantes pour la gestion de nos raccourcis
    private static final String COPIER_COMMANDE = "c";
    private static final String COUPER_COMMANDE = "x";
    private static final String COLLER_COMMANDE = "v";
    private static final String AFFICHER_COMMANDE = "a";
    private static final String SELECTION_COMMANDE = "s";
    private static final String INSERTION_COMMANDE = "i";
    private static final String QUITTER_COMMANDE = "q";


    // Création des commandes, elle seront initialisé dans le setCommand
    private Command couper;
    private Command copier;
    private Command coller;
    private Command selectionner;
    private Command inserer;
    private Command afficher;

    //Scanner qui va gérer notre affichage dans la console
    private Scanner scanner;

    //Début et fin de la sélection
    private int debutSelection;
    private int finSelection;

    //Constructor de notre scanner qui gère l'instanciation de notre IHM
    public IHM() {

        this.scanner = new Scanner(System.in);

    }

    /**
     * Getter pour récupérer le début de la selection
     *
     */
    public int getDebutSelection(){
        return this.debutSelection;
    }

    /**
     * Getter pour récupérer la fin de la selection
     *
     */
    public int getFinSelection(){
        return this.finSelection;
    }

    /**
     * Getter pour récupérer la longueur de la sélection
     *
     */
    public int getLongueurSelection(){
        return (this.finSelection - this.debutSelection);
    }

    /**
     * Méthode pour récupérer la chaine insérée pour
     *
     */
    public String getString(){
        return this.scanner.nextLine();
    }

    /**
     * Setter qui nous permet d'inialiser l'ensemble des commandes
     *
     * @param c
     *            une HashMap contenant les commandes.
     * @throws Exception
     *             La méthode s'assure que c contient au moins les
     *             commandes "couper", "copier", "coller", "sélectionner",
     *             et "insérer". Si une commande est manquante alors on envoie une exception
     */
    public void setCommands(HashMap<String, Command> c) throws Exception {

        // Vérification et Initialisation de la commande couper
        this.couper = c.get("couper");
        if (this.couper == null){
            throw new Exception("commande \"couper\" non présente");
        }

        //Vérification et Initialisation de la commande copier
        this.copier = c.get("copier");
        if (this.copier == null){
            throw new Exception("commande \"copier\" non présente");
        }

        //Vérification et Initialisation de la commande coller
        this.coller = c.get("coller");
        if (this.coller == null){
            throw new Exception("commande \"coller\" non présente");
        }

        //Vérification et Initialisation de la commande selectionner
        this.selectionner = c.get("selectionner");
        if (this.selectionner == null){
            throw new Exception("commande \"selectionner\" non présente");
        }

        //Vérification et Initialisation de la commande insérer
        this.inserer = c.get("inserer");
        if (this.inserer == null){
            throw new Exception("commande \"insérer\" non présente");
        }

        //Vérification et Initialisation de la commande afficher
        this.afficher = c.get("afficher");
        if (this.afficher == null){
            throw new Exception("commande \"afficher\" non présente");
        }

    }

    /**
     * Setter qui nous permet d'inialiser l'ensemble des commandes
     *
     *  Lancement de l'éditeur de texte, ici on boucle tant que l'utilisateur ne quitte pas l'application avec la commande quitter
     *  La gestion des raccourcis et gérer ici, à chaque commande on execute son code correspondant
     */
    public void lancementEditeur(){
        //Variable correspondant à la commande insérée
        String input;

        //Message d'introduction
        System.out.print("Bienvenue dans notre Editeur de texte, veuillez entrer une commande: ");

        // Tant qu'une commande est tapée
        while (scanner.hasNext()) {

            // On récupère la nouvelle commande
            input = scanner.nextLine();

            //On choisit la commande
            switch (input) {

                // Commande de sélection
                case SELECTION_COMMANDE:

                    //Création d'un nouveau scanner
                    Scanner scannerSelection = new Scanner(System.in);
                    // On demande la première borne
                    System.out.println("Indice du début de votre sélection:");
                    //Début de la sélection
                    this.debutSelection =  scannerSelection.nextInt();
                    //On demande la seconde borne
                    System.out.println("Indice de fin de votre séléction:");
                    //Fin de sélection
                    this.finSelection = scannerSelection.nextInt();

                    this.selectionner.execute();

                    break;

                // insertion
                case INSERTION_COMMANDE:
                    System.out.println("Inserez le texte à insérer: ");
                    //Execution
                    this.inserer.execute();
                    break;

                // Afficher
                case AFFICHER_COMMANDE:
                    //Execution
                    this.afficher.execute();
                    break;

                // Copier
                case COPIER_COMMANDE:
                    //Execution
                    this.copier.execute();
                    break;


                // Couper
                case COUPER_COMMANDE:
                    //Execution
                    this.couper.execute();
                    break;

                // Coller
                case COLLER_COMMANDE:
                    //Execution
                    this.coller.execute();
                    break;


                // Quitter
                case QUITTER_COMMANDE:
                    //On ferme le scanner
                    scanner.close();
                    System.exit(0);
                    break;


                //Commande non correcte
                default:
                    System.out.println("Commande inconnue '" + input + "'");

            }

            //Log de nouvelle commande
            System.out.println("Nouvelle commande:");
        }
    }

    @Override
    public void notifyMe(Observable observable){
        if(observable instanceof Moteur){
            Moteur m = (Moteur)observable;
            System.out.println(m.getBuffer().getTexte());
        }
    }
}