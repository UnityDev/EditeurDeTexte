package src.command;

import src.receiver.Enregistreur;
import src.memento.Memento;
import src.memento.MementoCopier;
import src.receiver.Moteur;

/**
 * Created by Antoine on 29/11/2016.
 */

/**
 ** Execution du pattern cmmande enregistrable du src.memento pour copier
 */
public class CopierEnregistrable extends Command implements
        CommandeEnregistrable {

    public CopierEnregistrable(Moteur moteur, Enregistreur enr) {
    	this.moteur = moteur;
        enregistreur = enr;
    }

    private Enregistreur enregistreur;

    @Override
    public void execute() {
        enregistreur.enregistrer(this);
        moteur.copier();
    }

    @Override
    public Memento getMemento() {
    	MementoCopier m = new MementoCopier();
        return m;
    }

    @Override
    public void setMemento(Memento m) {
    }

}
