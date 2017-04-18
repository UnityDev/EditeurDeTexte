/**
 * @(#) Buffer.java
 */

package src.receiver;

import src.observer.Observable;
import src.observer.Observateur;

/**
 * La classe moteur gère les modifications apportées au texte, sélection, pressepapier
 */
public class Moteur extends Observable {

    private Buffer buffer;
    private PressePapiers pressePapiers;
    private Selection selection;
    Observateur observateur;

    //Constructeur du moteur
    public Moteur() {
        buffer = new Buffer();
        pressePapiers = new PressePapiers();
        selection = new Selection();
    }


    /**
     * Affiche le texte contenu dans le buffer
     */
    public void afficher() {
        System.out.println(buffer.getTexte());
    }

    /**
     * Copie le texte sélectionné dans le presse-papiers
     * Si on a une sélection alors on supprimme cette dernière
     * Si on a aucune selection alors la commande ne fait rien
     */
    public void couper() {
        if (selection.getLongueur() > 0) {
            pressePapiers.setContenu(getSelection());

            //Chaîne à insérer dans le buffer
            StringBuffer str = new StringBuffer(buffer.getTexte().substring(0, selection.getDebut()) + buffer.getTexte().substring(selection.getDebut() + selection.getLongueur()));
            buffer.setTexte(str);
            selection.setLongueur(0);
            notifyObservers();
        }
    }

    /**
     * Copie le texte sélectionné dans le presse-papiers
     * Si on a aucune sélection on ne fait rien.
     */
    public void copier() {
        if (selection.getLongueur() > 0) {
            pressePapiers.setContenu(getSelection());
        }
    }

    /**
     * Colle le contenu du presse papier à la place de la sélection
     */
    public void coller() {
        int selection_debut = selection.getDebut();
        if (selection.getLongueur() == 0) {
            //Chaine à coller
            StringBuffer str = new StringBuffer(buffer.getTexte().substring(0,selection_debut) + pressePapiers.getContenu() + buffer.getTexte().substring(selection_debut));
            buffer.setTexte(str);
            selection.setDebut(selection_debut + pressePapiers.getContenu().length());
        } else {
            StringBuffer str = new StringBuffer(buffer.getTexte().substring(0, selection_debut) + pressePapiers.getContenu() + buffer.getTexte().substring(selection_debut + selection.getLongueur()));
            buffer.setTexte(str);
            selection.setDebut(selection_debut + pressePapiers.getContenu().length());
            selection.setLongueur(0);
        }
        notifyObservers();
    }

    /**
     * Insère le caractère tapé dans le buffer à l'emplacement du curseur, ou à
     * la place du texte sélectionné.
     *
     * @param chaine_insert
     *            le caractère tapé
     */
    public void inserer(String chaine_insert) {
        int selection_debut = selection.getDebut();
        if (selection.getLongueur() == 0) {
            StringBuffer str = new StringBuffer(buffer.getTexte().substring(0, selection_debut)  + chaine_insert + buffer.getTexte());
            buffer.setTexte(str);
        } else {
            StringBuffer str = new StringBuffer(buffer.getTexte().substring(0, selection_debut) + chaine_insert + buffer.getTexte().substring(selection_debut + selection.getLongueur()));
            buffer.setTexte(str);
            selection.setDebut(selection_debut + 1);
            selection.setLongueur(0);
        }
        notifyObservers();
    }

    /**
     * Renvoie la sous-chaîne du texte actuellement sélectionnée.
     *
     * @return le texte sélectionné
     */
    public String getSelection() {

        int selectionDebut = selection.getDebut();
        int selectionLongueur = selection.getLongueur();
            if (selection.getLongueur() > 0) {
                return buffer.getTexte().substring(selectionDebut, selectionDebut + selectionLongueur);
            } else {
                return "";
            }

    }

    /**
     * Setter pour sélectionner la selection en fonction de nos bornes
     */
    public void setSelection(int debut, int longueur) {
        int selectionDebut = selection.getDebut();
        int selectionLongueur = selection.getLongueur();
        if(selectionDebut > 0 && selectionLongueur<buffer.getTexte().length()) {
            selection.setDebut(debut);
            selection.setLongueur(longueur);
        }else{
            selection.setDebut(0);
            selection.setLongueur(0);
            System.out.println("Selection hors bornes, la sélection n'a pas fonctionné");
        }

    }

    /**
     * Renvoie le presse papier
     *
     * @return le texte sélectionné
     */
    public PressePapiers getPressePapier(){
        return this.pressePapiers;
    }

    /**
     * Getter pour récupérer le buffer
     *
     * @return le buffer
     */
    public Buffer getBuffer(){
        return this.buffer;
    }

    /**
     * Méthode pour notifier
     */
    @Override
    public void notifyObservers() {
        observateur.notifyMe(this);
    }

    /**
     * Méthode pour enregistrer un src.observer
     */
    @Override
    public void registerObserver(Observateur o) {
        observateur = o;

    }
}