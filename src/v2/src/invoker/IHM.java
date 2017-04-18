/**
 * @(#) IHM.java
 */

package src.invoker;

import src.command.Command;
import src.observer.Observateur;
import src.observer.Observable;
import src.receiver.Enregistreur;
import src.receiver.Moteur;

import java.util.HashMap;
import java.util.Scanner;

public class IHM  implements Observateur{

    // Constants
    private static final String COPIER_COMMANDE = "c";
    private static final String COUPER_COMMANDE = "x";
    private static final String COLLER_COMMANDE = "v";
    private static final String AFFICHER_COMMANDE = "a";
    private static final String SELECTION_COMMANDE = "s";
    private static final String INSERTION_COMMANDE = "i";
    private static final String DEBUT_MACRO = "d";
    private static final String FIN_MACRO = "f";
    private static final String REJOUER_MACRO = "r";
    private static final String QUITTER_COMMANDE = "q";


    // nous avons préféré nommmer explicitement chacune des commandes
    private Command couper;
    private Command couperEnr;
    private Command copier;
    private Command copierEnr;
    private Command coller;
    private Command collerEnr;
    private Command selectionner;
    private Command selectionnerEnr;
    private Command inserer;
    private Command insererEnr;
    private Command afficher;
    private Command debutEnregistrer;
    private Command finEnregistrer;
    private Command rejouer;

    private Scanner scanner;

    private int debutSelection;
    private int finSelection;
    private String texteUser;
    
    protected Observable observable;
    
    boolean etatrec;
    

    public IHM(){
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

    public void setTexteUser(String texteUser)
    {
    	this.texteUser = texteUser;
    }

    
    public String getTexteUser()
    {
    	return texteUser;
    }
    
    
    public String getString(){
        return this.scanner.nextLine();
    }
    
    public void setDebutSelection(int debutSelection) {
		this.debutSelection = debutSelection;
	}

	public void setFinSelection(int finSelection) {
		this.finSelection = finSelection;
	}

    /**
     * Setter qui nous permet d'inialiser l'ensemble des commandes
     *
     * @param h
     *            une HashMap contenant les commandes.
     * @throws Exception
     *             La méthode s'assure que c contient au moins les
     *             commandes "couper", "copier", "coller", "sélectionner",
     *             et "insérer". Si une commande est manquante alors on envoie une exception
     */
    public void setCommands(HashMap<String, Command> h) throws Exception {

        // Vérification et Initialisation de la commande couper
        this.couper = h.get("couper");
        if (this.couper == null){
            throw new Exception("commande \"couper\" manquante");
        }
        this.couperEnr = h.get("couperEnr");
        if (this.couperEnr == null){
            throw new Exception("commande \"couperEnr\" manquante");
        }

        //Vérification et Initialisation de la commande copier
        this.copier = h.get("copier");
        if (this.copier == null){
            throw new Exception("commande \"copier\" manquante");
        }
        this.copierEnr = h.get("copierEnr");
        if (this.copierEnr == null){
            throw new Exception("commande \"copier\" manquante");
        }

        //Vérification et Initialisation de la commande coller
        this.coller = h.get("coller");
        if (this.coller == null){
            throw new Exception("commande \"coller\" manquante");
        }
        this.collerEnr = h.get("collerEnr");
        if (this.collerEnr == null){
            throw new Exception("commande \"collerEnr\" manquante");
        }

        //Vérification et Initialisation de la commande selectionner
        this.selectionner = h.get("selectionner");
        if (this.selectionner == null){
            throw new Exception("commande \"selectionner\" manquante");
        }
        this.selectionnerEnr = h.get("selectionnerEnr");
        if (this.selectionnerEnr == null){
            throw new Exception("commande \"selectionnerEnr\" manquante");
        }

        //Vérification et Initialisation de la commande insérer
        this.inserer = h.get("inserer");
        if (this.inserer == null){
            throw new Exception("commande \"insérer\" manquante");
        }
        this.insererEnr = h.get("insererEnr");
        if (this.insererEnr == null){
            throw new Exception("commande \"insererEnr\" manquante");
        }

        //Vérification et Initialisation de la commande afficher
        this.afficher = h.get("afficher");
        if (this.afficher == null){
            throw new Exception("commande \"afficher\" manquante");
        }

        //Vérification et Initialisation de la commande rejouer
        this.rejouer = h.get("rejouer");
        if (this.rejouer == null){
            throw new Exception("commande \"rejouer\" manquante");
        }

        //Vérification et Initialisation de la commande debutEnregistrer
        this.debutEnregistrer = h.get("debutEnregistrer");
        if (this.debutEnregistrer == null){
            throw new Exception("commande \"debutEnregistrer\" manquante");
        }

        //Vérification et Initialisation de la commande finEnregistrer
        this.finEnregistrer = h.get("finEnregistrer");
        if (this.finEnregistrer == null){
            throw new Exception("commande \"finEnregistrer\" manquante");
        }

    }

    /**
     * Setter qui nous permet d'inialiser l'ensemble des commandes
     *
     *  Lancement de l'éditeur de texte, ici on boucle tant que l'utilisateur ne quitte pas l'application avec la commande quitter
     *  La gestion des raccourcis et gérer ici, à chaque commande on execute son code correspondant
     */
    public void lancementEditeur(){
        // Create the Scanner from the standard input
        String input;


        // Ask the user to enter a v1.src.command
        System.out.print("Bienvenue dans notre Editeur de texte, veuillez entrer une commande: ");
        // While he pui an input
        while (scanner.hasNext()) {

        	System.out.println(etatrec);
            // Get the new input
                input = scanner.nextLine();

                // In function of the v1.src.command that he akss
                switch (input) {

                    // Select
                    case SELECTION_COMMANDE:

                    		//Création d'un nouveau scanner
                            Scanner scannerSelection = new Scanner(System.in);
                            // Ask values first
                            System.out.println("Indice du début de votre sélection:");

                            //TODO Faire un test ici
                            this.debutSelection =  scannerSelection.nextInt();

                            System.out.println("Indice de fin de votre s�lection:");

                            //TODO Faire un test ici
                            this.finSelection = scannerSelection.nextInt();
                            if(!etatrec)
                        	{
                            	this.selectionner.execute();
                        	}else{
                        		this.selectionnerEnr.execute();
                        	}

                        break;


                    // Insert
                    case INSERTION_COMMANDE:
                        System.out.println("Inserez le texte : ");
                        texteUser = this.getString();
                        if(!etatrec)
                    	{
                        	this.inserer.execute();
                    	}else{
                    		this.insererEnr.execute();
                    	}

                        break;

                    // Afficher
                    case AFFICHER_COMMANDE:
                        this.afficher.execute();
                        break;


                    // Copy
                    case COPIER_COMMANDE:
                        if(!etatrec)
                    	{
                        	this.copier.execute();
                    	}else{
                    		this.copierEnr.execute();
                    	}

                        break;


                    // Cut
                    case COUPER_COMMANDE:
                        if(!etatrec)
                    	{
                        	this.couper.execute();
                    	}else{
                    		this.couperEnr.execute();
                    	}
                        break;


                    // Paste
                    case COLLER_COMMANDE:
                        if(!etatrec)
                    	{
                        	this.coller.execute();
                    	}else{
                    		this.collerEnr.execute();
                    	}
                        break;

                    // Debut macro
                    case DEBUT_MACRO:
                        this.debutEnregistrer.execute();
                        break;

                    // Fin macro
                    case FIN_MACRO:
                        this.finEnregistrer.execute();
                        break;

                    // Rejouer macro
                    case REJOUER_MACRO:
                        this.rejouer.execute();
                        break;

                    // Quit
                    case QUITTER_COMMANDE:

                        // Avoid leaks
                        scanner.close();

                        // Say goodbye
                        System.out.println("\n Fermeture du programme");
                        System.exit(0);
                        break;


                    // Default action
                    default:
                        System.out.println("Commande non reconnue '" + input + "'");

                }  // End of switch

            System.out.println("Nouvelle commande:");


        }  // End of while
    }
    
    @Override
    public void notifyMe(Observable observable){
        this.observable = observable;
        if(observable instanceof Moteur)
        {
        	Moteur m = (Moteur)observable;
        }else{
        	Enregistreur e = (Enregistreur)observable;
        	etatrec = e.getEtatRec();
        }
    }
  
}