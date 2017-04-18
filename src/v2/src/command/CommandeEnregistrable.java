package src.command;

import src.memento.Memento;

/**
 * Created by Antoine on 29/11/2016.
 */

/**
 * Interface pour les commandes enregistrables
 */
public interface CommandeEnregistrable {

    public void execute();
    public Memento getMemento();
    public void setMemento(Memento m);

}