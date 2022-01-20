public class Jeu {

    private SimCases[][] cases;
    private SimDifficultes difficultes;
    private Plateau plateau;
    private int nbMines;
    private int nbMinesRestantes;


    public Jeu(Plateau plateauJeu, SimDifficultes difficultes) {
        cases = new SimCases[plateauJeu.column][plateauJeu.line];
        plateau = plateauJeu;
        this.difficultes = difficultes;
        nbMines = difficultes.nbBomb();
        nbMinesRestantes = difficultes.nbBomb();
    }

    public void genererJeu() {
        for (int y = 0; y < cases.length; y++) {
            for (int x = 0; x < cases.length; x++) {
                cases[y][x] = new SimCases(x, y,"0", false);
            }
        }
        genererMines();
        genererNumero();
    }

    public void genererMines() {
        int nbMinesVoulu = nbMines;
        while (nbMinesVoulu > 0) {
            int x = (int) Math.floor(Math.random() * plateau.line);
            int y = (int) Math.floor(Math.random() * plateau.column);

            if (!cases[x][y].isBomb()) {
                cases[x][y].setBomb(true);
                nbMinesVoulu--;
            }
        }
    }

    public void genererNumero() {
        for (int i = 0; i < plateau.line; i++) {
            for (int j = 0; j < plateau.column; j++) {
                SimCases caseCourante = cases[j][i];
                if (caseCourante.isBomb()) {
                    caseCourante.setValue("b");
                    continue;
                }
                int numTemp = 0;
                boolean aGauche = (i - 1) >= 0;
                boolean aDroite = (i + 1) < plateau.line;
                boolean aHaut = (j - 1) >= 0;
                boolean aBas = (j + 1) < plateau.column;

                if (aHaut) {
                    SimCases haut = cases[j - 1][i];
                    if (haut.isBomb()) {
                        numTemp++;
                    }
                    if (aGauche) {
                        SimCases hautGauche = cases[j - 1][i - 1];
                        if (hautGauche.isBomb()) {
                            numTemp++;
                        }
                    }
                    if (aDroite) {
                        SimCases hautDroite = cases[j - 1][i + 1];
                        if (hautDroite.isBomb()) {
                            numTemp++;
                        }
                    }
                }
                if (aBas) {
                    SimCases bas = cases[j + 1][i];
                    if (bas.isBomb()) {
                        numTemp++;
                    }
                    if (aGauche) {
                        SimCases basGauche = cases[j + 1][i - 1];
                        if (basGauche.isBomb()) {
                            numTemp++;
                        }
                    }
                    if (aDroite) {
                        SimCases basDroite = cases[j + 1][i + 1];
                        if (basDroite.isBomb()) {
                            numTemp++;
                        }
                    }
                }
                if (aGauche) {
                    SimCases gauche = cases[j][i - 1];
                    if (gauche.isBomb()) {
                        numTemp++;
                    }
                }
                if (aDroite) {
                    SimCases droite = cases[j][i + 1];
                    if (droite.isBomb()) {
                        numTemp++;
                    }
                }
                caseCourante.setValue(String.valueOf(numTemp));

            }
        }
    }

    public void afficherJeu() {
        System.out.println();
        System.out.print("\033[1;33m" + "X");
        for (int i = 0; i < plateau.line; i++) {
            System.out.print("│" + (i + 1));
        }
        System.out.print("│");
        System.out.println();
        String[] lettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        for (int y = 0; y < cases.length; y++) {
            System.out.print("\033[1;33m" + lettres[y] + "│");
            for (int x = 0; x < cases.length; x++) {
                System.out.print("\033[1;35m" + cases[y][x].afficherStatus() + "\033[1;33m" + "│");
            }

            System.out.println();
        }
    }

    public void afficherJeuTerminer(){
        for (SimCases[] aCase : cases) {
            for (int x = 0; x < cases.length; x++) {
                aCase[x].ouvrirCases();
            }
        }
        afficherJeu();
//        System.out.println();
//        System.out.print("\033[1;33m" + "X");
//        for (int i = 0; i < plateau.line; i++) {
//            System.out.print("│" + (i + 1));
//        }
//        System.out.print("│");
//        System.out.println();
//        String[] lettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
//        for (int y = 0; y < cases.length; y++) {
//            System.out.print("\033[1;33m" + lettres[y] + "│");
//            for (int x = 0; x < cases.length; x++) {
//                System.out.print("\033[1;35m" + cases[y][x].getValue() + "\033[1;33m" + "│");
//            }
//
//            System.out.println();
//        }
    }


    public SimCases[][] getCases() {
        return cases;
    }



}
