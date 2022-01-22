public abstract class CasesDecorator implements Cases {
    protected SimCases cases;

    public CasesDecorator(SimCases cases){
        this.cases = cases;
    }

    @Override
    public void ouvrirCases() {
        cases.ouvrirCases();
    }

    @Override
    public void fermerCases() {
        cases.fermerCases();
    }

    @Override
    public void flagCases() {
        cases.flagCases();
    }

    @Override
    public String getValue() {
        return cases.getValue();
    }

    @Override
    public void setValue(String value) {
        cases.setValue(value);
    }

    @Override
    public boolean isBomb() {
        return cases.isBomb();
    }

    @Override
    public void setBomb(boolean bool) {
        cases.setBomb(bool);
    }

    public String afficherStatus(){
        return cases.afficherStatus();
    }

    public String getStatus(){
        return cases.getStatus();
    }

    public void changeCasesCachees() { cases.changeCasesCachees(); }

    public void changeCasesDecouvertes() { cases.changeCasesDecouvertes(); }

    public void changeCasesDrapeau() { cases.changeCasesDrapeau(); }
}
