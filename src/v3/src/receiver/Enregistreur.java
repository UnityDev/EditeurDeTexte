package src.receiver;


import java.util.*;


/**
 * Created by Antoine on 29/11/2016.
 */
public class Enregistreur {

    private Stack<GestionnaireUndoRedo> pileUndo;
    private Stack<GestionnaireUndoRedo> pileRedo;
    private Moteur moteur;
    public Enregistreur(Moteur moteur) {
        this.pileUndo = new Stack<GestionnaireUndoRedo>();
        this.pileRedo = new Stack<GestionnaireUndoRedo>();
        this.moteur = moteur;
    }

    /**
     * Ajoute un gestionnaireUndoRedo à la liste.
     *
     * @param buffer
     *            l'état actuel du buffer
     */
    public void enregistrer(Buffer buffer) {

        System.out.println("Commande correctement ajouté à la pile.");
        pileRedo.clear();
        //Création du gestionnaire
        GestionnaireUndoRedo gestionnaireUndoRedo = new GestionnaireUndoRedo(buffer.getTexte());
        pileUndo.push(gestionnaireUndoRedo);
        System.out.println("On enregistre dans la pile: " + gestionnaireUndoRedo.getTexteBuffer());

    }

    /**
     *  Execute la derniere commande qui a été undo
     */
    public void redo(){
        if(!pileRedo.empty()) {
            for(GestionnaireUndoRedo g :  pileRedo){
                System.out.println("Element dans la liste : " + g.getTexteBuffer());
            }
            if(pileRedo.size() > 1){
                GestionnaireUndoRedo m2 = pileRedo.pop();
                pileUndo.push(m2);
            }
            GestionnaireUndoRedo m = pileRedo.pop();
            pileUndo.push(m);
            moteur.getBuffer().setTexte(m.getTexteBuffer());
        }else{
            System.out.println("Impossible de redo car votre pile est vide");
        }
    }


    /**
     * Annule la dernier commande faite
     */
    public void undo(){
        if(!pileUndo.empty()){
            if(pileUndo.size() == 1){
                moteur.getBuffer().getTexte().setLength(0);
            }else{
                if(pileUndo.size() > 1){
                    GestionnaireUndoRedo m2 = pileUndo.pop();
                    pileRedo.push(m2);
                }
                GestionnaireUndoRedo m = pileUndo.pop();
                pileRedo.push(m);

                moteur.getBuffer().setTexte(m.getTexteBuffer());
            }
        }else{
            System.out.println("Impossible de undo car votre pile est vide");
        }
    }
}