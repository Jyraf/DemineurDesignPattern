public class Jeu {
    //déclaration des variable
    private CasesDecorator[][] cases;
    private SimDifficultes difficultes;
    private String couleur;
    private Plateau plateau;
    private int nbMines;
    private int nbMinesRestantes;

    //Contrcution du jeu
    public Jeu(Plateau plateauJeu, SimDifficultes difficultes, String couleur) {
        cases = new CasesDecorator[plateauJeu.column][plateauJeu.line];
        plateau = plateauJeu;
        this.difficultes = difficultes;
        nbMines = difficultes.nbBomb();
        nbMinesRestantes = difficultes.nbBomb();
        this.couleur = couleur;
    }

    //génération du jeu
    public void genererJeu() {
        //Pour chaque case
        for (int y = 0; y < cases.length; y++) {
            for (int x = 0; x < cases.length; x++) {
                //Selon la couleur choisi on instancie un nouveau Decorateur du concret builder des cases pour créé une case avec la couleur voulu
                switch(couleur) {
                    case "noir":
                        cases[y][x] = new CasesNoir(new SimCases(x, y, "0", false));
                        break;
                    case "rouge":
                        cases[y][x] = new CasesRouge(new SimCases(x, y, "0", false));
                        break;
                    case "vert":
                        cases[y][x] = new CasesVerte(new SimCases(x, y, "0", false));
                        break;
                    case "jaune":
                        cases[y][x] = new CasesJaune(new SimCases(x, y, "0", false));
                        break;
                    case "bleu":
                        cases[y][x] = new CasesBleu(new SimCases(x, y, "0", false));
                        break;
                    case "violet":
                        cases[y][x] = new CasesViolet(new SimCases(x, y, "0", false));
                        break;
                    case "cyan":
                        cases[y][x] = new CasesCyan(new SimCases(x, y, "0", false));
                        break;
                    case "blanc":
                        cases[y][x] = new CasesBlanche(new SimCases(x, y, "0", false));
                        break;
                }
            }
        }
        //on génére les mines
        genererMines();
        //on génére les numero des cases
        genererNumero();
    }

    public void genererMines() {
        //on recupere le nombre de mine décider grace a l'etat de la difficulté
        int nbMinesVoulu = nbMines;
        //tant qu'il y a encore des mines voulu
        while (nbMinesVoulu > 0) {
            //on prend deux coordonées au hasard sur le plateau
            int x = (int) Math.floor(Math.random() * plateau.line);
            int y = (int) Math.floor(Math.random() * plateau.column);

            //si cette case ne contient pas déjà une bombe,
            if (!cases[x][y].isBomb()) {
                //on dis que cette case est une bombe
                cases[x][y].setBomb(true);
                //on décrémente une bombe sur le total voulu
                nbMinesVoulu--;
            }
        }
    }

    public void genererNumero() {
        //pour chaque case du plateau
        for (int i = 0; i < plateau.line; i++) {
            for (int j = 0; j < plateau.column; j++) {
                //on récupère la case courante
                CasesDecorator caseCourante = cases[j][i];
                //si la case est une bombe, on défini sa valeur par "b" puis on passe a la case suivante
                if (caseCourante.isBomb()) {
                    caseCourante.setValue("b");
                    continue;
                }

                int numTemp = 0;
                //Boolean correspondant si la case possède une case a gauche
                boolean aGauche = (i - 1) >= 0;
                //Boolean correspondant si la case possède une case a Droite
                boolean aDroite = (i + 1) < plateau.line;
                //Boolean correspondant si la case possède une case en haut
                boolean aHaut = (j - 1) >= 0;
                //Boolean correspondant si la case possède une case en bas
                boolean aBas = (j + 1) < plateau.column;

                //si la case a une case en haut
                if (aHaut) {
                    //on regarde la case du haut
                    CasesDecorator haut = cases[j - 1][i];
                    //si elle a une bombe
                    if (haut.isBomb()) {
                        //on incremente le numéro finale de 1
                        numTemp++;
                    }
                    //si la case a une case en haut a gauche
                    if (aGauche) {
                        //on regarde la case en haut a gauche
                        CasesDecorator hautGauche = cases[j - 1][i - 1];
                        //si la case a une bombe on incrémente de 1
                        if (hautGauche.isBomb()) {
                            numTemp++;
                        }
                    }
                    //si la case a une case en haut a droite
                    if (aDroite) {
                        //on regarde la case en haut a droite
                        CasesDecorator hautDroite = cases[j - 1][i + 1];
                        //si la case a une bombe on incrémente de 1
                        if (hautDroite.isBomb()) {
                            numTemp++;
                        }
                    }
                }
                //si la case a une case en bas
                if (aBas) {
                    //on regarde la base du bas
                    CasesDecorator bas = cases[j + 1][i];
                    //si la case a une bombe on incrémente de 1
                    if (bas.isBomb()) {
                        numTemp++;
                    }
                    //si la case a une case en bas a gauche
                    if (aGauche) {
                        //on regarde la case en bas a gauche
                        CasesDecorator basGauche = cases[j + 1][i - 1];
                        //si la case a une bombe on incrémente de 1
                        if (basGauche.isBomb()) {
                            numTemp++;
                        }
                    }
                    //si la case a une case en bas a droite
                    if (aDroite) {
                        //on regarde la case en bas a droite
                        CasesDecorator basDroite = cases[j + 1][i + 1];
                        //si la case a une bombe on incrémente de 1
                        if (basDroite.isBomb()) {
                            numTemp++;
                        }
                    }
                }
                //si la case a une case à gauche
                if (aGauche) {
                    //On regarde la case de gauche
                    CasesDecorator gauche = cases[j][i - 1];
                    //si la case a une bombe on incrémente de 1
                    if (gauche.isBomb()) {
                        numTemp++;
                    }
                }
                //si la case a une case a droite
                if (aDroite) {
                    //on regarde la case a droite
                    CasesDecorator droite = cases[j][i + 1];
                    //si la case a une bombe on incrémente de 1
                    if (droite.isBomb()) {
                        numTemp++;
                    }
                }
                //on set la value comme le numéro obtenue (de 0 à 8)
                caseCourante.setValue(String.valueOf(numTemp));

            }
        }
    }

    //Affichage du plateau
    public void afficherJeu() {
        System.out.println();
        System.out.print("X");
        //pour chaque colone du plateau
        for (int i = 0; i < plateau.line; i++) {
            //on ajoute le numéro
            System.out.print("│" + (i + 1));
        }
        System.out.print("│");
        System.out.println();
        String[] lettres = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        for (int y = 0; y < cases.length; y++) {
            //pour chaque premiere case de chaque ligne on met la lettre correspondant
            System.out.print(lettres[y] + "│");
            //pour chaque case
            for (int x = 0; x < cases.length; x++) {
                //on y affiche le status de la case
                System.out.print(cases[y][x].afficherStatus() + "│");
            }
            System.out.println();
        }
    }

    //dévoilement de toute les case du jeu lorsque l'on a perdu ou gagner
    public void afficherJeuTerminer(){
        for (CasesDecorator[] aCase : cases) {
            for (int x = 0; x < cases.length; x++) {
                aCase[x].ouvrirCases();
            }
        }
        afficherJeu();
    }


    public CasesDecorator[][] getCases() {
        return cases;
    }



}
