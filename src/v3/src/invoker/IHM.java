/**
 * @(#) IHM.java
 */

package src.invoker;

import src.observer.Observable;
import src.observer.Observateur;
import src.receiver.Moteur;
import src.command.Command;

import java.util.HashMap;
import java.util.Scanner;

public class IHM implements Observateur {

    // Constants
    private static final String COPIER_COMMANDE = "c";
    private static final String COUPER_COMMANDE = "x";
    private static final String COLLER_COMMANDE = "v";
    private static final String AFFICHER_COMMANDE = "a";
    private static final String SELECTION_COMMANDE = "s";
    private static final String INSERTION_COMMANDE = "i";
    private static final String QUITTER_COMMANDE = "q";
    private static final String UNDO = "u";
    private static final String REDO = "p";


    // nous avons préféré nommmer explicitement chacune des commandes
    private Command couper;
    private Command copier;
    private Command coller;
    private Command selectionner;
    private Command inserer;
    private Command afficher;
    private Command undo;
    private Command redo;

    private Scanner scanner;

    private int debutSelection;
    private int finSelection;

    public IHM() {

        this.scanner = new Scanner(System.in);

    }

    public int getDebutSelection(){
        return this.debutSelection;
    }

    public int getFinSelection(){
        return this.finSelection;
    }

    public int getLongueurSelection(){
        return (this.finSelection - this.debutSelection);
    }

    public String getString(){
        return this.scanner.nextLine();
    }

    /**
     * Setter pour initialiser toutes les commandes.
     *
     * @param h
     *            une HashMap contenant les commandes.
     * @throws Exception
     *             La méthode s'assure que <b>h</b> contient au moins les
     *             commandes "couper", "copier", "coller", "sélectionner",
     *             "taper" et "supprimer". Si l'une de ces commandes est
     *             manquante, une exception sera lancée.
     */
    public void setCommands(HashMap<String, Command> h) throws Exception {

        // Vérification et Initialisation de la commande couper
        this.couper = h.get("couper");
        if (this.couper == null){
            throw new Exception("commande \"couper\" manquante");
        }

        //Vérification et Initialisation de la commande copier
        this.copier = h.get("copier");
        if (this.copier == null){
            throw new Exception("commande \"copier\" manquante");
        }

        //Vérification et Initialisation de la commande coller
        this.coller = h.get("coller");
        if (this.coller == null){
            throw new Exception("commande \"coller\" manquante");
        }

        //Vérification et Initialisation de la commande selectionner
        this.selectionner = h.get("selectionner");
        if (this.selectionner == null){
            throw new Exception("commande \"selectionner\" manquante");
        }

        //Vérification et Initialisation de la commande insérer
        this.inserer = h.get("inserer");
        if (this.inserer == null){
            throw new Exception("commande \"insérer\" manquante");
        }

        //Vérification et Initialisation de la commande afficher
        this.afficher = h.get("afficher");
        if (this.afficher == null){
            throw new Exception("commande \"afficher\" manquante");
        }

        //Vérification et Initialisation de la commande undo
        this.undo = h.get("undo");
        if (this.undo == null){
            throw new Exception("commande \"undo\" manquante");
        }

        //Vérification et Initialisation de la commande redo
        this.redo = h.get("redo");
        if (this.redo == null){
            throw new Exception("commande \"redo\" manquante");
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

                    case SELECTION_COMMANDE:

                        //Création d'un nouveau scanner
                        Scanner scannerSelection = new Scanner(System.in);
                        // Ask values first
                        System.out.println("Indice du début de votre sélection:");

                        //TODO Faire un test ici
                        this.debutSelection =  scannerSelection.nextInt();

                        System.out.println("Indice de fin de votre séléction:");

                        //TODO Faire un test ici
                        this.finSelection = scannerSelection.nextInt();

                        this.selectionner.execute();

                        break;

                    // insertion
                    case INSERTION_COMMANDE:
                        System.out.println("Inserez le texte à insérer: ");
                        // Ask values first
                            this.inserer.execute();
                        break;

                    // Afficher
                    case AFFICHER_COMMANDE:
                        this.afficher.execute();
                        break;


                    // copier
                    case COPIER_COMMANDE:
                        this.copier.execute();
                        break;


                    // coller
                    case COUPER_COMMANDE:
                        this.couper.execute();
                        break;


                    // coller
                    case COLLER_COMMANDE:
                        this.coller.execute();
                        break;

                    //Undo
                    case UNDO:
                        this.undo.execute();
                        break;

                    case REDO:
                        this.redo.execute();
                        break;

                    // quitter
                    case QUITTER_COMMANDE:

                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Commande non reconnue '" + input + "'");

                }

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