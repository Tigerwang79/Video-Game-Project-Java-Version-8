import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {

	private ArrayList<Objets> inventaire = new ArrayList<>();
	private ArrayList<Lieux> lieuxVisit = new ArrayList<>();
	private ArrayList<Lieux> lieuxEnt = new ArrayList<>();
	private Lieux position;

	public ArrayList<Lieux> getLieuxVisit() {
		return lieuxVisit;
	}

	public Lieux getPosition() {
		return position;
	}


	//CONSTRUCTEUR
	/**
	 * 
	 * @param pos
	 */
	public Joueur(Lieux pos) {
		this.position = pos;
	}


	//METHODE
	/**
	 * 
	 * @param obj
	 */
	public void addObj(Objets obj) {
		this.inventaire.add( obj );
	}

	/**
	 * 
	 * @param lieu
	 */
	public void addLieuVisit(Lieux lieu) {
		this.lieuxVisit.add( lieu );
	}

	/**
	 * 
	 * @param lieu
	 */
	public void addLieuEnt(Lieux lieu) {
		this.lieuxEnt.add( lieu );
	}

	/**
	 * 
	 * @param lieu
	 */
	public void changePos(Lieux lieu) {
		Scanner sc = new Scanner(System.in);
		this.position = lieu;
		this.position.affiche();
		System.out.println("-Appuyez sur entrer");
		sc.nextLine();
	}

	public void afficheInv() {
		System.out.println("        Mon inventaire :        \n");
		if(this.inventaire.size() == 0){
			System.out.println("Vous ne possédez pas d'objet(s)");
		}else {
			for (int i = 0; i < this.inventaire.size(); i++) {
				System.out.println( "    Nom : " + this.inventaire.get( i ).getNom() );
				System.out.println( "    Description : " + this.inventaire.get( i ).getDescription()+"\n");
			}
		}
		System.out.println();

	}

	public  int nbLieu(){
		return lieuxEnt.size();
	}

	public Objets chercheObj() {
		Objets obj=null;
		switch (this.position.getId()){
			case 0 :
				System.out.println("Vous cherchez dans votre bureau un objet pouvant vous être utile.\n");
				break;
			case 1 :
				System.out.println("Vous commencez à fouiller dans le commissariat.\n" +
						"Sous le regard médusé des fonctionnaires sur place.\n" +
						"Vous arrêtez quand vous remarquez leurs regards.\n");
				break;
			case 2 :
				System.out.println("Au moment où vous alliez fouiller\n" +
						"vous vous êtes demandé si fouiller une morgue était\n" +
						"vraiment nécessaire.\n" +
						"Le regard de la médecin légiste vous a tout de suite donné la réponse.\n");
				break;
			case 3 :
				System.out.println("Vous commencez à chercher des objets pouvant être utiles chez Monique\n" +
						"Vous sentez qu'elle a l'habitude de ce genre de chose.\n" +
						"En même temps, vous êtes dans un commerce.\n");
				break;
			case 4 :
				System.out.println("Vous êtes en train de fouiller la scène de crime.\n" +
						"Qu'on bien pu rater les policiers ?\n");
				break;
			case 5 :
				System.out.println("Vous vous dites que fouiller dans un restaurant est une bonne idée.\n" +
						"Jusqu'à ce que le propriétaire vous montre sa panoplie de couteaux.\n");
				break;
			case 6 :
				System.out.println("Vous partez a la recherche d'objets qui pourrais vous être utiles.\n" +
						"Carine Presus vous laisse chercher dans l'espoir\n" +
						"que vous trouviez le meurtrier de son fils.\n");
				break;
			default:
				System.out.println("Comment es tu arrivé là ?");
		}

		this.position.afficheObjets();
		for(int i=this.position.nbObjet()-1; i >= 0 ; i--){
			if(this.position.getObjet(i).getCanBeFound()){
				obj = this.position.getObjet(i);
				System.out.println("-Vous avez pris : "+this.position.getObjet(i).getNom());
				this.inventaire.add(this.position.getObjet(i));
				this.position.getObjet(i).take();
				this.position.remObjet(i);
			}
		}
		return obj;


	}
}