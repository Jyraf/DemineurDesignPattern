public abstract class DecoratorCase implements EtatCase {
    protected Case cases;

    //Classe abstraite pour le Décorateur des cases

    public DecoratorCase(Case cases){
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

}
