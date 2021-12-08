import java.util.ArrayList;
import java.util.Scanner;

public class Dialogues extends Affichants {

	private int id;
	private String texte;
	private ArrayList<Reponses> listReponses = new ArrayList<>();
	private boolean isEnd;
	private boolean isEndOfGame;
	private  ArrayList<Objets> debloqueObjet = new ArrayList<>();
	private ArrayList<Lieux> debloqueLieu = new ArrayList<>();

	/**
	 * 
	 * @param id
	 * @param texte
	 * @param isEnd
	 */
	public Dialogues(int id, String texte, boolean isEnd, boolean isEndOfGame) {
			this.id = id;
			this.texte = texte;
			this.isEnd = isEnd;
			this.isEndOfGame = isEndOfGame;
	}


	public int getNbReponse(){
		return  this.listReponses.size();
	}

	public  Reponses getReponse(int i){
		return listReponses.get(i);
	}

	public void addReponse(Reponses rep) {

		this.listReponses.add( rep );
	}

	public void addObjet(Objets obj){
		debloqueObjet.add(obj);
	}

	public  void remLieu(){ debloqueLieu.remove(0);	}

	public void addLieu(Lieux l){ debloqueLieu.add(l);}

	public int nbLieu(){ return  debloqueLieu.size(); }

	public Lieux getLieu(int i){ return debloqueLieu.get(i);}

	public void affiche() {
		boolean b = Boolean.TRUE;
		System.out.println(this.texte +"\n");
		//1
		// System.out.println("***		Réponses :		***");
		if(!this.isEnd) {
			for (int i = 0; i < this.listReponses.size(); i++) {
				if (this.listReponses.get(i).getListeObjets().size() == 0) {
					System.out.println("	" + i + ") " + this.listReponses.get(i).getTexteCourt());
				} else {
					for (int j = 0; j < this.listReponses.get(i).getListeObjets().size(); j++) {
						b = b && this.listReponses.get(i).getListeObjets().get(j).getIsTaken();
					}
					if (b) {
						System.out.println("	" + i + ") " + this.listReponses.get(i).getTexteCourt());
					}
				}
			}
			System.out.println();
		}
	}

	public void unlockItems(){
		if(debloqueObjet.size() > 0){
			for (int i =0; i<debloqueObjet.size(); i++){
				debloqueObjet.get(i).CanBeFound();
			}
		}
	}

	public int getId() {

		return this.id;
	}

	public boolean getIsEnd(){
		return this.isEnd;
	}
	public boolean getIsEndOfGame(){
		return this.isEndOfGame;
	}


}