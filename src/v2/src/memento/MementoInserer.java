package src.memento;

/**
 * Created by Antoine on 29/11/2016.
 */
public class MementoInserer implements Memento {
	private String insertedText;
	
	public MementoInserer(){
		insertedText = "";
	}

    public String getInsertedText() {
		return insertedText;
	}

	public void setInsertedText(String insertedText) {
		this.insertedText = insertedText;
	}
	
	public String getType(){
		return "insererEnr";
	}
}
