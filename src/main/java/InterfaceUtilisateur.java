import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InterfaceUtilisateur {

    private Jeu jeu;
    private Plateau plateau;
    private int casesLibresRestantes;
    private SimDifficultes difficultes;
    private String couleur = "blanc" ;

    public InterfaceUtilisateur(Plateau plateau, SimDifficultes difficultes, String couleur) {
        this.jeu = new Jeu(plateau, difficultes, couleur);
        this.plateau = plateau;
        this.casesLibresRestantes= plateau.line * plateau.column - 5;
        this.difficultes = difficultes;
    }

    public void menu(){
        System.out.println("-------MENU-------");
        System.out.println("Veuillez taper 1 pour jouer ou 2 pour accéder au options");
        System.out.println("1-JOUER");
        System.out.println("2-OPTIONS");
        System.out.println("3-QUITTER");
        Scanner scannerMenu = new Scanner(System.in);
        int choixMenu = scannerMenu.nextInt();
        if(choixMenu == 1){
            start();
        }
        if(choixMenu == 2){
            options();
        }
        if(choixMenu == 3){
            System.exit(0);
        }
        else{
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            menu();
        }

    }

    public void options(){
        System.out.println("-------OPTIONS-------");
        System.out.println("Veuillez Sélectionner l'option souhaiter : ");
        System.out.println("1-Grandeur du Plateau");
        System.out.println("2-Difficultée");
        System.out.println("3-Couleur");
        Scanner scannerOption = new Scanner(System.in);
        int choixOption = scannerOption.nextInt();
        if(choixOption == 1){
            optionGrandeur();
        }
        if(choixOption == 2){
            optionDifficultee();
        }
        if(choixOption == 3){
            optionCouleur();
        }
        else{
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            options();
        }
    }

    public void optionGrandeur(){
        System.out.println("-----OPTIONS GRANDEUR-------");
        System.out.println("Veuillez séléctionner la taille du plateau souhaité");
        System.out.println("1-Grand");
        System.out.println("2-Moyen");
        System.out.println("3-Petit");
        Scanner scannerGrandeur = new Scanner(System.in);
        int choixGrandeur = scannerGrandeur.nextInt();
        if(choixGrandeur == 1){
            System.err.println("Changement effectué !");
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            plateau = director.makeGrandPlateau();
            this.jeu = new Jeu(plateau, difficultes,couleur);
            this.menu();
        }
        if(choixGrandeur == 2){
            System.err.println("Changement effectué !");
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            plateau = director.makeMoyenPlateau();
            this.jeu = new Jeu(plateau, difficultes,couleur);
            this.menu();
        }
        if(choixGrandeur == 3){
            System.err.println("Changement effectué !");
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            plateau = director.makePetitPlateau();
            this.jeu = new Jeu(plateau, difficultes,couleur);
            this.menu();
        }
        else{
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            optionGrandeur();

        }

    }

    public void optionDifficultee(){
        System.out.println("-----OPTIONS DIFFICULTÉS-------");
        System.out.println("Veuillez séléctionner la difficultée souhaitée");
        System.out.println("1-Facile");
        System.out.println("2-Normal");
        System.out.println("3-Difficile");
        Scanner scannerDifficultes = new Scanner(System.in);
        int choixDifficultes = scannerDifficultes.nextInt();
        if(choixDifficultes == 1){
            System.err.println("Changement effectué !");
            difficultes.facile();
            this.jeu = new Jeu(plateau, difficultes,couleur);
            this.menu();
        }
        if(choixDifficultes == 2){
            System.err.println("Changement effectué !");
            difficultes.normal();
            this.jeu = new Jeu(plateau, difficultes,couleur);
            this.menu();
        }
        if(choixDifficultes == 3){
            System.err.println("Changement effectué !");
            difficultes.difficile();
            this.jeu = new Jeu(plateau, difficultes,couleur);
            this.menu();
        }
        else{
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            optionDifficultee();

        }

    }

    public void optionCouleur(){
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
        Scanner scannerCouleur = new Scanner(System.in);
        int choixCouleur = scannerCouleur.nextInt();
        if(choixCouleur == 1){
            System.err.println("Changement effectué !");
            couleur = "noir";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if(choixCouleur == 2){
            System.err.println("Changement effectué !");
            couleur = "rouge";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if(choixCouleur == 3){
            System.err.println("Changement effectué !");
            couleur = "vert";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if(choixCouleur == 4){
            System.err.println("Changement effectué !");
            couleur = "jaune";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if(choixCouleur == 5){
            System.err.println("Changement effectué !");
            couleur = "bleu";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if(choixCouleur == 6){
            System.err.println("Changement effectué !");
            couleur = "violet";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if(choixCouleur == 7){
            System.err.println("Changement effectué !");
            couleur = "cyan";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }
        if(choixCouleur == 8){
            System.err.println("Changement effectué !");
            couleur = "blanc";
            this.jeu = new Jeu(plateau, difficultes, couleur);
            this.menu();
        }

        else{
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            optionDifficultee();

        }

    }

    public void start(){
        jeu.genererJeu();
        CasesDecorator[][] cases = jeu.getCases();
        List<String> lettres = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
        boolean finJeu = false;
        while(!finJeu){
            jeu.afficherJeu();
            System.out.println("Veuillez écrire les coordonnées de la case souhaité (ex : A1 ou C5) Si vous voulez poser un drapeau, ajouter un 'F' a la fin (ex: A1F ou C5F)");
            try {
                Scanner scannerJeu = new Scanner(System.in);
                String action = scannerJeu.next().toUpperCase();
                String[] actionSplit = action.split("");
                CasesDecorator caseCourante = cases[lettres.indexOf(actionSplit[0])][Integer.parseInt(actionSplit[1])-1];
                if (actionSplit.length == 3){
                    if(actionSplit[2].equals("F")) {
                        if (caseCourante.getStatus().equals("?")) {
                            caseCourante.flagCases();
                        }
                    }
                }
                if (actionSplit.length == 2) {

                    if (caseCourante.getStatus().equals("?") || caseCourante.getStatus().equals("f")) {
                        caseCourante.ouvrirCases();
                        if (caseCourante.isBomb()) {
                            System.err.println("BOOM ! Dommage, vous avez perdu !");
                            jeu.afficherJeuTerminer();
                            finJeu = true;
                        }
                        else{
                            casesLibresRestantes--;
                        }
                    }
                }

                if(casesLibresRestantes == 0){
                    System.err.println("Félicitation ! vous avez gagner !");
                    jeu.afficherJeuTerminer();
                    finJeu = true;
                }
            }
            catch(Exception e){
                System.err.println("Entrée invalide, veuillez utiliser le format souhaité");
            }

        }
        System.out.println("Jeux terminer ! Veuillez choisir une Options: ");
        System.out.println("1-REJOUER");
        System.out.println("2-OPTIONS");
        System.out.println("3-QUITTER");
        Scanner scannerMenu = new Scanner(System.in);
        int choixMenu = scannerMenu.nextInt();
        if(choixMenu == 1){
            start();
        }
        if(choixMenu == 2){
            options();
        }
        if(choixMenu == 3){
            System.exit(0);
        }
        else{
            System.err.println("Entrée invalide, veuillez séléctionner une réponse valide");
            menu();
        }
    }

//    public void start() {
//
//        terrain.genererTerrain();
//        System.out.print("Combien de mines voulez-vous sur le terrain ? : ");
//        int nbMines = scanner.nextInt();
//        terrain.genererMines(nbMines);
//        casesLibresRestantes -= nbMines;
//        while (true) {
//            terrain.afficherTerrain();
//            System.out.println("Jouez votre coup (mode -> 0 = découvrir la case, 1 = mettre/enlever un drapeau, puis les coordonnées x (colonne) et y (ligne)) : ");
//            try {
//                int mode = scanner.nextInt();
//                int x = scanner.nextInt();
//                int y = scanner.nextInt();
//
//                if (mode == 0) {
//                   int resultat = terrain.ouvrirCase(x-1,y-1);
//                   if (resultat == 1) {
//                       casesLibresRestantes--;
//                       if (casesLibresRestantes == 0) {
//                            terrain.afficherTerrain();
//                            System.out.println("Félicitations, vous avez gagné la partie !");
//                            break;
//                       }
//                   } else if (resultat == -1) {
//                        terrain.afficherTerrain();
//                        System.out.println("Félicitations, vous avez perdu !");
//                        break;
//                   }
//                } else if (mode == 1) {
//                    if (!terrain.estOuverte(x-1,y-1)) {
//                        terrain.mettreDrapeau(x-1,y-1);
//                    }
//                }
//
//            } catch (Exception e) {
//                System.out.println("Entrée invalide, veuillez jouez un coup valide");
//            }
//        }
//    }
}
