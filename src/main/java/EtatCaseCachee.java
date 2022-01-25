public class EtatCaseCachee implements EtatCase {

    private Case sim_;
    private int x;
    private int y;
    private String value;
    private boolean isBomb;

    //Etat des cases permettant de créé des cases non découverte
    public EtatCaseCachee(Case sim_, int x, int y, String value, boolean isBomb) {
        this.sim_ = sim_;
        this.x = x;
        this.y = y;
        this.value = value;
        this.isBomb = isBomb;
    }

    public void ouvrirCases() {
        sim_.changeCasesDecouvertes();
    }

    public void fermerCases() {
        System.out.println("La case est deja cachee");
    }

    public void flagCases() {
        sim_.changeCasesDrapeau();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public String afficherStatus() {
        return "?";
    }
    public String getStatus(){
        return "?";
    }
}
