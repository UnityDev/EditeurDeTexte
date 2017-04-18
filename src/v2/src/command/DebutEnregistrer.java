package src.command;

import src.receiver.Enregistreur;

/**
 ** Execution de la commande début enregistrer
 */
public class DebutEnregistrer extends Command {

    private Enregistreur enregistreur;

    public DebutEnregistrer(Enregistreur e) {
        enregistreur = e;
    }

    @Override
    public void execute() {
        enregistreur.commencerEnregistrement();
    }

}
