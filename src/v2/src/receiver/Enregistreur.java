package src.receiver;


import src.command.Command;
import src.command.CommandeEnregistrable;
import src.memento.Memento;
import src.observer.Observable;
import src.observer.Observateur;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by Antoine on 29/11/2016.
 */
public class Enregistreur extends Observable{

    private Queue<Memento> mementos;
    private HashMap<String, Command> commandes;
    private boolean etatrec;
    Observateur observateur;

    public Enregistreur() {
    	
        mementos = new LinkedList<Memento>();
        commandes = new HashMap<String, Command>();
    }
    
    public void setCommands(HashMap<String, Command> commandes)
    {
    	this.commandes = commandes;
    }

    /**
     * Ajoute une commande à la liste.
     *
     * @param c
     *            la commande à ajouter
     */
    public void enregistrer(CommandeEnregistrable c) {
        if (etatrec) {
            System.out.println("Commande correctement ajout�e");
            mementos.add(c.getMemento());
        }  
    }

    /**
     * Rejoue une macro préalablement enregistrée. Ne fonctionne pas si une
     * macro est en cours d'enregistrement. S'il n'y a pas encore de macro, ne
     * fait rien.
     */
    public void rejouer() {
        System.out.println("La macro a �t� rejou�!");
        System.out.println(mementos);
        if (!etatrec) {

            for (Iterator<Memento> it = mementos.iterator(); it.hasNext();) {
                Memento m = it.next();
                CommandeEnregistrable commandeEnregistrable = (CommandeEnregistrable) commandes.get(m.getType());
                commandeEnregistrable.setMemento(m);
                commandeEnregistrable.execute();
            }
        }
    }

    /**
     * Vide la précédente liste de commandes, et commence l'enregistrement d'une
     * nouvelle macro.
     */
    public void commencerEnregistrement() {
        System.out.println("D�but de l'enregistrement de la macro: ");
        mementos.clear();
        etatrec = true;
        notifyObservers();
    }

    /**
     * Arrête l'enregistrement d'une macro.
     */
    public void arreterEnregistrement() {
        System.out.println("Fin de l'enregistrement de la macro: ");
        etatrec = false;
        notifyObservers();
    }
    
    public boolean getEtatRec()
    {
    	return etatrec;
    }

 
    @Override
    public void notifyObservers() {
         observateur.notifyMe(this);
    }

    @Override
    public void registerObserver(Observateur o) {
        observateur = o;

    }

}