public class CasesCachees implements Cases{
    private SimCases sim_;
    private int x;
    private int y;
    private String value;
    private boolean isBomb;

    public CasesCachees(SimCases sim_, int x, int y, String value, boolean isBomb) {
        this.sim_ = sim_;
        this.x = x;
        this.y = y;
        this.value = value;
        this.isBomb = isBomb;
    }

    public CasesCachees(SimCases sim){
        this.sim_ = sim;
    }

    public void ouvrirCases() {
        sim_.changeCasesDecouvertes();
    }

    public void fermerCases() {
        System.out.println("La case est déja cachée");
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

    public String afficherStatus(){
        return "?";
    }
}
