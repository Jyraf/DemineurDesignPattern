public class EtatDifficulteFacile implements EtatDifficulte {
    private Difficulte sim_;

    //Etat de Difficultés correspondant a un nombre de bombe de 5
    public EtatDifficulteFacile(Difficulte sim){
        sim_ = sim;
    }

    @Override
    public void facile() {
        System.out.println("La difficultee est deja en Facile");
    }

    @Override
    public void normal() {
        sim_.changeNormal();
    }

    @Override
    public void difficile() {
        sim_.changeDifficile();
    }

    @Override
    public int nbBombe() {
        return 5;
    }
}
