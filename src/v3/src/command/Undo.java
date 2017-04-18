package src.command;

import src.receiver.Enregistreur;

/**
 * Created by Antoine on 30/11/2016.
 */
public class Undo extends Command{

    private Enregistreur enregistreur;

    public Undo(Enregistreur enregistreur) {
        this.enregistreur = enregistreur;
    }

    @Override
    public void execute() {
        enregistreur.undo();
    }

}
