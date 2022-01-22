public class CasesDrapeau implements Cases {
    private SimCases sim_;
    private int x;
    private int y;
    private String value;
    private boolean isBomb;

    public CasesDrapeau(SimCases sim_, int x, int y, String value, boolean isBomb) {
        this.sim_ = sim_;
        this.x = x;
        this.y = y;
        this.value = value;
        this.isBomb = isBomb;
    }

    public CasesDrapeau(SimCases sim){
        this.sim_ = sim;
    }

    public void ouvrirCases() {
        sim_.changeCasesDecouvertes();
    }

    public void fermerCases() {
        sim_.changeCasesCachees();
    }

    public void flagCases() {
        System.out.println("La case est déjà un Drapeau");
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean isBomb() {
        return isBomb;
    }

    @Override
    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public String afficherStatus(){
        return "f";
    }

    public String getStatus(){
        return "f";
    }
}
