public class EtatDifficulteDifficile implements EtatDifficulte {
    private Difficulte sim_;

    //Etat de Difficultés correspondant a un nombre de bombe de 15
    public EtatDifficulteDifficile(Difficulte sim){
        sim_ = sim;
    }

    public void setDifficulteFacile() {
        sim_.changeFacile();
    }


    public void setDifficulteNormal() {
        sim_.changeNormal();
    }


    public void setDifficulteDifficile() {

    }


    public int nbBombe() {
        return 15;
    }
}
