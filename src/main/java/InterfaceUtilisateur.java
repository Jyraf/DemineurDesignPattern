import java.util.Scanner;

public class InterfaceUtilisateur {
    
    private Scanner scanner;
    private Terrain terrain;
    private int casesLibresRestantes = 9 * 9;

    public InterfaceUtilisateur() {
        this.scanner = new Scanner(System.in);
        this.terrain = new Terrain();
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
