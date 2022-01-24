public class Difficulte {

    private EtatDifficulte facile;
    private EtatDifficulte normal;
    private EtatDifficulte difficile;

    private EtatDifficulte etatDifficulte;
    //Simulateur pour le State de la difficulté
    public Difficulte(){
        facile = new EtatDifficulteFacile(this);
        normal = new EtatDifficulteNormal(this);
        difficile = new EtatDifficulteDifficile(this);

        etatDifficulte = facile;
    }

    public void facile(){
        etatDifficulte.facile();
    }

    public void normal(){
        etatDifficulte.normal();
    }

    public void difficile(){
        etatDifficulte.difficile();
    }

    public int nbBomb(){
        return etatDifficulte.nbBombe();
    }

    public void changeFacile(){
        etatDifficulte = facile;
    }

    public void changeNormal(){
        etatDifficulte = normal;
    }

    public void changeDifficile(){
        etatDifficulte = difficile;
    }
}

