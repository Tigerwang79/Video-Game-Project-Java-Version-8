import java.util.ArrayList;
public class Reponses extends Affichants {

	private int id;
	private String texteCourt;
	private String texteLong;
	private ArrayList<Objets> listeObjets  = new ArrayList<>();
	private Dialogues dialogSuiv;


	public String getTexteCourt() {
		return texteCourt;
	}

	public ArrayList<Objets> getListeObjets() {
		return listeObjets;
	}

	public Dialogues getDialogSuiv() {
		return dialogSuiv;
	}

	/**
	 * 
	 * @param id
	 * @param texteCourt
	 * @param texteLong
	 */
	public Reponses(int id, String texteCourt, String texteLong) {
		this.id = id;
		this.texteCourt = texteCourt;
		this.texteLong = texteLong;
	}

	/**
	 * 
	 * @param obj
	 */
	public void addObjet(Objets obj) {
		this.listeObjets.add( obj );
	}

	/**
	 * 
	 * @param dial
	 */
	public void changeDialogue(Dialogues dial) {

		this.dialogSuiv = dial;
	}


	public void afficheLong(){
		if(this.texteLong != ""){
			System.out.println("Andrew : " + this.texteLong + "\n");
		}
	}

	public void affiche() {

	}

	public int getId() {
		return this.id;
	}

}