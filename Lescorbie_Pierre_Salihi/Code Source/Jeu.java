import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
	private Joueur player;
	private ArrayList<Objets> objets = new ArrayList<>();
	private ArrayList<Reponses> reponses = new ArrayList<>();
	private ArrayList<Dialogues> dialogues = new ArrayList<>();
	private ArrayList<Personnages> personnages = new ArrayList<>();
	private ArrayList<Lieux> lieux = new ArrayList<>();




	public void menu() {
		Scanner sc = new Scanner( System.in );
		int choix;
		System.out.println("*************************************************************************************************");
		System.out.println("****************************        Les aventures de Mr.Benett       ****************************");
		System.out.println("*************************************************************************************************");
		System.out.println();
		System.out.println("\t\t\t    ****************************************");
		System.out.println("\t\t\t    *                Menu                  *");
		System.out.println("\t\t\t    ****************************************");
		//System.out.println();
		System.out.println("\t\t\t\t\t1 - Jouer");
		System.out.println("\t\t\t\t\t2 - A propos");
		System.out.println("\t\t\t\t\t3 - Quitter\n");
		System.out.print("Pour accéder au contenu suivant entrez un nombre : ");
		choix = sc.nextInt();
		System.out.println();
		switch (choix){
			case 1 :

				clearConsole();
				System.out.println();
				preparation();
				jeu();
				break;
			case 2 :
				clearConsole();
				System.out.println("********************************************************************************");
				System.out.println("****************************        Synopsis        ****************************");
				System.out.println("********************************************************************************");
				System.out.println();
				System.out.println("Vous incarnez Andrew Benett, votre but et la recherche de grimoires magique.\n" +
						"Vous entendez parler d'un meurtre suspect, probablement du l\'un de ses grimoires.\n" +
						"Vous décidez de vous rendre en ville et accompagné du commissaire local vous aller mener votre enquête.\n" +
						"Vous vous rendez vite compte que le meurtre est lié a la magie.\n" +
						"Votre enquête vous mèneras dans plusieurs endroit clés de la ville, et a rencontré plusieurs personnes qui vous aiderons.\n" +
						"Grace a vos connaissances vous devrez trouver la cause de la mort ainsi que le coupable.\n" +
						"Mais attention les grimoires recèlent plein de secrets.");

				System.out.println("*******\t Credit \t*******\n");
				System.out.println("---Programmation\n"+
						"\tGuillaume\tPierre\n" +
						"\tValdrin\t\tSalihi\n"+
						"\tValentin\tLescorbie");
				sc.nextLine();
				System.out.println("---Creation de l'histoire\n" +
						"\tValentin\tLescorbie");

				System.out.println("---Remerciement speciaux\n"+
						"\tRonan\t\tPluta\n\n");
				retour();


				break;
			case 3:
				System.exit( 0 );
				break;
			default:
				menu();
		}
	}

	public void retour(){
		Scanner sc = new Scanner( System.in );
		int choix;

		System.out.println("			1 - Retour");
		System.out.println("			2 - Quit");
		System.out.print("Pour accéder au contenu suivant entrez un nombre : ");
		choix = sc.nextInt();

		switch (choix){
			case 1:
				clearConsole();
				menu();
				break;
			case 2:
				System.exit( 0 );
			default:
				retour();
		}
	}


	public boolean actionsJoueur(){
		Scanner sc = new Scanner( System.in );
		boolean b = Boolean.TRUE;
		int choix;


		System.out.println("****************************        Actions        ****************************\n");

		//System.out.println("1 - Inventaire | 2 - Fouiller | 3 - Parler | 4 - Déplacer | 5 - Quitter le jeu");
		System.out.println("			1 - Inventaire");
		System.out.println("			2 - Fouiller");
		System.out.println("			3 - Parler");
		System.out.println("			4 - Déplacer");
		//System.out.println("			5 - Lieux non visités");
		System.out.println("			5 - Quitter le jeu\n");
		System.out.print("Pour accéder au contenu suivant entrez un nombre : ");
		choix = sc.nextInt();


		switch (choix){
			case 1 :
				clearConsole();
				player.afficheInv();
				break;
			case 2 :
				clearConsole();
				Objets obj = player.chercheObj();
				if(obj != null) {
					if (obj.getId() == 2) {
						lieux.get(5).remPerso(1);
						lieux.get(5).addPerso(personnages.get(6));
					}
				}
				System.out.println();
				break;
			case 3 :
				clearConsole();
				parler();

				//Ajout de confirmation ?
				break;
			case 4 :
				clearConsole();
				deplacer();
				break;
			case 5 :
				System.out.println("Voulez vous vraiment quitter le jeu ?\n" +
						"\t1 - Oui\n" +
						"\t2 - Non");
				do {
					choix = sc.nextInt();
				}while (choix != 1 && choix !=2);
				if (choix == 1 ){
					clearConsole();
					System.exit( 0 );
				}else{
					b = actionsJoueur();
				}

				break;
			default:
				clearConsole();
				b = actionsJoueur();
		}
		return b;
	}
	public void parler() {

		Scanner sc = new Scanner( System.in );
		int choix;
		boolean b=Boolean.TRUE;;

		System.out.println("****************************        Parler        ****************************");

		if (player.getPosition().getListePerso().size() == 0) {
			System.out.println();
			switch (player.getPosition().getId()){
				case 0 :
					System.out.println("Vous ne laissez jamais entrer personne dans votre bureau\n" +
							"Vous etes donc seul.");
					break;
				case 4 :
					System.out.println("Un agent s'occupe de proteger le scène de crime,\n" +
							"vous ne pensez pas pouvoir tirer des informations de lui.");
					break;
				default:
					System.out.println("Il n\'y a personne.");
			}
			System.out.println();
		} else {
			System.out.println("Voici la liste des personnages presents :\n");
			for (int i = 0; i < player.getPosition().getListePerso().size(); i++) {
				System.out.println("			" + i + "- " + player.getPosition().getListePerso().get(i).getNom()+"\n");
			}
			System.out.print("Choisissez a qui vous voulez parler : ");
			do {
				choix = sc.nextInt();
			}while (choix<0 || choix >= player.getPosition().getListePerso().size());
			//clearConsole();
			Dialogues dial;
			Personnages perso = player.getPosition().getListePerso().get(choix);
			do {
				perso.talk();
				dial = perso.getDialogue();
				dial.unlockItems();
				if( dial.nbLieu() != 0){
					player.addLieuEnt(dial.getLieu(0));
					player.addLieuVisit(dial.getLieu(0));
					dial.remLieu();
				}
				if(dial.getIsEnd()){
					System.out.print(perso.getNom() + " : ");
					perso.getDialogue().affiche();
					if(dial.getId()==79){
						System.out.println("\n-Appuyez sur entrer");
						sc.nextLine();
						sc.nextLine();
					}
					if(!dial.getIsEndOfGame()) {
						perso.changeDialogue(perso.getDialogue().getReponse(0).getDialogSuiv());
					}
					b = Boolean.FALSE;
				}

			} while (b);

			if(perso.getDialogue().getIsEndOfGame()){
				finJeu();
			}
		}

	}

	public void deplacer(){
		Scanner sc = new Scanner( System.in );
		int choix;

		System.out.println("****************************        Déplacer        ****************************\n");


		if (player.getLieuxVisit().size() == 0) {
			System.out.println("Aucun lieu(x) présent pour se déplacer");
			System.out.println();
			System.out.println();
		} else {
			for (int i = 0; i < player.getLieuxVisit().size(); i++) {
				System.out.println("\t\t\t"+i + " - " + player.getLieuxVisit().get( i ).getNom() );
			}
			System.out.print( "\nPour accéder au contenu suivant entrez un nombre : " );
			do{
				choix = sc.nextInt();
			}while(choix>= player.nbLieu());
			this.player.changePos(player.getLieuxVisit().get(choix));
			if(this.player.getPosition().getId()== 2){
				if(this.player.getPosition().getPersonnage(0).getDialogue().getId() == 80){
					boolean b= Boolean.TRUE;
					Personnages perso = this.player.getPosition().getPersonnage(0);
					Dialogues dial;
					do {
						perso.talk();
						dial = perso.getDialogue();
						if(dial.getIsEnd()){
							System.out.print(perso.getNom() + " : ");
							perso.getDialogue().affiche();
							if(!dial.getIsEndOfGame()) {
								perso.changeDialogue(perso.getDialogue().getReponse(0).getDialogSuiv());
							}
							b = Boolean.FALSE;
						}

					} while (b);
					if(perso.getDialogue().getIsEndOfGame()){
						finJeu();
					}
				}
			}
		}
	}


	public void clearConsole()
	{
		for (int i = 0; i < 100; i++){
			System.out.println();
		}
	}




	public void preparation() {
		Scanner sc = new Scanner(System.in);

		//Instance Lieux
		lieux.add(new Lieux(0, "Bureau d'Andrew Benett", "Vous invoquez votre porte et entrez dans votre bureau.\n" +
				"fasse à vous, votre bureau où trône une machine à écrire.\n" +
				"Tout autour de vous, des bibliothèques où sont conservés une multitude d'ouvrages, de grimoires,\n"+
				" et de livre en tout genre parfaitement conservé grâce à vous,\n" +
				"À votre gauche, au mur, une horloge à la vitre brisée bloqué à 1 h 17,\n"+
				" la trotteuse avançant et reculant d'une seconde sans cesse, comme si le temps lui-même était cassé.\n"));
		lieux.add(new Lieux(1, "Commissariat - accueil", "Vous entrez dans le commissariat. \n" +
				"C'est un vieux bâtiment bien entretenu qui dispose d'un équipement moderne.\n" +
				"L'accueil est grand avec des sièges pour patienter.\n" +
				"Au fond, se trouve le commissaire Guy Corvo.\n"));
		lieux.add(new Lieux(2, "Commissariat - morgue","Vous descendez les escaliers pour aller à la morgue.\n" +
				"Dans cette pièce de 20 mètres carrés majoritairement blanche\n" +
				"se trouve la médecin légiste Sonia Rousselle,\n" +
				"à coté d'elle se trouve un cadavre, figé dans une expression d'horreur permanente.n"));
		lieux.add(new Lieux(3, "\"Chez Monique, pas de panique\"", "Vous suivez les indications du commissaire pour vous rendre chez Monique.\n" +
				"Le bâtiment de forme rectangulaire est composé d\\'un rez-de-chaussée et d'un étage, le bâtiment est de bonne facture.\n" +
				"Devant l'établissement, deux malheureux tabourets et une table font office de terrasse pour boire le thé.\n" +
				"Une vitrine extérieure offre à ses visiteurs un aperçu de l'intérieur de la boutique.\n" +
				"Au rez-de-chaussée, se trouve une salle de 30-40 mètres carrés. Sur la droite, un bureau avec une caisse enregistreuse.\n" +
				"Au centre, différentes étagères contenant toutes sortes de denrées alimentaires.\n" +
				"À l'étage, se trouvent les appartements de la propriétaire, Monique Cordier."));
		lieux.add(new Lieux(4, "le Pont de Camon - scène de crime", "Vous arrivez au niveau du pont.\n" +
				"Le pont est très ancien. Dessous, coule la rivière Suif\n" +
				"et au milieu du pont se trouve la scène de crime.\n" +
				"Une odeur horrible s'en dégage.\n" +
				"Vous montrez votre passe aux policiers présent afin d'avoir accès à la scène de crime."));
		lieux.add(new Lieux(5, "Restaurant \"Bol de la Loutre\" ", "Le bâtiment de forme rectangulaire est composé d\\'un unique rez-de-chaussée.\n" +
				"À l\\'intérieur, se trouve une salle pouvant contenir 12 personnes. Les murs propres et lisses, démontrent la qualité du restaurant.\n" +
				"Sur le côté, se situe la cuisine où Damien Presus est au fourneau.\n" +
				"Il n'a pas de recette favorite cependant, la cuisine y est bonne.\n" +
				"Les clients étaient anciennement accueillis et servis par François et sa mère Carine,\n" +
				"mais suite à la mort de François, elle n\\'y est pas revenue.\n" +
				"Aujourd'hui, son mari, tient le restaurant d'une main de maître, seul.\n" +
				"En plus de Damien Presus, il y a un client."));
		lieux.add(new Lieux(6, "Maison famille victime", "Le bâtiment en forme de L est composé d'un rez-de-chaussée et de deux étages,\n" +
				"la toiture est en parfait état (maison neuve).\n" +
				"Au rez-de-chaussée, se trouve la pièce à vivre ou pièce principale, sur le côté, on y trouve une salle d'eau.\n" +
				"Dans le fond, se trouve une grande cuisine.\n" +
				"À l\\'étage se trouve une chambre spacieuse. La chambre peut accueillir un couple, la porte se ferme avec un verrou.\n" +
				"Au deuxième étage se trouvent des chambres, deux chambres avec un minimum de commodité, ainsi qu'une serrure pour fermer la porte.\n"));


		//Instance Objets
		objets.add(new Objets(0, "CARDIMOMA", "C\'est un livre très ancien de recette de grand-mère contre tous les problèmes lié à l'estomac."));
		objets.add(new Objets( 1, "Paire de Lunette cassé", "Une paire de lunettes grises cassées, \nvous les avez trouvé près d'un buisson a l'écart de la scène de crime." ));
		objets.add(new Objets( 2, "Photo de François et d'un homme.", "Photo ou l\'on voit François et un homme avec des lunettes de travers souriants.\n \"Yve et Francois\" est écris au dos." ));
		objets.add(new Objets( 3, "Liste de noms", " Liste des noms des personnes qui pourraient posséder le Grimoire magique." ));
		objets.add(new Objets( 4, "Cendres noires odorantes", "Des cendres noires ayant une odeur forte, très particulière." ));
		objets.add(new Objets(5, "Codex Umbra","Nom : Ombrage\n" +
				"Invocation : Requiers un sacrifice humain\n" +
				"\"Information : Cette incarnation de la mort peut être invoquée en sacrifiant un humain et en suivant le rituel décrit. Une fois invoqué, il servira son maître.\n" +
				"Son corps est constitué majoritairement de fumée, quand cette créature tue elle aspire la vie de sa victime,\n" +
				"la laissant dans un état desséché. La vie ainsi volée est ensuite utilisée par la créature pour devenir plus puissante,\n" +
				"Créant dans le processus de la cendre noire odorante appelé, Sangbrage.\n" +
				"Cependant, du fait de sa nature ténébreuse, la créature ne peut pas supporter la lumière.\n" +
				"Une fois soumise à assez de lumière ou si son maître lui demande, elle se transformera en une sorte de perle d\\'un noir profond.\n" +
				"Après cela, si la créature est appelée par son maître et que le niveau de lumière est faible, la créature revient.\n" +
				"\n" +
				"Andrew : Un sacrifice humain ? Je crois comprendre les raisons de la disparition de l'assistante de la médecin légiste.\n" +
				"Je devrais aussi chercher une source de lumière."));
		objets.add(new Objets( 6, "Grosse lampe Torche", "C'est une torche extrêmement grosse ! A quoi pouvait-elle servir a Monique ?" ));

		//Instance Dialogues
		//Commisaire 1
		dialogues.add(new Dialogues(0, "Bonjour, ça fait longtemps !", false, false));
		dialogues.add(new Dialogues(1, "En 20 ans, tu n'as pas changé, pas une ride !", false, false));
		dialogues.add(new Dialogues(2, "En effet, on y peut rien.\nQue viens tu faire ici ?", false, false));
		dialogues.add(new Dialogues(3, "Ah c\'est vrai !\nQue viens-tu faire ici ?", false, false));
		dialogues.add(new Dialogues(4, "Ne cherche pas à me mentir.\nJe sais que tu es là pour le meurtre.", false, false));
		dialogues.add(new Dialogues(5, "Je t\'avoue qu'on aurait bien besoin de ton aide.\nMais j\'ai besoin que tu fasses un truc pour moi avant !", false, false));
		dialogues.add(new Dialogues(6, "Il se trouve qu'en se moment j\'ai de gros problèmes de digestion.\nTu n'aurais pas un remède dans un de tes grimoires ?", false, false));
		dialogues.add(new Dialogues(7, "Si tu ne m\'aides pas, tu ne pourras pas voir le corps.", false, false));
		dialogues.add(new Dialogues(8, "C'est dommage une prochaine fois peut être...", false, false));
		dialogues.add(new Dialogues(9, "Parfait ! Je t'attends ici.", true, false));
		dialogues.add(new Dialogues(10, "Alors tu ne verras pas la morgue.\n" +
				"\n" +
				"Suite a ça, vous vous fâchez avec le commissaire.\n" +
				"Vous finissez par vous battre.\n" +
				"Il vous fait arrêter pour entrave à la justice\n" +
				"et atteinte envers un représentant de l'ordre.\n" +
				"Connaissant votre porte, le commissaire a fait en sorte que\n" +
				"vous ne pouvez pas vous enfuir avec.\n", true, true));
		dialogues.add(new Dialogues(11, "Deja de retour ? As tu ce que je t'ai demandé ?", false, false));
		dialogues.add(new Dialogues(12, "Parfait, va a la morgue de ma part.\n" +
				"La légiste, Sonia Rousselle est inquiete car son assistante a disparue il y a un mois.\n" +
				"Pendant que tu parles a Sonia je vais te préparer une voiture.\n" +
				"retrouve moi a l'accueil quand tu as fini", true, false));
		dialogues.add(new Dialogues(13, "Tu dois bien avoir des infos dans les grimoires de ta piece.", true, false));

//Medecin Legiste
		dialogues.add(new Dialogues( 14, "Bonjour, Andrew Benett je presume ?", false, false ));
		dialogues.add(new Dialogues( 15, "Ravie aussi.\n" +
				"La victime est François Presus, 26 ans il travaillait au restaurant \"Bol de la loutre\".\n" +
				"Il a été retrouvé mort desséché hier soir au niveau du pont de Camon.\n" +
				"Je ne connais pas encore ni la cause de la mort ni l'heure exacte de celle-ci.", false,false ));
		dialogues.add(new Dialogues( 16, "Le commissaire m'a prevenue que vous alliez venir me voir.\n" +
				"Il m'a demander de vous dire tout ce que je sais sur le corps\n" +
				"La victime est François Presus, 26 ans il travaillait au restaurant \"Bol de la loutre\".\n" +
				"Il a été retrouvé mort desséché hier soir au niveau du pont de Camon.\n" +
				"Je ne connais pas encore ni la cause de la mort ni l'heure exacte de celle-ci.", false, false));
		dialogues.add(new Dialogues( 17, "Que puis-je faire pour vous ?",false, false));
		dialogues.add(new Dialogues( 18, "Bien sur !\nLa victime est François Presus.\n Il serait mort de dessèchement et d'après ce que nous savons cela a eu lieu hier soir.\n Mais il est impossible de savoir l'heure exacte.\n Nous avons trouver son corps au niveau du pont de Camon", false, false));
		dialogues.add(new Dialogues( 19, "Je suis désolé je ne sais pas. Vous devriez demander au commissaire.", false, false ));
		dialogues.add(new Dialogues( 20, "Je ne vois pas de quoi vous parlez.", false, false ));
		dialogues.add(new Dialogues( 21, "Elle étais très gentille\nElle est partie en congé il y a une semaine environ.", false, false ));
		dialogues.add(new Dialogues( 22, "Je ne comprends pas...", false, false ));
		dialogues.add(new Dialogues( 23, "Alors c'est comme ça...\n\n" +
				"Sonia éteint la lumiere de la salle\n" +
				"et lance une perle noire qui se transforme en Ombrage.\n" +
				"La creature s'approche de vous...", false, false ));
		dialogues.add(new Dialogues( 24, "Le commissaire Corvo n'a pas une très bonne memoire.", false, false ));
		dialogues.add(new Dialogues( 25, "Ne t'enfuis pas !!\n\n" +
				"Vous vous mettez hors de danger\n\n" +
				"Andrew : Je dois trouver une source de lumiere.\n" +
				"Peut être que je trouverais chez Monique.", true, false ));
		dialogues.add(new Dialogues( 26, "Comment ça ?\n\n" +
				"Vous utilisez votre lampe torche afin de vaincre le monstre\n" +
				"Une fois le monstre transfomé en perle vous laissez la lumière dessus.\n" +
				"Ainsi il ne vous embêtera plus.", false, false ));
		dialogues.add(new Dialogues( 27, "Merci, passez une bonne journée.", true, false ));
		dialogues.add(new Dialogues( 28, "Ma créature !\n\n" +
				"À ce moment la, le commissaire entre.\n" +
				"Il comprend vite la situation et arrête Sonia Rousselle.\n" +
				"Vous en profitez pour mettre la perle en sécurité\n" +
				"là ou elle sera toujours soumise à la lumière.\n" +
				"Plus tard vous fouillez dans l'appartement de Sonia Rousselle.\n" +
				"Vous trouver le grimoire magique qui a invoquer la créature\n" +
				"ainsi que les affaires personnelles de l'assistante disparue.\n" +
				"Le commissaire vous remercie de votre aide.\n", true, true));

		//Commissaire 2
		dialogues.add(new Dialogues( 29, "As-tu toutes les infos dont tu as besoin ? ", false, false ));
		dialogues.add(new Dialogues( 30, "A propos de quoi ?", false, false ));
		dialogues.add(new Dialogues( 31, "Parfait !", true, false ));
		dialogues.add(new Dialogues( 32, "Une dame aurais vue la scène de crime.\n" +
				"Elle se trouve a \"Chez Monique, pas de panique\".", false, false ));
		dialogues.add(new Dialogues( 33, "Tout ce que je sais, c'est que la victime vivait avec ses parents au centre ville.\n" +
				"Va voir son père au restaurant \"Bol de la loutre\"\n" +
				"pour lui poser quelques questions.", false, false ));
		//Monique
		dialogues.add(new Dialogues(34, "...\n[Elle vous regarde d\'un oeil apeuré.]", false, false));
		dialogues.add(new Dialogues(35, "...\n[Monique panique]", true, false));
		dialogues.add(new Dialogues(36, "...\n[Monique hoche la tête pour dire oui]", false, false));
		dialogues.add(new Dialogues(37, "...\n[Elle montre du doigt des sachets de thé]", false, false));
		dialogues.add(new Dialogues(38, "...\n[Elle ne réagis pas]", false, false));
		dialogues.add(new Dialogues(39, "...\n[Elle vous regarde d'un oeil intrigué]\nElle ne dit rien par politesse.", false, false));
		dialogues.add(new Dialogues(40, "...\n[Monique vous remercie d'un hochement de tête] \nElle semble plus detendue", false, false));
		dialogues.add(new Dialogues(41, "Je... Je vais répondre à vos questions.", false, false));
		dialogues.add(new Dialogues(42, "Un incendie c'est declaré à cause de mon poêle,\nJ\'ai été assez vive pour l'éteindre avant que les dégâts ne soient trop importants.\n[Elle a l'air un peu plus stressé qu'au debut de la conversation]", false, false));
		dialogues.add(new Dialogues(43, "Je faisais une promenade nocturne, lorsque près du pont,\n" +
				"je vis le petit François et Yve Rinal s'enfuir en courant,\n" +
				"poursuivis par une espèce de monstre de fumée avec une odeur épouvantable\n" +
				"Je ne sais pas d'où il sortait ...\n" +
				"Le ... Le monstre s'est attaqué à François ...\n" +
				"Je n'ai rien pu faire ... Yve lui a réussi à s'enfuir ...", false, false));
		dialogues.add(new Dialogues(44, "J\'ai croisé  deux personnes ce soir-là, le pauvre Francois\n" +
				"et Yve Rinnal.", false, false));
		dialogues.add(new Dialogues(45, "Au revoir monsieur ... Dites moi quand le monstre a disparu", true, false));
		dialogues.add(new Dialogues(46, "Oui, mais pourquoi en avez vous besoin", false, false));
		dialogues.add(new Dialogues(47, "Elle est a coté de la caisse ..."+"[Monique vous répond à contre coeur]", false, false));
		dialogues.add(new Dialogues(48, "Je vous fais confiance, prenez ma lampe\n" +
				"Elle est a coté de la caisse", false, false));
		//Carine Presus
		dialogues.add(new Dialogues(49, "...\n[elle vous regarde sans rien dire les yeux rougis par le chargin]", false, false));
		dialogues.add(new Dialogues(50, "Je comprend, je m\'appelle Carine.\nQue voulez vous savoir ?", false, false));
		dialogues.add(new Dialogues(51, "Que voulez vous savoir ?", false, false));
		dialogues.add(new Dialogues(52, "C'est Yve Rinal, notre ancien maire.\nIls étaient très proches tout les deux.\nIl passe souvent au resaurant familial, il y est peut-être.", false, false));
		dialogues.add(new Dialogues(53, "Il est... était plutot reservé, mais il offrait vonlontier son aide,\nC'est un ange partis trop tot.\n[elle se met a sanglotter]", false, false));
		dialogues.add(new Dialogues(54, "Il n\'avait pas beaucoup d\'amis,\nMais il semblait heureux comme ça.", false, false));
		dialogues.add(new Dialogues(55, "Je ne pense pas que quiquonque lui voulait du mal\n" +	"C'etait vraiment un ange.", false, false));
		dialogues.add(new Dialogues(56, "Merci, bonne journée ", true, false));
		dialogues.add(new Dialogues(57, "Avez vous d'autres questions ?", false, false));
		//Pere victime
		dialogues.add(new Dialogues(58, "Bonjour, que puis-je vous servir", false, false));
		dialogues.add(new Dialogues(59, "Parfait un café pour monsieur\n" +
				"Avec ça ?", false, false));
		dialogues.add(new Dialogues(60, "Que voulez vous savoir ?\n"+"[Son regard devient triste]\n"
				, false, false));
		dialogues.add(new Dialogues(61, "Oui ... c\'est mon fils ...\n"+"[C\'est avec les yeux embués de larme qu'il vous répond.]\n"
				, false, false));
		dialogues.add(new Dialogues(62, "C'est gentil ... mais ... mais ça va pas le ramener\n" +
				"Posez moi vos questions ...", false, false));
		dialogues.add(new Dialogues(63, "Je vais répondre à toutes vos questions\n" +
				"Promettez moi que vous trouverez le coupable", false, false));
		dialogues.add(new Dialogues(64, "Oui, il nous aidait souvent, c\'était un brave garcon\n" +
				"Je ne comprends pas qui aurait pu lui vouloir du mal", false, false));
		dialogues.add(new Dialogues(65, "Ma femme est restée a la maison\n" +
				"Elle a besoin de repos, mais je ne peux pas fermer le restaurant ...\n" +
				"Nous habitons au 6 rue Jean Moulin.", false, false));
		dialogues.add(new Dialogues(66, "Retrouvez le type qui a fait ça ...", true, false));
		dialogues.add(new Dialogues(67, "Vous avez des question ?", false, false));

		//Ancien Maire
		dialogues.add(new Dialogues(68, "...\n[Vous allez voir l'unique client du restaurant.]", false, false));
		dialogues.add(new Dialogues(69, "Laissez moi tranquille…", true, false));
		dialogues.add(new Dialogues(70, "Laissez moi tranquille...\n" +
				"C\'est moi, et alors ?", false, false));
		dialogues.add(new Dialogues(71, "Vous m\'arretez ? Non ? Alors laissez moi tranquille…\n\n" +
				"Andrew : C'est bizarre il avait des lunettes sur la photo et il n'en porte pas", true, false));
		dialogues.add(new Dialogues(72, "En effet, ou les avez vous trouvés ?\n" +
				"[il semble enervé]", false, false));
		dialogues.add(new Dialogues(73, "Bien ...\n" +
				"Posez les vos questions", false, false));
		dialogues.add(new Dialogues(74, "Quoi ? Mais je n\'ai rien fait ...\n\n" +
				"Sûr de vous vous appellez le commissaire afin qu'il arrete Yve Rinnal\n" +
				"Yve vous jure que ce n'est pas lui, mais vous l'ignorez.\n" +
				"Une fois au commissariat, le commissaire le met derriere les barreaux \n" +
				"Dans la nuit, le monstre attaque et tue non seulement Yve\n" +
				"mais aussi le commissaire. \n" +
				"Yve etait innocent.\n\n",true,true));

		dialogues.add(new Dialogues(75, "Il m\'aidait de temps en temps, rien de plus.\n[Il semble stressé]", false, false));
		dialogues.add(new Dialogues(76, "Je... travaillais\n[Il semble stressé]", false, false));
		dialogues.add(new Dialogues(77, "Je ne sais pas... j\'ai du les faires tomber \n[Il semble stressé]", false, false));
		dialogues.add(new Dialogues(78, "Bien, je vais tout vous raconter\n" +
				"Il y a 20 ans, vous êtes venus chercher un grimoire.\n" +
				"Je ne pense pas que vous vous souvenez de moi,\n" +
				"J'étais maire à l'époque.\n" +
				"Suite à votre passage, j'ai décidé de moi aussi rechercher des grimoires dans le but de vous aider\n" +
				"J'ai ouvert un bar-tabac, de la, je pouvais entendre les ragots\n" +
				"François venait de temps en temps, et au fur et à mesure nous sommes devenus amis\n" +
				"Il a fini par découvrir que je cherchais des grimoires\n" +
				"Suite a ça nous sommes devenus partenaires\n" +
				"Depuis la disparition de l\\'assistante de la médecin légiste\n" +
				"nous savions que quelque chose se tramait.\n" +
				"La médecin légiste était très bizarre recemment\n" +
				"Hier nous étions en train de l'espionner\n" +
				"quand nous nous sommes fait attaquer par un monstre de fumée.\n" +
				"Le monstre a tué François ...", false, false));
		dialogues.add(new Dialogues(79, "J\' espère avoir pu vous être utile. Bonne chance.\n\n" +
				"Andrew : Je devrais avoir assés d'informations pour trouver quel est la creature\n" +
				"dans mes grimoires.", true, false));
		//Sonia Rousselle
		dialogues.add(new Dialogues(80, "Tu es revenus finalement !\n" +
				"Tu ne peut pas te proteger de ma creature !\n" +
				"Dommage pour toi !", false, false));


		//Instance Réponses
		//Commissaire 1
		reponses.add(new Reponses(0, "En effet !", "En effet !"));
		reponses.add(new Reponses(1, "Et toi oui, malheureusement.", "Et toi oui, malheureusement."));
		reponses.add(new Reponses(2, "C\'est normal, dans mon bureau je ne viellis pas.", "C\'est normal, dans mon bureau je ne viellis pas."));
		reponses.add(new Reponses(3, "Je passais dans le coin...", "Je passais dans le coin..."));
		reponses.add(new Reponses(4, "Mmm...", "Mmm..."));
		reponses.add(new Reponses(5, "Le meurte !", "Je suis venu à cause du meurtre."));
		reponses.add(new Reponses(6, "Je ne peux rien te cacher.", "Je ne peux rien te cacher."));
		reponses.add(new Reponses(7, "Que se passe t\'il ?", "Que se passe t\'il ?"));
		reponses.add(new Reponses(8, "Je veux bien t\'aider.", "Je veux bien t\'aider."));
		reponses.add(new Reponses(9, "Mes grimores peuvent détruire le monde.", "Mes grimores peuvent détruire le monde,\nEt tu veux que je soigne un problème de digestion?\nVa voir un medecin plutôt."));
		reponses.add(new Reponses(10,"Bon, d\'accord. Mais juste pour cette fois.", "Bon, d\'accord. Mais juste pour cette fois."));
		reponses.add(new Reponses(11,"Des gens sont en danger.", "Des gens sont en danger,\nTon mal de ventre n'est pas une priorité\nLes gens de cette ville on si peut d'importance pour toi ?"));
		reponses.add(new Reponses(12,"J\'accepte.", "Je te deteste ...\nJ\'accepte."));
		reponses.add(new Reponses(13,"Je refuse !", "Je refuse !"));
		reponses.add(new Reponses(14,"Suite",""));
		reponses.add(new Reponses(15,"Non.", "Non."));
		reponses.add(new Reponses(16,"Oui.", "Oui.Je te donnes la recette.\n\n" +
				"Vous écrivez le nom des plantes sur un morceau de papier."));
		reponses.add(new Reponses(17,"Merci commissaire !", "Merci commissaire !"));

		//Medecin Legiste
		reponses.add(new Reponses( 18, "En effet.","En effet. Je suis Andrew Benett,\nravis de vous rencontrer."));
		reponses.add(new Reponses( 19, "Comment le savez vous ?","Comment le savez vous ?"));
		reponses.add(new Reponses( 20, "Pouvez vous me reparler de la victime ?","Pouvez vous me reparler de la victime ?"));
		reponses.add(new Reponses( 21, "Vous savez où logeait la victime ?","Vous savez où logeait la victime ?"));
		reponses.add(new Reponses( 22, "Je vous remercie.","Je vous remercie. J'espere que votre assistante va bien."));
		reponses.add(new Reponses( 23, "Je sais que c'est vous !","Je sais que c'est vous !"));
		reponses.add(new Reponses( 24, "Pouvez vous me parler de votre assistante ?","Le commissaire m'a parler de votre assistante, pouvez vous m'en dire plus ?"));
		reponses.add(new Reponses( 25, "Je m'excuse.","Je m'excuse je ne voulais pas dire ça."));
		reponses.add(new Reponses( 26, "Vous avez tuer votre assistante.","Vous avez tuer votre assistante\n" +
				"et quand Yve est François vous ont espionner vous les avec attaquer\n" +
				"en utilisant le monstre cree grace au sacrifice de votre assistante.\n" +
				"Mais Yve a reussis a s'enfuir et m'a raconter ce qu'il c'est passé."));
		reponses.add(new Reponses( 27, "Mais le commissaire.","Mais le commissaire m'a dit qu'elle avait disparue il y a un mois."));
		reponses.add(new Reponses( 28, "[Fuir en utilisant la porte].","...\n\n Vous fuyez en invoquant votre porte"));
		reponses.add(new Reponses( 29, "[Utiliser la lampe]","Je suis pret !"));
		reponses.add(new Reponses( 30, "Je suis le maitre des portes.","Je suis le maitre des portes.\nÀ quoi pensiez vous !"));
		reponses.add(new Reponses( 31, "Vous allez finir votre vie derrière les barreaux.","Vous allez finir votre vie derrière les barreaux."));
		reponses.add(new Reponses( 32, "Suite",""));

		//Commissaire 2
		reponses.add(new Reponses( 33, "Plus d\'informations ?","As-tu plus d\'informations à me communiquer sur l'affaire ?"));
		reponses.add(new Reponses( 34, "J\'ai tout","J\'ai tout"));
		reponses.add(new Reponses( 35, "Des témoins ?","Y a t'il des témoins ?"));
		reponses.add(new Reponses( 36, "La victime ?","Que peux-tu me dire sur la victime ?"));
		reponses.add(new Reponses( 37, "Merci.","Merci."));

		//Monique
		reponses.add(new Reponses(38, "Puis-je vous parler ?", "Bonjour madame, Puis-je vous parler ?"));
		reponses.add(new Reponses(39, "J\'ai des questions concernant le meurtre.", "Bonjour madame, J\'ai des questions concernant le meurtre."));
		reponses.add(new Reponses(40, "Suite", ""));
		reponses.add(new Reponses(41, "Voulez vous boire quelque chose ?", "Voulez vous boire quelque chose ?"));
		reponses.add(new Reponses(42, "Concernant ce qu\'il c'est passé hier soir...", "Concernant ce qu\'il c'est passé hier soir..."));
		reponses.add(new Reponses(43, "Je vais vous faire un thé.", "Je vais vous faire un thé."));
		reponses.add(new Reponses(44, "Je vais vous faire du café.", "Je vais vous faire du café."));
		reponses.add(new Reponses(45, "Servir tout de suite.", "Servir tout de suite."));
		reponses.add(new Reponses(46, "Attendre un peu.", "Attendre un peu."));
		reponses.add(new Reponses(47, "Je vais avoir besoin de votre aide.", "Je vais avoir besoin de votre aide."));
		reponses.add(new Reponses(48, "Pourquoi le mur est-il brûlé ?", "Pourquoi le mur est-il brûlé ?"));
		reponses.add(new Reponses(49, "Que s\'est il passé ?", "Que s\'est il passé hier soir ?"));
		reponses.add(new Reponses(50, "Avez vous vu quelqu\'un ?", "Avez vous vu quelqu\'un ?"));
		reponses.add(new Reponses(51, "Je dois y aller.", "Je dois y aller."));
		reponses.add(new Reponses(52, "Avez vous une lampe torche puissante ?", "Avez vous une lampe torche puissante ?"));
		reponses.add(new Reponses(53, "Pour le bien de l\'enquête.", "Pour le bien de l\'enquête."));
		reponses.add(new Reponses(54, "Pour vaincre le monstre de fumée.", "Pour vaincre le monstre de fumée."));
		reponses.add(new Reponses(55, "Suite", ""));
		//Player - Mere victime
		reponses.add(new Reponses(56, "Bonjour je suis Andrew Benett", "Bonjour je sus Andrew Benett\n" +"J\'aide le commissaire par rapport au meutre de votre fils\n" +"Avez vous des informations ?"));
		reponses.add(new Reponses(57, "Des information sur le fils ?", "Des information sur le fils ?"));
		reponses.add(new Reponses(58, "Je dois y aller.", "Je dois y aller."));
		reponses.add(new Reponses(59, "Qui est avec votre fils sur la photo ?", "Qui est avec votre fils sur la photo ?"));
		reponses.add(new Reponses(60, "Personalité ?", "Comment etait votre fils ?"));
		reponses.add(new Reponses(61, "Amis ?", "Votres fils avait-il des amis ?"));
		reponses.add(new Reponses(62, "Ennemis ?", "Votre fils avait-il des ennemis ?"));
		reponses.add(new Reponses(63, "Suite", ""));
		//Player - Pere victime
		reponses.add(new Reponses(64, "J\'aimerais vous parler", "Je ne suis pas la pour commander.\n" +
				"Je travaille avec le commissaire, j\'aimerais vous parler."));
		reponses.add(new Reponses(65, "Je prendrais bien un café", "Je prendrais bien un café\n" +
				"S\'il vous plaît."));
		reponses.add(new Reponses(66, "J\'aimerais vous posez quelques questions", "Je travaille avec le commissaire,j\'aimerais vous posez quelques questions."));
		reponses.add(new Reponses(67, "François presus est votre fils ?", "François presus est votre fils ?"));
		reponses.add(new Reponses(68, "Toutes mes condoléances.", "Toutes mes condoléances."));
		reponses.add(new Reponses(69, "J\'enquete sur la mort de votre fils.", "J\'enquete sur la mort de votre fils."));
		reponses.add(new Reponses(70, "Votre fils travaillait-il souvent ici ?", "Votre fils travaillait-il souvent ici ?"));
		reponses.add(new Reponses(71, "Votre femme n'est pas là ?", "Votre femme n'est pas là ?"));
		reponses.add(new Reponses(72, "Je dois y aller.", "Je dois y aller."));
		reponses.add(new Reponses(73, "Suite", ""));
		//Player - Ancien Maire
		reponses.add(new Reponses(74, "Bonjour", "Bonjour,  j\'aurais quelqu..."));
		reponses.add(new Reponses(75, "C\'est bien vous sur cette photo.", "C\'est bien vous sur cette photo."));
		reponses.add(new Reponses(76, "J\'aurais des questions s'il vous plait.", "J\'aurais des questions s\'il vous plaît."));
		reponses.add(new Reponses(77, "Ces lunettes vous appartiennent ?", "Ces lunettes vous appartiennent ?"));
		reponses.add(new Reponses(78, "J\'ai des questions à vous poser.", "J\'ai des questions à vous poser."));
		reponses.add(new Reponses(79, "Je sais que c'est vous !", "Je sais que c'est vous le meurtier\n" +
				"de françois presus !"));
		reponses.add(new Reponses(80, "Quelles étaient vos relations avec François Presus ?", "Quelles étaient vos relations avec François Presus ?"));
		reponses.add(new Reponses(81, "Que faisiez vous le soir du meurtre ?", "Que faisiez vous le soir du meurtre ?"));
		reponses.add(new Reponses(82, "Lunettes sur scène de crime ?", "Pourquoi avons nous trouvé vos lunettes\n" +
				"non loin de la scène de crime ?"));
		reponses.add(new Reponses(83, "Vous mentez...", "Vous mentez et je n'aime pas ça\n" +
				"J\'ai assez de preuve pour vous mettre sous les barreaux.\n" +
				"Alors dites moi toute la verité."));
		reponses.add(new Reponses(84, "Je dois y aller.", "Je dois y aller."));
		reponses.add(new Reponses(85, "Pouvez vous repeter ?", "Pouvez vous repeter ?"));
		reponses.add(new Reponses(86, "Suite", ""));
		reponses.add(new Reponses(87, "Suite", ""));
		//Sonia Rousselle
		reponses.add(new Reponses(88, "Suite", ""));






		//Instance Personnages
		personnages.add(new Personnages(0, "Guy Corvo", "âge : 56 ans \nProfession : Commissaire", dialogues.get(0)));
		personnages.add(new Personnages( 1, "Sonia Rousselle", "âge : 35 ans\n" +"Profession :  Médecin légiste\n" +"Détail : Possède un collier avec une perle noire.\n", dialogues.get(14) ));
		personnages.add(new Personnages( 2, "François Presus", "âge : 26 ans\n" +"profession : Travaillait au “Bol de la Loutre”\n", null ));
		personnages.add(new Personnages(3, "Monique Cordier", "âge : 64\n" + "profession : Proprietaire de \"Chez monique, pas de panique\"", dialogues.get(34)));
		personnages.add(new Personnages(4, "Damien Presus", "âges : 56 ans\n" +"profession : Propriétaires du restaurant \"Bol de la Loutre\"\n", dialogues.get(58)));
		personnages.add(new Personnages(5, "Carine Presus", "âges : 53 ans\n" +"profession : Co-Propriétaires du restaurant \"Bol de la Loutre\"\n", dialogues.get(49)));
		personnages.add(new Personnages(6, "Yve Rinal", "âge : 54\n" +
				"profession : Tenant du bar-tabac \"L’echoppe\", ancien maire.\n", dialogues.get(68)));
		personnages.add(new Personnages(7, "Client", "C'est un client du Bol de la Loutren", dialogues.get(68)));

		//Instance Player
		this.player = new Joueur(lieux.get(0));

		//Ajout d'objets dans les lieux
		lieux.get(0).addObj(objets.get(0));
		lieux.get(0).addObj(objets.get(5));
		lieux.get(3).addObj(objets.get(6));
		lieux.get(4).addObj(objets.get(1));
		lieux.get(4).addObj(objets.get(4));
		lieux.get(6).addObj(objets.get(2));

		//Modification pour les objets non trouvables
		objets.get(0).CantBeFound();
		objets.get(5).CantBeFound();
		objets.get(6).CantBeFound();

		//Dialogues qui libere des lieux
		dialogues.get(12).addLieu(lieux.get(2));
		dialogues.get(15).addLieu(lieux.get(4));
		dialogues.get(16).addLieu(lieux.get(4));
		dialogues.get(32).addLieu(lieux.get(3));
		dialogues.get(33).addLieu(lieux.get(5));
		dialogues.get(65).addLieu(lieux.get(6));

		//Lien entre les dialogues et les objets qu'ils debloquent
		dialogues.get(9).addObjet(objets.get(0));
		dialogues.get(47).addObjet(objets.get(6));
		dialogues.get(48).addObjet(objets.get(6));
		dialogues.get(79).addObjet(objets.get(5));

		//Ajouts de prerequis pour certaines reponses
		reponses.get(16).addObjet(objets.get(0));
		reponses.get(23).addObjet(objets.get(5));
		reponses.get(29).addObjet(objets.get(6));
		reponses.get(52).addObjet(objets.get(5));
		reponses.get(59).addObjet(objets.get(2));
		reponses.get(75).addObjet(objets.get(2));
		reponses.get(77).addObjet(objets.get(1));


		//Lisaison des dialogues avec les reponses possible
		dialogues.get(0).addReponse(reponses.get(0));
		dialogues.get(1).addReponse(reponses.get(1));
		dialogues.get(1).addReponse(reponses.get(2));
		dialogues.get(2).addReponse(reponses.get(3));
		dialogues.get(2).addReponse(reponses.get(4));
		dialogues.get(2).addReponse(reponses.get(5));
		dialogues.get(3).addReponse(reponses.get(3));
		dialogues.get(3).addReponse(reponses.get(4));
		dialogues.get(3).addReponse(reponses.get(5));
		dialogues.get(4).addReponse(reponses.get(6));
		dialogues.get(5).addReponse(reponses.get(7));
		dialogues.get(6).addReponse(reponses.get(8));
		dialogues.get(6).addReponse(reponses.get(9));
		dialogues.get(7).addReponse(reponses.get(10));
		dialogues.get(7).addReponse(reponses.get(11));
		dialogues.get(8).addReponse(reponses.get(12));
		dialogues.get(8).addReponse(reponses.get(13));
		dialogues.get(9).addReponse(reponses.get(14));
		//Dialogue 10
		dialogues.get(11).addReponse(reponses.get(15));
		dialogues.get(11).addReponse(reponses.get(16));
		dialogues.get(12).addReponse(reponses.get(17));
		dialogues.get(13).addReponse(reponses.get(14));
		dialogues.get(14).addReponse(reponses.get(18));
		dialogues.get(14).addReponse(reponses.get(19));
		dialogues.get(15).addReponse(reponses.get(20));
		dialogues.get(15).addReponse(reponses.get(21));
		dialogues.get(15).addReponse(reponses.get(22));
		dialogues.get(16).addReponse(reponses.get(20));
		dialogues.get(16).addReponse(reponses.get(21));
		dialogues.get(16).addReponse(reponses.get(22));
		dialogues.get(17).addReponse(reponses.get(20));
		dialogues.get(17).addReponse(reponses.get(21));
		dialogues.get(17).addReponse(reponses.get(24));
		dialogues.get(17).addReponse(reponses.get(22));
		dialogues.get(17).addReponse(reponses.get(23));
		dialogues.get(18).addReponse(reponses.get(32));
		dialogues.get(19).addReponse(reponses.get(32));
		dialogues.get(20).addReponse(reponses.get(25));
		dialogues.get(20).addReponse(reponses.get(26));
		dialogues.get(21).addReponse(reponses.get(27));
		dialogues.get(22).addReponse(reponses.get(32));
		dialogues.get(23).addReponse(reponses.get(28));
		dialogues.get(23).addReponse(reponses.get(29));
		dialogues.get(24).addReponse(reponses.get(32));
		dialogues.get(25).addReponse(reponses.get(88));
		dialogues.get(26).addReponse(reponses.get(30));
		dialogues.get(26).addReponse(reponses.get(31));
		dialogues.get(27).addReponse(reponses.get(32));
		//Commissaire 2
		dialogues.get(29).addReponse(reponses.get(33));
		dialogues.get(29).addReponse(reponses.get(34));
		dialogues.get(30).addReponse(reponses.get(35));
		dialogues.get(30).addReponse(reponses.get(36));
		dialogues.get(31).addReponse(reponses.get(37));
		dialogues.get(32).addReponse(reponses.get(37));
		dialogues.get(33).addReponse(reponses.get(37));
		//Monique
		dialogues.get(34).addReponse(reponses.get(38));
		dialogues.get(34).addReponse(reponses.get(39));
		dialogues.get(35).addReponse(reponses.get(40));
		dialogues.get(36).addReponse(reponses.get(41));
		dialogues.get(36).addReponse(reponses.get(42));
		dialogues.get(37).addReponse(reponses.get(43));
		dialogues.get(37).addReponse(reponses.get(44));
		dialogues.get(38).addReponse(reponses.get(45));
		dialogues.get(38).addReponse(reponses.get(46));
		dialogues.get(39).addReponse(reponses.get(45));
		dialogues.get(39).addReponse(reponses.get(46));
		dialogues.get(40).addReponse(reponses.get(47));
		dialogues.get(41).addReponse(reponses.get(48));
		dialogues.get(41).addReponse(reponses.get(49));
		dialogues.get(41).addReponse(reponses.get(50));
		dialogues.get(41).addReponse(reponses.get(51));
		dialogues.get(41).addReponse(reponses.get(52));
		dialogues.get(42).addReponse(reponses.get(55));
		dialogues.get(43).addReponse(reponses.get(55));
		dialogues.get(44).addReponse(reponses.get(55));
		dialogues.get(45).addReponse(reponses.get(55));
		dialogues.get(46).addReponse(reponses.get(53));
		dialogues.get(46).addReponse(reponses.get(54));
		dialogues.get(47).addReponse(reponses.get(55));
		dialogues.get(48).addReponse(reponses.get(55));
		//Liason Player - Mere Victime
		dialogues.get(49).addReponse(reponses.get(56));
		dialogues.get(50).addReponse(reponses.get(57));
		dialogues.get(50).addReponse(reponses.get(58));
		dialogues.get(50).addReponse(reponses.get(59));
		dialogues.get(51).addReponse(reponses.get(60));
		dialogues.get(51).addReponse(reponses.get(61));
		dialogues.get(51).addReponse(reponses.get(62));
		dialogues.get(52).addReponse(reponses.get(63));
		dialogues.get(53).addReponse(reponses.get(63));
		dialogues.get(54).addReponse(reponses.get(63));
		dialogues.get(55).addReponse(reponses.get(63));
		dialogues.get(56).addReponse(reponses.get(63));
		dialogues.get(57).addReponse(reponses.get(57));
		dialogues.get(57).addReponse(reponses.get(58));
		dialogues.get(57).addReponse(reponses.get(59));
		//Liason Player - Pere Victime
		dialogues.get(58).addReponse(reponses.get(64));
		dialogues.get(58).addReponse(reponses.get(65));
		dialogues.get(59).addReponse(reponses.get(66));
		dialogues.get(60).addReponse(reponses.get(67));
		dialogues.get(61).addReponse(reponses.get(68));
		dialogues.get(61).addReponse(reponses.get(69));
		dialogues.get(62).addReponse(reponses.get(70));
		dialogues.get(62).addReponse(reponses.get(71));
		dialogues.get(62).addReponse(reponses.get(72));
		dialogues.get(63).addReponse(reponses.get(70));
		dialogues.get(63).addReponse(reponses.get(71));
		dialogues.get(63).addReponse(reponses.get(72));
		dialogues.get(64).addReponse(reponses.get(73));
		dialogues.get(65).addReponse(reponses.get(73));
		dialogues.get(66).addReponse(reponses.get(73));
		dialogues.get(67).addReponse(reponses.get(70));
		dialogues.get(67).addReponse(reponses.get(71));
		dialogues.get(67).addReponse(reponses.get(72));
		//Liason Player - Ancien Maire
		dialogues.get(68).addReponse(reponses.get(74));
		dialogues.get(68).addReponse(reponses.get(75));
		dialogues.get(69).addReponse(reponses.get(87));
		dialogues.get(70).addReponse(reponses.get(76));
		dialogues.get(70).addReponse(reponses.get(77));
		dialogues.get(71).addReponse(reponses.get(87));
		dialogues.get(72).addReponse(reponses.get(78));
		dialogues.get(72).addReponse(reponses.get(79));
		dialogues.get(73).addReponse(reponses.get(80));
		dialogues.get(73).addReponse(reponses.get(81));
		dialogues.get(73).addReponse(reponses.get(82));
		dialogues.get(75).addReponse(reponses.get(83));
		dialogues.get(76).addReponse(reponses.get(83));
		dialogues.get(77).addReponse(reponses.get(83));
		dialogues.get(78).addReponse(reponses.get(84));
		dialogues.get(78).addReponse(reponses.get(85));
		dialogues.get(79).addReponse(reponses.get(86));
		//Sonia rousselle
		dialogues.get(80).addReponse(reponses.get(28));
		dialogues.get(80).addReponse(reponses.get(29));





		//Liaison des reponses avec les dialogues correspondants
		reponses.get(0).changeDialogue(dialogues.get(1));
		reponses.get(1).changeDialogue(dialogues.get(2));
		reponses.get(2).changeDialogue(dialogues.get(3));
		reponses.get(3).changeDialogue(dialogues.get(4));
		reponses.get(4).changeDialogue(dialogues.get(4));
		reponses.get(5).changeDialogue(dialogues.get(5));
		reponses.get(6).changeDialogue(dialogues.get(5));
		reponses.get(7).changeDialogue(dialogues.get(6));
		reponses.get(8).changeDialogue(dialogues.get(9));
		reponses.get(9).changeDialogue(dialogues.get(7));
		reponses.get(10).changeDialogue(dialogues.get(9));
		reponses.get(11).changeDialogue(dialogues.get(8));
		reponses.get(12).changeDialogue(dialogues.get(9));
		reponses.get(13).changeDialogue(dialogues.get(10));
		reponses.get(14).changeDialogue((dialogues.get(11)));
		reponses.get(15).changeDialogue((dialogues.get(13)));
		reponses.get(16).changeDialogue((dialogues.get(12)));
		reponses.get(17).changeDialogue((dialogues.get(29)));
		reponses.get(18).changeDialogue((dialogues.get(15)));
		reponses.get(19).changeDialogue((dialogues.get(16)));
		reponses.get(20).changeDialogue((dialogues.get(18)));
		reponses.get(21).changeDialogue((dialogues.get(19)));
		reponses.get(22).changeDialogue((dialogues.get(27)));
		reponses.get(23).changeDialogue((dialogues.get(20)));
		reponses.get(24).changeDialogue((dialogues.get(21)));
		reponses.get(25).changeDialogue((dialogues.get(22)));
		reponses.get(26).changeDialogue((dialogues.get(23)));
		reponses.get(27).changeDialogue((dialogues.get(24)));
		reponses.get(28).changeDialogue((dialogues.get(25)));
		reponses.get(29).changeDialogue((dialogues.get(26)));
		reponses.get(30).changeDialogue((dialogues.get(28)));
		reponses.get(31).changeDialogue((dialogues.get(28)));
		reponses.get(32).changeDialogue((dialogues.get(17)));
		//Commissaire 2
		reponses.get(33).changeDialogue((dialogues.get(30)));
		reponses.get(34).changeDialogue((dialogues.get(31)));
		reponses.get(35).changeDialogue((dialogues.get(32)));
		reponses.get(36).changeDialogue((dialogues.get(33)));
		reponses.get(37).changeDialogue((dialogues.get(29)));
		//Monique
		reponses.get(38).changeDialogue((dialogues.get(36)));
		reponses.get(39).changeDialogue((dialogues.get(35)));
		reponses.get(40).changeDialogue((dialogues.get(34)));
		reponses.get(41).changeDialogue((dialogues.get(37)));
		reponses.get(42).changeDialogue((dialogues.get(35)));
		reponses.get(43).changeDialogue((dialogues.get(38)));
		reponses.get(44).changeDialogue((dialogues.get(39)));
		reponses.get(45).changeDialogue((dialogues.get(35)));
		reponses.get(46).changeDialogue((dialogues.get(40)));
		reponses.get(47).changeDialogue((dialogues.get(41)));
		reponses.get(48).changeDialogue((dialogues.get(42)));
		reponses.get(49).changeDialogue((dialogues.get(43)));
		reponses.get(50).changeDialogue((dialogues.get(44)));
		reponses.get(51).changeDialogue((dialogues.get(45)));
		reponses.get(52).changeDialogue((dialogues.get(46)));
		reponses.get(53).changeDialogue((dialogues.get(47)));
		reponses.get(54).changeDialogue((dialogues.get(48)));
		reponses.get(55).changeDialogue((dialogues.get(41)));
		//Liason Player - Mere Victime
		reponses.get(56).changeDialogue(dialogues.get(50));
		reponses.get(57).changeDialogue(dialogues.get(51));
		reponses.get(58).changeDialogue(dialogues.get(56));
		reponses.get(59).changeDialogue(dialogues.get(52));
		reponses.get(60).changeDialogue(dialogues.get(53));
		reponses.get(61).changeDialogue(dialogues.get(54));
		reponses.get(62).changeDialogue(dialogues.get(55));
		reponses.get(63).changeDialogue(dialogues.get(57));
		//Liason Player - Pere Victime
		reponses.get(64).changeDialogue(dialogues.get(60));
		reponses.get(65).changeDialogue(dialogues.get(59));
		reponses.get(66).changeDialogue(dialogues.get(60));
		reponses.get(67).changeDialogue(dialogues.get(61));
		reponses.get(68).changeDialogue(dialogues.get(62));
		reponses.get(69).changeDialogue(dialogues.get(63));
		reponses.get(70).changeDialogue(dialogues.get(64));
		reponses.get(71).changeDialogue(dialogues.get(65));
		reponses.get(72).changeDialogue(dialogues.get(66));
		reponses.get(73).changeDialogue(dialogues.get(67));
		//Liason Player - Ancien Maire
		reponses.get(74).changeDialogue(dialogues.get(69));
		reponses.get(75).changeDialogue(dialogues.get(70));
		reponses.get(76).changeDialogue(dialogues.get(71));
		reponses.get(77).changeDialogue(dialogues.get(72));
		reponses.get(78).changeDialogue(dialogues.get(73));
		reponses.get(79).changeDialogue(dialogues.get(74));
		reponses.get(80).changeDialogue(dialogues.get(75));
		reponses.get(81).changeDialogue(dialogues.get(76));
		reponses.get(82).changeDialogue(dialogues.get(77));
		reponses.get(83).changeDialogue(dialogues.get(78));
		reponses.get(84).changeDialogue(dialogues.get(79));
		reponses.get(85).changeDialogue(dialogues.get(78));
		reponses.get(86).changeDialogue(dialogues.get(78));
		reponses.get(87).changeDialogue(dialogues.get(68));
		reponses.get(88).changeDialogue(dialogues.get(80));



		//Ajout des personnages aux lieux
		lieux.get(1).addPerso(personnages.get(0));
		lieux.get(2).addPerso(personnages.get(1));
		lieux.get(3).addPerso(personnages.get(3));
		lieux.get(5).addPerso(personnages.get(4));
		lieux.get(6).addPerso(personnages.get(5));
		lieux.get(5).addPerso(personnages.get(7));

		//lieux.get(2).addPerso(personnages.get(2));

		//Ajout des lieux de base du joueur
		player.addLieuEnt(lieux.get(0));
		player.addLieuEnt(lieux.get(1));
		player.addLieuVisit(lieux.get(0));
		player.addLieuVisit(lieux.get(1));

		System.out.println("**** Les aventures de mr.Benett ****\n\n");

		//Affichages des infos de base
		System.out.println("Vous incarnez Andrew Benett, un homme à l'allure tout à fait normale. Sauf que vous avez un rôle, vous êtes le gardien de la Porte.\n" +
				"Vous possédez le pouvoir de créer une porte n\'importe où et n\'importe quand,\n" +
				"Cette porte vous mènera à votre bureau qui est une salle plongée hors du temps et de l\'espace,\n" +
				"de cette salle, vous pouvez apparaître n\'importe où à partir du moment que vous avez déjà visité cet endroit.\n" +
				"Votre quête est de regrouper tous les ouvrages magiques afin d\'éviter qu\'ils ne tombent pas entre de mauvaises mains désirant semer le chaos.\n");
		System.out.println("-Appuyez sur entrer");
		sc.nextLine();
		System.out.println("Vous voilà dans votre bureau.\n" +
				"Vous êtes confortablement installé sur votre canapé en cuir en train de lire votre journal,\n" +
				"face à vous, votre bureau où trône une machine à écrire.\n" +
				"Tout autour de vous, des bibliothèques où sont conservé une multitude d'ouvrages, de grimoires, et de livre en tout genre parfaitement conservé grâce à vous,\n" +
				"Andrew Benett, et de vos prédécesseurs.\n" +
				"À votre gauche, au mur, une horloge à la vitre brisée bloqué à 1 h 17, la trotteuse avançant et reculant d'une seconde sans cesse,\n" +
				"comme si le temps lui-même était cassé.\n");
		System.out.println("-Appuyez sur entrer");
		sc.nextLine();
		System.out.println("Lors de votre enquête journalière, vous entendez parler d\'une mort très mystérieuse dans la ville de Bois-Sur-Suif.\n" +
				"En effet il est écrit dans le journal que la personne est morte a la suite d\'une attaque d'une bête inconnue.\n" +
				"Par chance, vous êtes déjà passé par cette ville il y a quelques années pour récupérer un grimoire magique\n" +
				"et vous avez sympathisé avec le commissaire local Guy Corvo qui connais votre secret.\n");
		System.out.println("-Appuyez sur entrer");
		sc.nextLine();

		System.out.println("Que souhaitez-vous faire ?\n");
		System.out.println("-Appuyez sur entrer");
		sc.nextLine();

	}


	public void jeu() {
		boolean b = Boolean.TRUE;
		do{
			b=actionsJoueur();
		}while (b);
	}

	public void finJeu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("***\t Fin Du Jeu \t***\n");
		sc.nextLine();
		System.out.println("***\t Credit \t***\n");
		System.out.println("---Programmation\n"+
				"\tGuillaume\tPierre\n" +
				"\tValdrin\t\tSalihi\n"+
				"\tValentin\tLescorbie\n");

		System.out.println("---Creation de l'histoire\n" +
				"\tValentin\tLescorbie\n");

		System.out.println("---Remerciement speciaux\n"+
				"\tRonan\t\tPluta\n");
		sc.nextLine();
		System.out.println("***\t Merci D'avoir joué \t***\n");
		dialogues.clear();
		reponses.clear();
		lieux.clear();
		personnages.clear();
		objets.clear();
		player = null;
		System.out.println("-Appuyez sur entrer");

		sc.nextLine();

		menu();
	}

}