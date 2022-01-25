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
        etatDifficulte.setDifficulteFacile();
    }

    public void normal(){
        etatDifficulte.setDifficulteNormal();
    }

    public void difficile(){
        etatDifficulte.setDifficulteDifficile();
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

