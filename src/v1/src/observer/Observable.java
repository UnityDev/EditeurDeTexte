/**
 * @(#) Subject.java
 */

package src.observer;

/**
 * La classe Observable du patron de conception Observer. Son rôle est de notifier
 * ses observers quand une mise à jour est nécessaire.
 *
 */
public abstract class Observable {
    protected Observateur observateur;
    /**
     * Notifie tous les <i>Observers</i> enregistrés.
     */
    public abstract void notifyObservers();

    /**
     * Inscrit un nouvel <i>Observer</i>.
     *
     * @param o
     *            l'src.observer à enregistrer
     */
    public abstract void registerObserver(Observateur o);


}