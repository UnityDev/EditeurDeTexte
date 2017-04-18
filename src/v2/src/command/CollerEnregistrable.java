package src.command;

import src.receiver.Enregistreur;
import src.memento.Memento;
import src.memento.MementoColler;
import src.receiver.Moteur;

/**
 * Created by Antoine on 29/11/2016.
 */
public class CollerEnregistrable extends Coller implements
        CommandeEnregistrable {

    public CollerEnregistrable(Moteur moteur, Enregistreur enr) {
        super(moteur);
        enregistreur = enr;
    }

    private Enregistreur enregistreur;

    @Override
    public void execute() {
        enregistreur.enregistrer(this);
        super.execute();
    }

    @Override
    public Memento getMemento() {
        return new MementoColler();
    }

    @Override
    public void setMemento(Memento m) {
    }

}
