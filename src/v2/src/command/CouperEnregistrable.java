package src.command;

import src.receiver.Enregistreur;
import src.memento.Memento;
import src.memento.MementoCouper;
import src.receiver.Moteur;

/**
 ** Execution du pattern cmmande enregistrable du src.memento pour couper
 */
public class CouperEnregistrable extends Command implements
        CommandeEnregistrable {
    public CouperEnregistrable(Moteur moteur, Enregistreur enr) {
        this.moteur = moteur;
        enregistreur = enr;
    }

    private Enregistreur enregistreur;

    @Override
    public void execute() {
        enregistreur.enregistrer(this);
        moteur.couper();
    }

    @Override
    public Memento getMemento() {
    	MementoCouper m = new MementoCouper();
        return m;
    }

    @Override
    public void setMemento(Memento m) {
    }

}
