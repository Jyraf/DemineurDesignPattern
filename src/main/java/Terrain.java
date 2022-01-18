import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Terrain {
    private List<Point> mines;
    private Point[][] cases;
    private Plateau plateau;


    public Terrain(Plateau plateauJeu) {
        mines = new ArrayList<>();
        cases = new Point[plateauJeu.column][plateauJeu.line];
        plateau = plateauJeu;
    }

    public void genererTerrain() {
        for (int y = 0; y < cases.length; y++) {
            for (int x = 0; x < cases.length; x++) {
                cases[y][x] = new Point(x, y);
            }
        }
    }

    public void genererMines(int nbMinesDemandees) {
        Random random = new Random();
        int nbMinesActuelles = 0;
        while (true) {
            //générer des coordonnées pour les mines
            int x = random.nextInt(plateau.line);
            int y = random.nextInt(plateau.column);
            //vérifie si les coordonnées sont déjà celles d'une mine
            if (cases[y][x] instanceof Mine) {
                continue;
            }
            //place une mine aux coordonnées générées
            Mine mine = new Mine(x, y);
            cases[y][x] = mine;
            mines.add(mine);
            //augmente le nombre de mines
            nbMinesActuelles++;
            //vérifie s'il y a suffisamment de mines sur le terrain
            if (nbMinesActuelles == nbMinesDemandees) {
                break;
            }
        }

        for (Point[] aCase : cases) {
            for (int x = 0; x < cases.length; x++) {
                if (!(aCase[x] instanceof Mine)) {
                    int nbMines = 0;
                    for (Point m : mines) {
                        if (aCase[x].estVoisineDe(m)) {
                            nbMines++;
                        }
                    }
                    aCase[x].setNbMinesAutour(nbMines);
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
        System.out.print("X");
        for (int i = 0; i < plateau.line; i++) {
            System.out.print("│" + (i + 1));
        }
        System.out.print("│");
        System.out.println();
        for (int y = 0; y < cases.length; y++) {
            System.out.print(y + 1 + "│");
            for (int x = 0; x < cases.length; x++) {
                System.out.print(cases[y][x] + "│");
            }

            System.out.println();
        }
    }
}