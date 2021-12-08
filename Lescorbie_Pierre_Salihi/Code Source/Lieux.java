import java.util.ArrayList;
public class Lieux extends Affichants {

	private int id;
	private String nom;
	private String description;
	private ArrayList<Personnages> listePerso = new ArrayList<>();
	private ArrayList<Objets> listeObjet = new ArrayList<>();


	public ArrayList<Personnages> getListePerso() {
		return listePerso;
	}

	/**
	 * 
	 * @param id
	 * @param nom
	 * @param desc
	 */
	public Lieux(int id, String nom, String desc) {
		this.id = id;
		this.nom = nom;
		this.description = desc;
	}

	public String getNom() {
		return this.nom;
	}

	public String getDescription() {
		return this.description;
	}
	public int getId() { return this.id;	}


	/**
	 * 
	 * @param perso
	 */
	public void addPerso(Personnages perso) {
		this.listePerso.add( perso );
	}

	/**
	 * 
	 * @param obj
	 */
	public void addObj(Objets obj) {
		this.listeObjet.add( obj );
	}
	/**
	 * 
	 * @param pos
	 */
	public void remPerso(int pos) {
		this.listePerso.remove( pos );
	}

	/**
	 * 
	 * @param pos
	 */
	public void remObjet(int pos) {
		this.listeObjet.remove( pos );
	}

	public void afficheObjets() {
		ArrayList<Objets> lstObj = new ArrayList<>();
		System.out.println("Resultat de la recherche :");
		for (int j =0; j<this.listeObjet.size();j++){
			if(this.listeObjet.get(j).getCanBeFound()){
				lstObj.add(this.listeObjet.get(j));
			}
		}

		if(lstObj.size() == 0){
			System.out.println("Aucun objet important n'est présent.");
		}else {
			for (int i = 0; i < lstObj.size(); i++) {
				System.out.println( "\tNom : " + lstObj.get( i ).getNom() );
				System.out.println("\t"+lstObj.get(i).getDescription()+"\n");
			}
		}
		//System.out.println("***		Fin Objets		***");
	}

	public void affiche() {
		System.out.println("\n"+this.getDescription()+"\n");
	}


	/**
	 * 
	 * @param pos
	 */
	public Objets getObjet(int pos) {
		return this.listeObjet.get( pos );
	}

	public  int nbObjet(){
		return listeObjet.size();
	}

	/**
	 * 
	 * @param pos
	 */
	public Personnages getPersonnage(int pos) {
		return this.listePerso.get( pos );
	}

}