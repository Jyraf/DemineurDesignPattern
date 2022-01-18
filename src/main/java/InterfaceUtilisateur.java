import java.util.Scanner;

public class InterfaceUtilisateur {
    
    private Scanner scanner;
    private Terrain terrain;
    private Plateau plateau;
    private int casesLibresRestantes;

    public InterfaceUtilisateur(Plateau plateau) {
        this.scanner = new Scanner(System.in);
        this.terrain = new Terrain(plateau);
        this.plateau = plateau;
        this.casesLibresRestantes= plateau.line * plateau.column;
    }

    public void menu(){
        System.out.println("-------MENU-------");
        System.out.println("Veuillez taper 1 pour jouer ou 2 pour accéder au options");
        System.out.println("1-JOUER");
        System.out.println("2-OPTIONS");
        Scanner scannerMenu = new Scanner(System.in);
        int choixMenu = scannerMenu.nextInt();
        if(choixMenu == 1){
            start();
        }
        if(choixMenu == 2){
            options();
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
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            Plateau plateau = director.makeGrandPlateau();
            InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
            System.err.println("Changement effectué !");
            iu.menu();
        }
        if(choixGrandeur == 2){
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            Plateau plateau = director.makeMoyenPlateau();
            InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
            System.err.println("Changement effectué !");
            iu.menu();
        }
        if(choixGrandeur == 3){
            Builder plateauBuilder = new PlateauBuilder();
            Director director = new Director(plateauBuilder);
            Plateau plateau = director.makePetitPlateau();
            InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau);
            System.err.println("Changement effectué !");
            iu.menu();
        }
        else{
            System.out.println("Entrée invalide, veuillez séléctionner une réponse valide");
            optionGrandeur();

        }

    }

    public void start() {

        terrain.genererTerrain();
        System.out.print("Combien de mines voulez-vous sur le terrain ? : ");
        int nbMines = scanner.nextInt();
        terrain.genererMines(nbMines);
        casesLibresRestantes -= nbMines;
        while (true) {
            terrain.afficherTerrain();
            System.out.println("Jouez votre coup (mode -> 0 = découvrir la case, 1 = mettre/enlever un drapeau, puis les coordonnées x (colonne) et y (ligne)) : ");
            try {
                int mode = scanner.nextInt();
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (mode == 0) {
                   int resultat = terrain.ouvrirCase(x-1,y-1);
                   if (resultat == 1) {
                       casesLibresRestantes--;
                       if (casesLibresRestantes == 0) {
                            terrain.afficherTerrain();
                            System.out.println("Félicitations, vous avez gagné la partie !");
                            break;
                       }
                   } else if (resultat == -1) {
                        terrain.afficherTerrain();
                        System.out.println("Félicitations, vous avez perdu !");
                        break;
                   }
                } else if (mode == 1) {
                    if (!terrain.estOuverte(x-1,y-1)) {
                        terrain.mettreDrapeau(x-1,y-1);
                    }
                }
                
            } catch (Exception e) {
                System.out.println("Entrée invalide, veuillez jouez un coup valide");
            }    
        }
    }
}
