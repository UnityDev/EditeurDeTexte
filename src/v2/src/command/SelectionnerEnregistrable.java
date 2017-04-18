package src.command;

import src.invoker.IHM;
import src.memento.MementoSelectionner;
import src.receiver.Enregistreur;
import src.memento.Memento;
import src.receiver.Moteur;

/**
 ** Execution du pattern cmmande enregistrable du src.memento pour sélectionner
 */
public class SelectionnerEnregistrable extends Command implements
        CommandeEnregistrable {

	private int debutSelect;
	private int finSelect;
	
    public SelectionnerEnregistrable(Moteur moteur, IHM ihm, Enregistreur enr) {
    	this.moteur = moteur;
    	this.ihm = ihm;
        enregistreur = enr;
    }

    private Enregistreur enregistreur;

    @Override
    public void execute() {
        enregistreur.enregistrer(this);
        moteur.setSelection(ihm.getDebutSelection(), ihm.getFinSelection());
    }

    @Override
    public Memento getMemento() {
    	Memento m = new MementoSelectionner();
    	((MementoSelectionner)m).setDebutSelect(ihm.getDebutSelection());
    	((MementoSelectionner)m).setFinSelect(ihm.getFinSelection());
        return m;
    }

    @Override
    public void setMemento(Memento m) {
    	ihm.setDebutSelection(((MementoSelectionner)m).getDebutSelect());
    	ihm.setFinSelection(((MementoSelectionner)m).getFinSelect());
    	System.out.println(ihm.getDebutSelection());
    	System.out.println(ihm.getFinSelection());
    }

}
