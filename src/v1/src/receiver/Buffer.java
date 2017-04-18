package src.receiver;

/**
 * Created by Antoine on 24/11/2016.
 */
public class Buffer {

    //Txt du buffer
    private StringBuffer texte;

    //Constructeur
    public Buffer() {
        this.texte = new StringBuffer("");
    }

    /**
     * Getter pour récupérer le txt
     */
    public StringBuffer getTexte(){
        return this.texte;
    }

    /**
     * Setter pour set le texte
     */
    public void setTexte(StringBuffer texte){
        this.texte = texte;
    }

}
