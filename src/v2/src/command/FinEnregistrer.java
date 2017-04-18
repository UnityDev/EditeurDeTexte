package src.command;

import src.receiver.Enregistreur;

/**
 ** Execution de la commande fin enregistrer
 */
public class FinEnregistrer extends Command {

    private Enregistreur enregistreur;

    public FinEnregistrer(Enregistreur e) {
        enregistreur = e;
    }

    @Override
    public void execute() {
        enregistreur.arreterEnregistrement();
    }

}
