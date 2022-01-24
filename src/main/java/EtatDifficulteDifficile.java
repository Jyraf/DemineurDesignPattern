public class EtatDifficulteDifficile implements EtatDifficulte {
    private Difficulte sim_;

    //Etat de Difficultés correspondant a un nombre de bombe de 15
    public EtatDifficulteDifficile(Difficulte sim){
        sim_ = sim;
    }

    public void facile() {
        sim_.changeFacile();
    }


    public void normal() {
        sim_.changeNormal();
    }


    public void difficile() {
        System.out.println("Difficultée déja en difficile");
    }


    public int nbBombe() {
        return 15;
    }
}
