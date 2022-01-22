public class Normal implements Difficultes{
    private SimDifficultes sim_;

    //Etat de Difficultés correspondant a un nombre de bombe de 7
    public Normal(SimDifficultes sim){
        sim_ = sim;
    }


    @Override
    public void facile() {
        sim_.changeFacile();
    }

    @Override
    public void normal() {
        System.out.println("La difficultée est déjà en Normal");
    }

    @Override
    public void difficile() {
        sim_.changeDifficile();
    }

    @Override
    public int nbBombe() {
        return 7;
    }
}
