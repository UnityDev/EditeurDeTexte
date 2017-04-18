/**
 * @(#) IHMObserver.java
 */

package src.observer;

/**
 * La classe Observateur du patron de conception Observer. Son rôle est de notifier
 * ses observers quand une mise à jour est nécessaire.
 *
 */
public interface Observateur{
	/*
    protected Observable subject;

    public Observateur(Observable sub) {
        subject = sub;
    }
	*/
    void notifyMe(Observable observable);

}