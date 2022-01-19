import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InterfaceUtilisateur {

    private Jeu jeu;
    private Plateau plateau;
    private int casesLibresRestantes;

    public InterfaceUtilisateur(Plateau plateau) {
        this.jeu = new Jeu(plateau);
        this.plateau = plateau;
        this.casesLibresRestantes= plateau.line * plateau.column - 5;
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
        Scanner scannerOption = new Scanner(System.in);
        int choixOption = scannerOption.nextInt();
        if(choixOption == 1){
            optionGrandeur();
        }
        else{
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            options();
        }
    }

    public void optionGrandeur(){
        System.out.println("-----OPTIONS GRANDEUR-------");
        System.out.println("Veuillez séléctionner la taille du plateau souhaiter");
        System.out.println("1-Grand");
        System.out.println("2-Moyen");
        System.out.println("3-Petit");
        Scanner scannerGrandeur = new Scanner(System.in);
        int choixGrandeur = scannerGrandeur.nextInt();
        if(choixGrandeur == 1){
            System.err.println("Changement effectué !");
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            Plateau plateau = director.makeGrandPlateau();
            InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
            iu.menu();
        }
        if(choixGrandeur == 2){
            System.err.println("Changement effectué !");
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            Plateau plateau = director.makeMoyenPlateau();
            InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
            iu.menu();
        }
        if(choixGrandeur == 3){
            System.err.println("Changement effectué !");
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            Plateau plateau = director.makePetitPlateau();
            InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
            iu.menu();
        }
        else{
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            optionGrandeur();

        }

    }

    public void start(){
        jeu.genererJeu();
        Cases[][] cases = jeu.getCases();
        List<String> lettres = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
        boolean finJeu = false;
        while(!finJeu){
            jeu.afficherJeu();
            System.out.println("Veuillez écrire les coordonnées de la case souhaité (ex : A1 ou C5) Si vous voulez poser un drapeau, ajouter un 'F' a la fin (ex: A1F ou C5F)");
            try {
                Scanner scannerJeu = new Scanner(System.in);
                String action = scannerJeu.next().toUpperCase();
                String[] actionSplit = action.split("");
                Cases caseCourante = cases[lettres.indexOf(actionSplit[0])][Integer.parseInt(actionSplit[1])-1];
                if (actionSplit.length == 3){
                    if(actionSplit[2].equals("F")) {
                        if (caseCourante.getState().equals("?")) {
                            caseCourante.setState("f");
                        }
                    }
                }
                if (actionSplit.length == 2) {
                    if (caseCourante.getState().equals("?") || caseCourante.getState().equals("f")) {
                        caseCourante.setState(caseCourante.getValue());
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
