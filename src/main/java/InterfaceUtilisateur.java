import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InterfaceUtilisateur {

    //Déclaration des variables
    private Jeu jeu;
    private Plateau plateau;
    private int casesLibresRestantes;
    private Difficulte difficultes;
    private String couleur = "blanc";

    //Constructeur
    public InterfaceUtilisateur(Plateau plateau, Difficulte difficultes, String couleur) {
        this.jeu = new Jeu(plateau, difficultes, couleur);
        this.plateau = plateau;
        this.casesLibresRestantes = plateau.line * plateau.column - 5;
        this.difficultes = difficultes;
    }

    //Affichage du menu
    public void menu() {

        System.out.println("-------MENU-------");
        System.out.println("Veuillez taper 1 pour jouer ou 2 pour acceder aux differentes options");
        System.out.println("1- JOUER");
        System.out.println("2- OPTIONS");
        System.out.println("3- QUITTER");
        Scanner scannerMenu = new Scanner(System.in);

        //Verification que le scanner récupère un Int
        boolean incorrectInput = true;
        int choixMenu = 0;

        while (incorrectInput) {
            if (scannerMenu.hasNextInt()) {
                choixMenu = scannerMenu.nextInt();
                incorrectInput = false;
            } else {
                scannerMenu.next();
            }
        }
        //Gestion des choix du menu
        if (choixMenu == 1) {
            start();
        }
        if (choixMenu == 2) {
            options();
        }
        if (choixMenu == 3) {
            System.exit(0);
        } else {
            System.out.println("Entree invalide, veuillez selectionner une reponse valide");
            menu();
        }


    }

    //Affichage des options
    public void options() {
        System.out.println("-------OPTIONS-------");
        System.out.println("Veuillez Selectionner l'option souhaitee : ");
        System.out.println("1- Taille du Plateau");
        System.out.println("2- Difficulte");
        System.out.println("3- Couleur");

        //Gestion des choix des options
        Scanner scannerOption = new Scanner(System.in);
        boolean incorrectInput = true;
        int choixOption = 0;

        //Verification que le scanner récupère un Int
        while (incorrectInput) {
            if (scannerOption.hasNextInt()) {
                choixOption = scannerOption.nextInt();
                incorrectInput = false;
            } else {
                scannerOption.next();
            }
        }

        if (choixOption == 1) {
            optionGrandeur();
        }
        if (choixOption == 2) {
            optionDifficultee();
        }
        if (choixOption == 3) {
            optionCouleur();
        } else {
            System.out.println("Entree invalide, veuillez selectionner une reponse valide");
            options();
        }
    }

    //Affichage des Options de grandeur
    public void optionGrandeur() {
        System.out.println("-----OPTIONS GRANDEUR-------");
        System.out.println("Veuillez selectionner la taille du plateau souhaite");
        System.out.println("1-Grand");
        System.out.println("2-Moyen");
        System.out.println("3-Petit");

        //Gestion des choix des option de grandeur
        Scanner scannerGrandeur = new Scanner(System.in);


        boolean incorrectInput = true;
        int choixGrandeur = 0;

        //Verification que le scanner récupère un Int
        while (incorrectInput) {
            if (scannerGrandeur.hasNextInt()) {
                choixGrandeur = scannerGrandeur.nextInt();
                incorrectInput = false;
            } else {
                scannerGrandeur.next();
            }
        }


        //création d'un nouveau plateau a l'aide du builder
        Builder plateauBuilder = new PlateauBuilder();
        Director director = new Director(plateauBuilder);

        switch (choixGrandeur) {
            case 1:
                plateau = director.makeGrandPlateau();
                break;
            case 2:
                plateau = director.makeMoyenPlateau();
                break;
            case 3:
                plateau = director.makePetitPlateau();
                break;
            default:
                System.out.println("Entree invalide, veuillez selectionner une reponse valide");
                optionGrandeur();
                break;
        }
        System.err.println("Changement effectue !");
        this.jeu = new Jeu(plateau, difficultes, couleur);
        this.menu();

    }

    //Affichage des Options de difficultés
    public void optionDifficultee() {
        System.out.println("-----OPTIONS DIFFICULT\u00C9-------");
        System.out.println("Veuillez selectionner la difficulte souhaitee");
        System.out.println("1- Facile");
        System.out.println("2- Normal");
        System.out.println("3- Difficile");

        //Gestion des choix des option de difficulté
        Scanner scannerDifficultes = new Scanner(System.in);

        boolean incorrectInput = true;
        int choixDifficultes = 0;

        //Verification que le scanner récupère un Int
        while (incorrectInput) {
            if (scannerDifficultes.hasNextInt()) {
                choixDifficultes = scannerDifficultes.nextInt();
                incorrectInput = false;
            } else {
                scannerDifficultes.next();
            }
        }

        switch (choixDifficultes) {
            case 1:
                difficultes.facile();
                break;
            case 2:
                difficultes.normal();
                break;
            case 3:
                difficultes.difficile();
                break;
            default:
                System.out.println("Entree invalide, veuillez selectionner une reponse valide");
                optionDifficultee();
                break;
        }
        System.err.println("Changement effectue ! Le plateau contient desormais " + difficultes.nbBomb() + " bombes");
        this.jeu = new Jeu(plateau, difficultes, couleur);
        this.menu();
    }

    //Affichage des options pour les couleurs
    public void optionCouleur() {
        System.out.println("-----OPTIONS COULEUR-------");
        System.out.println("Veuillez selectionner la couleur de case souhaitee");
        System.out.println("(Cette option est purement esthetique, pour le plaisir de vos yeux)");
        System.out.println("1-" + "\u001B[30m" + "Noir" + "\u001B[0m");
        System.out.println("2-" + "\u001B[31m" + "Rouge" + "\u001B[0m");
        System.out.println("3-" + "\u001B[32m" + "Vert" + "\u001B[0m");
        System.out.println("4-" + "\u001B[33m" + "Jaune" + "\u001B[0m");
        System.out.println("5-" + "\u001B[34m" + "Bleu" + "\u001B[0m");
        System.out.println("6-" + "\u001B[35m" + "Violet" + "\u001B[0m");
        System.out.println("7-" + "\u001B[36m" + "Cyan" + "\u001B[0m");
        System.out.println("8-" + "\u001B[37m" + "Gris" + "\u001B[0m");

        //Gestion des choix des options de couleur
        Scanner scannerCouleur = new Scanner(System.in);

        boolean incorrectInput = true;
        int choixCouleur = 0;

        //Verification que le scanner récupère un Int
        while (incorrectInput) {
            if (scannerCouleur.hasNextInt()) {
                choixCouleur = scannerCouleur.nextInt();
                incorrectInput = false;
            } else {
                scannerCouleur.next();
            }
        }

        switch (choixCouleur) {
            case 1:
                couleur = "noir";
                break;
            case 2:
                couleur = "rouge";
                break;
            case 3:
                couleur = "vert";
                break;
            case 4:
                couleur = "jaune";
                break;
            case 5:
                couleur = "bleu";
                break;
            case 6:
                couleur = "violet";
                break;
            case 7:
                couleur = "cyan";
                break;
            case 8:
                couleur = "blanc";
                break;
            default:
                System.out.println("Entree invalide, veuillez selectionner une reponse valide");
                optionCouleur();
                break;
        }
        System.err.println("Changement effectue !");
        this.jeu = new Jeu(plateau, difficultes, couleur);
        this.menu();
    }

    //Affichage du jeu
    public void start() {
        jeu.genererJeu();
        //récupération des cases du jeu
        DecorateurCase[][] cases = jeu.getCases();
        List<String> lettres = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
        boolean finJeu = false;
        //tant que le jeu n'est pas fini
        while (!finJeu) {
            //on affiche le jeu
            jeu.afficherJeu();
            //on demande les coordonnées de la case souhaitée
            System.out.println("Veuillez ecrire les coordonnees de la case que vous souhaitez miner (ex : A1 ou C5)");
            System.out.println("Si vous pensez qu'une bombe se trouve sur une case, ajouter un 'F' a la fin pour afficher un Drapeau (ex: A1F ou C5F)");
            try {
                //gestion du choix de l'utilisateur
                Scanner scannerJeu = new Scanner(System.in);
                String action = scannerJeu.next().toUpperCase();

                //split de la chaine pour recuperer les valeurs que l'on veut
                String[] actionSplit = action.split("");

                //récupération de la case voulu grace au instruction de l'utilisateur
                DecorateurCase caseCourante = cases[lettres.indexOf(actionSplit[0])][Integer.parseInt(actionSplit[1]) - 1];

                //si le mot tapé est de 3 lettres (il y a donc soit une erreur soit un F pour flag
                if (actionSplit.length == 3) {
                    //si le dernier caractere est un f alors
                    if (actionSplit[2].equals("F")) {
                        //on utilise le state des cases pour la changer en une case Drapeau / cachée
                        caseCourante.drapeauCase();
                    } else {
                        System.err.println("Entrée invalide, veuillez utiliser le format souhaité");
                    }
                }
                //Si il y a 2 caractere
                if (actionSplit.length == 2) {
                    //si la case courante est une bombe,
                    if (caseCourante.isBomb()) {
                        //C'est perdu, on arrete le jeu et on demande si l'utilisateur veut rejouer
                        System.err.println("BOOM ! Dommage, vous avez perdu et explosé !");
                        jeu.afficherJeuTerminer();
                        finJeu = true;

                        //sinon, si la case n'a pas été ouverte précédemment :
                    } else if(caseCourante.getStatus().equals("?") || caseCourante.getStatus().equals("f")){
                        //on retire une case libre aux cases libres restantes
                        casesLibresRestantes--;
                    }
                    caseCourante.selectionnerCase();
                }
                //Si il n'y a plus de case libre restante,
                if (casesLibresRestantes == 0) {
                    //c'est gagne, on arrete le jeu et on demande si l'utilisateur veut rejouer
                    System.err.println("Felicitation ! Vous avez demine le terrain !");
                    jeu.afficherJeuTerminer();
                    finJeu = true;
                }
                //si ya aucune correspondance avec ces cas là on emet une erreur pour que l'utilisateur puisse retenter d'ecrire la case voulue
            } catch (Exception e) {
                System.err.println("Entree invalide, veuillez utiliser le format souhaite");
            }

        }
        //apres que le jeu soit fini, on remet le menu pour rejouer ou acceder aux options
        System.out.println("Partie terminee !");
        menu();
    }

}
