public class Point {
    private final int x;
    private final int y;
    protected boolean ouverte = false;
    private boolean drapeau = false;
    private int nbMinesAutour;
    protected String etat = "?";

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setNbMinesAutour(int nbMinesAutour) {
        this.nbMinesAutour = nbMinesAutour;
    }

    public boolean estVoisineDe(Point p) {
        int px = p.getX();
        int py = p.getY();

        /*
            a b c
            d   e
            f g h
        */

        return (x+1 == px || x-1 == px) && y == py 
        || y-1 == py && (x == px || x-1 == px || x+1 == px) 
        || y+1 == py && (x == px || x-1 == px || x+1 == px);
    }

    public boolean estOuverte() {
        return ouverte;
    }

    public boolean estDrapeau() {
        return drapeau;
    }

    public void mettreDrapeau() {
        if (drapeau) {
            drapeau = false;
            etat = "?";
        } else {
            drapeau = true;
            etat = "!";
        }
    }

    public int ouvrir() {
        ouverte = true;
        etat = String.valueOf(nbMinesAutour);
        return 1;
    }

    public String toString() {
        return etat;
    }
}


