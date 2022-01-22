import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InterfaceUtilisateur {
    //Déclaration des variable
    private Jeu jeu;
    private Plateau plateau;
    private int casesLibresRestantes;
    private SimDifficultes difficultes;
    private String couleur = "blanc";

    //Constructeur
    public InterfaceUtilisateur(Plateau plateau, SimDifficultes difficultes, String couleur) {
        this.jeu = new Jeu(plateau, difficultes, couleur);
        this.plateau = plateau;
        this.casesLibresRestantes = plateau.line * plateau.column - 5;
        this.difficultes = difficultes;
    }

    //Affichage du menu
    public void menu() {
        System.out.println("-------MENU-------");
        System.out.println("Veuillez taper 1 pour jouer ou 2 pour accéder au options");
        System.out.println("1-JOUER");
        System.out.println("2-OPTIONS");
        System.out.println("3-QUITTER");
        Scanner scannerMenu = new Scanner(System.in);
        //Gestion des choix du menu
        int choixMenu = scannerMenu.nextInt();
        if (choixMenu == 1) {
            start();
        }
        if (choixMenu == 2) {
            options();
        }
        if (choixMenu == 3) {
            System.exit(0);
        } else {
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            menu();
        }

    }

    //Affiche des options
    public void options() {
        System.out.println("-------OPTIONS-------");
        System.out.println("Veuillez Sélectionner l'option souhaiter : ");
        System.out.println("1-Grandeur du Plateau");
        System.out.println("2-Difficultée");
        System.out.println("3-Couleur");
        //Gestion des choix des options
        Scanner scannerOption = new Scanner(System.in);
        int choixOption = scannerOption.nextInt();
        if (choixOption == 1) {
            optionGrandeur();
        }
        if (choixOption == 2) {
            optionDifficultee();
        }
        if (choixOption == 3) {
            optionCouleur();
        } else {
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            options();
        }
    }

    //Affichage des Options de grandeur
    public void optionGrandeur() {
        System.out.println("-----OPTIONS GRANDEUR-------");
        System.out.println("Veuillez séléctionner la taille du plateau souhaité");
        System.out.println("1-Grand");
        System.out.println("2-Moyen");
        System.out.println("3-Petit");
        //Gestion des choix des option de grandeur
        Scanner scannerGrandeur = new Scanner(System.in);
        int choixGrandeur = scannerGrandeur.nextInt();
        if (choixGrandeur == 1) {
            System.err.println("Changement effectué !");
            //création d'un nouveau plateau a l'aide du builder
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            plateau = director.makeGrandPlateau();
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixGrandeur == 2) {
            System.err.println("Changement effectué !");
            //création d'un nouveau plateau a l'aide du builder
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            plateau = director.makeMoyenPlateau();
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixGrandeur == 3) {
            System.err.println("Changement effectué !");
            //création d'un nouveau plateau a l'aide du builder
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            plateau = director.makePetitPlateau();
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        } else {
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            optionGrandeur();

        }

    }

    //Affichage des Options de difficultés
    public void optionDifficultee() {
        System.out.println("-----OPTIONS DIFFICULTÉS-------");
        System.out.println("Veuillez séléctionner la difficultée souhaitée");
        System.out.println("1-Facile");
        System.out.println("2-Normal");
        System.out.println("3-Difficile");
        //Gestion des choix des option de difficultés
        Scanner scannerDifficultes = new Scanner(System.in);
        int choixDifficultes = scannerDifficultes.nextInt();
        if (choixDifficultes == 1) {
            System.err.println("Changement effectué !");
            //changement de la difficulté grace au State
            difficultes.facile();
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixDifficultes == 2) {
            System.err.println("Changement effectué !");
            //changement de la difficulté grace au State
            difficultes.normal();
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixDifficultes == 3) {
            System.err.println("Changement effectué !");
            //changement de la difficulté grace au State
            difficultes.difficile();
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        } else {
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            optionDifficultee();

        }

    }
    //Affichage des options pour les couleurs
    public void optionCouleur() {
        System.out.println("-----OPTIONS COULEURS-------");
        System.out.println("Veuillez séléctionner la couleur de case souhaitée");
        System.out.println("1-" + "\u001B[30m" + "Noir" + "\u001B[0m");
        System.out.println("2-" + "\u001B[31m" + "Rouge" + "\u001B[0m");
        System.out.println("3-" + "\u001B[32m" + "Vert" + "\u001B[0m");
        System.out.println("4-" + "\u001B[33m" + "Jaune" + "\u001B[0m");
        System.out.println("5-" + "\u001B[34m" + "Bleu" + "\u001B[0m");
        System.out.println("6-" + "\u001B[35m" + "Violet" + "\u001B[0m");
        System.out.println("7-" + "\u001B[36m" + "Cyan" + "\u001B[0m");
        System.out.println("8-" + "\u001B[37m" + "Gris" + "\u001B[0m");
        //Gestion des choix des option de couleur
        Scanner scannerCouleur = new Scanner(System.in);
        int choixCouleur = scannerCouleur.nextInt();
        if (choixCouleur == 1) {
            System.err.println("Changement effectué !");
            couleur = "noir";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixCouleur == 2) {
            System.err.println("Changement effectué !");
            couleur = "rouge";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixCouleur == 3) {
            System.err.println("Changement effectué !");
            couleur = "vert";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixCouleur == 4) {
            System.err.println("Changement effectué !");
            couleur = "jaune";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixCouleur == 5) {
            System.err.println("Changement effectué !");
            couleur = "bleu";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixCouleur == 6) {
            System.err.println("Changement effectué !");
            couleur = "violet";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixCouleur == 7) {
            System.err.println("Changement effectué !");
            couleur = "cyan";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if (choixCouleur == 8) {
            System.err.println("Changement effectué !");
            couleur = "blanc";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        } else {
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            optionDifficultee();

        }

    }

    //Affichage du jeu
    public void start() {
        jeu.genererJeu();
        //récupération des cases du jeu
        CasesDecorator[][] cases = jeu.getCases();
        List<String> lettres = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
        boolean finJeu = false;
        //tant que le jeu n'est pas fini
        while (!finJeu) {
            //on affiche le jeu
            jeu.afficherJeu();
            //on demande les coordonnée de la case souhaité
            System.out.println("Veuillez écrire les coordonnées de la case souhaité (ex : A1 ou C5) Si vous voulez poser un drapeau, ajouter un 'F' a la fin (ex: A1F ou C5F)");
            try {
                //gestion du choix de l'utilisateur
                Scanner scannerJeu = new Scanner(System.in);
                String action = scannerJeu.next().toUpperCase();
                //split de la chaine pour recuperer les valeur que l'on veut
                String[] actionSplit = action.split("");
                //récupération de la case voulu grace au instruction de l'utilisateur
                CasesDecorator caseCourante = cases[lettres.indexOf(actionSplit[0])][Integer.parseInt(actionSplit[1]) - 1];
                //si le mot taper est de 3 lettre (il y a donc sois une erreur sois un F pour flag
                if (actionSplit.length == 3) {
                    //si le dernier caractere est un f alors
                    if (actionSplit[2].equals("F")) {
                        //si la case courante n'est pas encore decouverte
                        if (caseCourante.getStatus().equals("?")) {
                            //on utilise le state des cases pour la changer en une case Drapeau
                            caseCourante.flagCases();
                        }
                    }
                }
                //Si il y a 2 caractere
                if (actionSplit.length == 2) {
                    //on test si la case est une case caché ou une case drapeau
                    if (caseCourante.getStatus().equals("?") || caseCourante.getStatus().equals("f")) {
                        //si oui on ouvre la case grace au Status Cases
                        caseCourante.ouvrirCases();
                        //si la case courante est une bombe,
                        if (caseCourante.isBomb()) {
                            //C'est perdu, on arrete le jeu et on demande si l'utilisateur veut rejouer
                            System.err.println("BOOM ! Dommage, vous avez perdu !");
                            jeu.afficherJeuTerminer();
                            finJeu = true;
                            //sinon,
                        } else {
                            //on retire une case libre au cases libres restante
                            casesLibresRestantes--;
                        }
                    }
                }
                //Si il n'y a plus de case libre restante,
                if (casesLibresRestantes == 0) {
                    //c'est gagner, on arrete le jeu et on demande si l'utilisateur veut rejouer
                    System.err.println("Félicitation ! vous avez gagner !");
                    jeu.afficherJeuTerminer();
                    finJeu = true;
                }
                //si ya aucune correspondance avec ces cas las on emet une erreur pour que l'utilisateur puisse retenter d'ecrire la case voulu
            } catch (Exception e) {
                System.err.println("Entrée invalide, veuillez utiliser le format souhaité");
            }

        }
        //apres que le jeu sois finis, on remet le menu pour rejouer ou acceder au options
        System.out.println("Jeux terminer ! Veuillez choisir une Options: ");
        System.out.println("1-REJOUER");
        System.out.println("2-OPTIONS");
        System.out.println("3-QUITTER");
        Scanner scannerMenu = new Scanner(System.in);
        //gestion des choix du menu
        int choixMenu = scannerMenu.nextInt();
        if (choixMenu == 1) {
            start();
        }
        if (choixMenu == 2) {
            options();
        }
        if (choixMenu == 3) {
            System.exit(0);
        } else {
            System.err.println("Entrée invalide, veuillez séléctionner une réponse valide");
            menu();
        }
    }

}
