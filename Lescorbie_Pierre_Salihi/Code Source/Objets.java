import jdk.nashorn.api.tree.WithTree;

public class Objets extends Affichants {

	private final int id;
	private final String nom;
	private final String description;
	private Boolean isTaken = Boolean.FALSE;
	private Boolean canBeFound = Boolean.TRUE;


	public Objets(int id, String nom, String description) {
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.isTaken = Boolean.FALSE;
		this.canBeFound = Boolean.TRUE;
	}

	public  boolean getCanBeFound(){
		return this.canBeFound;
	}

	public void CanBeFound(){
		this.canBeFound = Boolean.TRUE;
	}

	public void CantBeFound(){
		this.canBeFound = Boolean.FALSE;
	}

	public String getNom() {

		return this.nom;
	}

	public String getDescription() {

		return this.description;
	}

	public void affiche() {

		System.out.println("Description de l'objet : " + this.description);
	}

	public void take(){
		this.isTaken = Boolean.TRUE;
	}

	public Boolean getIsTaken(){
		return this.isTaken;
	}

	public int getId() {

		return  this.id;
	}

}