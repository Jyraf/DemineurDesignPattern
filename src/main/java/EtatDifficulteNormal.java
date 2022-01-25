public class EtatDifficulteNormal implements EtatDifficulte {
    private Difficulte sim_;

    //Etat de Difficultés correspondant a un nombre de bombe de 10
    public EtatDifficulteNormal(Difficulte sim){
        sim_ = sim;
    }


    @Override
    public void setDifficulteFacile() {
        sim_.changeFacile();
    }

    @Override
    public void setDifficulteNormal(){
    }

    @Override
    public void setDifficulteDifficile() {
        sim_.changeDifficile();
    }

    @Override
    public int nbBombe() {
        return 10;
    }
}
