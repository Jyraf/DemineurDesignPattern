public abstract class DecorateurCase implements EtatCase {
    protected Case cases;

    //Classe abstraite pour le Décorateur des cases

    public DecorateurCase(Case cases){
        this.cases = cases;
    }

    @Override
    public void selectionnerCase() {
        cases.selectionnerCase();
    }

    @Override
    public void drapeauCase() {
        cases.drapeauCase();
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
