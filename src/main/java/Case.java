public class Case {

    private EtatCase etatCaseCachees;
    private EtatCase etatCaseDecouvertes;
    private EtatCase etatCaseDrapeau;

    private EtatCase etatCase;

    //Simulateur pour le state des cases
    public Case(int x, int y, String value, boolean isBomb) {
        etatCaseCachees = new EtatCaseCachee(this, x, y, value, isBomb);
        etatCaseDecouvertes = new EtatCaseDecouverte(this, x, y, value, isBomb);
        etatCaseDrapeau = new EtatCaseDrapeau(this, x, y, value, isBomb);

        etatCase = etatCaseCachees;
    }

    public void ouvrirCases() {
        etatCase.ouvrirCases();
    }

    public void fermerCases() {
        etatCase.fermerCases();
    }

    public void flagCases() {
        etatCase.flagCases();
    }

    public void changeCasesCachees() {
        etatCase = etatCaseCachees;
    }

    public void changeCasesDecouvertes() {
        etatCase = etatCaseDecouvertes;
    }

    public void changeCasesDrapeau() {
        etatCase = etatCaseDrapeau;
    }

    public boolean isBomb(){
       return etatCase.isBomb();
    }

    public String getValue(){
       return etatCase.getValue();
    }

    public void setValue(String value){
        etatCaseCachees.setValue(value);
        etatCaseDrapeau.setValue(value);
        etatCaseDecouvertes.setValue(value);
        etatCase.setValue(value);
    }

    public void setBomb(boolean bomb){
        etatCase.setBomb(bomb);
        etatCaseCachees.setBomb(bomb);
        etatCaseDecouvertes.setBomb(bomb);
        etatCaseDrapeau.setBomb(bomb);
    }

    public String afficherStatus(){
        return etatCase.afficherStatus();
    }

    public String getStatus(){
        return etatCase.getStatus();
    }


}
