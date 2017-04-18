package src.command;

import src.receiver.Enregistreur;

/**
 ** Execution de la commande rejouer
 */
public class Rejouer extends Command {

    private Enregistreur enregistreur;

    public Rejouer(Enregistreur e) {
        enregistreur = e;
    }

    @Override
    public void execute() {
        enregistreur.rejouer();
    }

}
