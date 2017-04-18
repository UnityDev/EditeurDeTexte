package src.memento;

/**
 * Created by Antoine on 29/11/2016.
 */
public class MementoSelectionner implements Memento {
	private int debutSelect;
	private int finSelect;
	private String type = "selectionnerEnregistrer";
	
	public MementoSelectionner(){
		debutSelect = 0;
		finSelect = 0;
	}

	public int getDebutSelect() {
		return debutSelect;
	}

	public void setDebutSelect(int debutSelect) {
		this.debutSelect = debutSelect;
	}

	public int getFinSelect() {
		return finSelect;
	}

	public void setFinSelect(int finSelect) {
		this.finSelect = finSelect;
	}
	
	public String getType(){
		return "selectionnerEnr";
	}
}
