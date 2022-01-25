public class EtatDifficulteFacile implements EtatDifficulte {
    private Difficulte sim_;

    //Etat de Difficultés correspondant a un nombre de bombe de 5
    public EtatDifficulteFacile(Difficulte sim){
        sim_ = sim;
    }

    @Override
    public void setDifficulteFacile() {
    }

    @Override
    public void setDifficulteNormal() {
        sim_.changeNormal();
    }

    @Override
    public void setDifficulteDifficile() {
        sim_.changeDifficile();
    }

    @Override
    public int nbBombe() {
        return 5;
    }
}
