/**
 * @(#) Command.java
 */

package src.command;

import src.invoker.IHM;
import src.receiver.Enregistreur;
import src.receiver.Moteur;

public abstract class Command {
    protected Moteur moteur;
    protected Enregistreur enregistreur;
    protected IHM ihm;

    public abstract void execute();

}