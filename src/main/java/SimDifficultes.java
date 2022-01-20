public class SimDifficultes {

    private Difficultes facile;
    private Difficultes normal;
    private Difficultes difficile;

    private Difficultes difficultes;

    public SimDifficultes(){
        facile = new Facile(this);
        normal = new Normal(this);
        difficile = new Difficile(this);

        difficultes = facile;
    }

    public void facile(){
        difficultes.facile();
    }

    public void normal(){
        difficultes.normal();
    }

    public void difficile(){
        difficultes.difficile();
    }

    public int nbBomb(){
        return difficultes.nbBombe();
    }

    public void changeFacile(){
        difficultes = facile;
    }

    public void changeNormal(){
        difficultes = normal;
    }

    public void changeDifficile(){
        difficultes = difficile;
    }
}

