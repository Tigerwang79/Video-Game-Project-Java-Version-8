import javax.swing.text.StyledEditorKit;
import java.util.Scanner;

public class Personnages extends Affichants {

	private int id;
	private String nom;
	private String description;
	private Dialogues dialogue;


	/**
	 * 
	 * @param nom
	 * @param desc
	 * @param dial
	 */
	public Personnages(int id, String nom, String desc, Dialogues dial) {
		this.id = id;
		this.nom = nom;
		this.description = desc;
		this.dialogue = dial;
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}

	public Dialogues getDialogue() {
		return dialogue;
	}


	/**
	 * 
	 * @param dial
	 */
	public void changeDialogue(Dialogues dial) {
		this.dialogue = dial;
	}


	public void talk() {
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.print(this.nom + " : ");
		this.dialogue.affiche();
		do {
			System.out.print("Entrez un nombre : ");
			i = sc.nextInt();
		}while (i<0 || i>= this.dialogue.getNbReponse());
		//clearConsole();
		System.out.println("\n\n");
		this.dialogue.getReponse(i).afficheLong();

		this.dialogue= this.dialogue.getReponse(i).getDialogSuiv();

	}

	public void affiche() {
		System.out.println("Description du personnage : " + this.description);
	}

	public int getId(){
		return  this.id;
	}

}