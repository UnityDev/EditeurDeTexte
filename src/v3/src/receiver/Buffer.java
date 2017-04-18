package src.receiver;

/**
 * Created by Antoine on 24/11/2016.
 */
public class Buffer {

    private StringBuffer texte;

    public Buffer() {
        this.texte = new StringBuffer("");
    }

    public StringBuffer getTexte(){
        return this.texte;
    }

    public void setTexte(StringBuffer texte){
        this.texte = texte;
    }

}
