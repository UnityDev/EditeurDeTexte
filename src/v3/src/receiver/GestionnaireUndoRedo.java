package src.receiver;

/**
 * Created by Antoine on 30/11/2016.
 */
public class GestionnaireUndoRedo {
    private StringBuffer texteBuffer;


    public GestionnaireUndoRedo(StringBuffer texteBuffer){
        this.texteBuffer = texteBuffer;
    }

    public StringBuffer getTexteBuffer(){
        return this.texteBuffer;
    }

    public void setBuffer(StringBuffer texteBuffer){
        this.texteBuffer = texteBuffer;
    }

}
