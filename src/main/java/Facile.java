public class Facile implements Difficultes {
    private SimDifficultes sim_;

    public Facile(SimDifficultes sim){
        sim_ = sim;
    }

    @Override
    public void facile() {
        System.out.println("La difficultée est déjà en Facile");
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
