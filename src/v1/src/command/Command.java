/**
 * @(#) Command.java
 */

package src.command;

import src.receiver.Moteur;
import src.invoker.IHM;

//Classe abstraire de la classe commande, ici on aurait pu choisir une interface également
public abstract class Command {
    protected Moteur moteur;
    protected IHM ihm;

    public abstract void execute();

}