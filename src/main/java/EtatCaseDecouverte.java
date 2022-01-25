public class EtatCaseDecouverte implements EtatCase {

    private Case sim_;
    private int x;
    private int y;
    private String value;
    private boolean isBomb;

    //Etat des cases permettant de créé des cases Decouverte
    public EtatCaseDecouverte(Case sim_, int x, int y, String value, boolean isBomb) {
        this.sim_ = sim_;
        this.x = x;
        this.y = y;
        this.value = value;
        this.isBomb = isBomb;
    }


    public void selectionnerCase() {}

    public void drapeauCase() {}

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

    public String afficherStatus(){
        return getValue();
    }

    public String getStatus(){
        return getValue();
    }
}
