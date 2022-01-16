public class Mine extends Point {
    
    public Mine(int x, int y) {
        super(x,y);
    } 

    @Override
    public int ouvrir() {
        ouverte = true;
        etat = "b";
        return -1;
    }
}
