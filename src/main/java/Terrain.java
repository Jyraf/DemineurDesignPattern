import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Terrain {
    private List<Point> mines;
    private Point[][] cases;


    public Terrain() {
        mines = new ArrayList<>();
        cases = new Point[9][9];
    }

    public void genererTerrain() {
        for(int y = 0; y < cases.length; y++) {
            for(int x = 0; x < cases.length; x++) {
                cases[y][x] = new Point(x,y);
            }
        }
    }

    public void genererMines(int nbMinesDemandees) {
        Random random = new Random();
        int nbMinesActuelles = 0;
        while (true) {
            //générer des coordonnées pour les mines
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            //vérifie si les coordonnées sont déjà celles d'une mine
            if (cases[y][x] instanceof Mine) {
                continue;
            }
            //place une mine aux coordonnées générées
            Mine mine = new Mine(x,y);
            cases[y][x] = mine;
            mines.add(mine);
            //augmente le nombre de mines
            nbMinesActuelles++;
            //vérifie s'il y a suffisamment de mines sur le terrain
            if (nbMinesActuelles == nbMinesDemandees) {
                break;
            }
        }

        for(int y = 0; y < cases.length; y++) {
            for(int x = 0; x < cases.length; x++) {
                if (!(cases[y][x] instanceof Mine)) {
                    int nbMines = 0;
                    for(Point m : mines) {
                        if (cases[y][x].estVoisineDe(m)) {
                            nbMines++;
                        }
                    }
                    cases[y][x].setNbMinesAutour(nbMines);
                }
            }
        }
    }

    public boolean estOuverte(int x, int y) {
        return cases[y][x].estOuverte();
    }

    public void mettreDrapeau(int x, int y) {
        cases[y][x].mettreDrapeau();
    }

    public int ouvrirCase(int x, int y) {
        if (!cases[y][x].estOuverte() && !cases[y][x].estDrapeau()) {
            return cases[y][x].ouvrir();
        } else {
            return 0;
        }
        
    }

    public void afficherTerrain() {
        System.out.println();
        System.out.println( " │123456789│");
        System.out.println( "-│---------│");
        for (int y = 0; y < cases.length; y++) {
            System.out.print(y+1 + "|");
            for (int x = 0; x < cases.length; x++) {
                System.out.print(cases[y][x]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println( "-│---------│");
    }
}