package src.command;

import src.invoker.IHM;
import src.receiver.Enregistreur;
import src.memento.Memento;
import src.memento.MementoInserer;
import src.receiver.Moteur;

/**
 ** Execution du pattern cmmande enregistrable du src.memento pour insérer
 */
public class InsererEnregistrable extends Command implements CommandeEnregistrable {
    public InsererEnregistrable(Moteur moteur, IHM ihm, Enregistreur enr) {
    	this.moteur = moteur;
    	this.ihm = ihm;
        enregistreur = enr;
    }

    private Enregistreur enregistreur;

    @Override
    public void execute() {
        enregistreur.enregistrer(this);
        moteur.inserer(ihm.getTexteUser());
    }

    @Override
    public Memento getMemento() {
        MementoInserer m = new MementoInserer();
        m.setInsertedText(ihm.getTexteUser());
        return m;
    }

    @Override
    public void setMemento(Memento m) {
    	ihm.setTexteUser(((MementoInserer)m).getInsertedText());
    }

}
