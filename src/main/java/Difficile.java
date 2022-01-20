public class Difficile implements Difficultes{
    private SimDifficultes sim_;

    public Difficile(SimDifficultes sim){
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
