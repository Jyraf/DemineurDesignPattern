public class SimCases {

    private Cases casesCachees;
    private Cases casesDecouvertes;
    private Cases casesDrapeau;

    private Cases cases;

    public SimCases(int x, int y, String value, boolean isBomb) {
        casesCachees = new CasesCachees(this, x, y, value, isBomb);
        casesDecouvertes = new CasesDecouvertes(this, x, y, value, isBomb);
        casesDrapeau = new CasesDrapeau(this, x, y, value, isBomb);

        cases = casesCachees;
    }

    public void ouvrirCases() {
        cases.ouvrirCases();
    }

    public void fermerCases() {
        cases.fermerCases();
    }

    public void flagCases() {
        cases.flagCases();
    }

    public void changeCasesCachees() {
        cases = casesCachees;
    }

    public void changeCasesDecouvertes() {
        cases = casesDecouvertes;
    }

    public void changeCasesDrapeau() {
        cases = casesDrapeau;
    }

    public boolean isBomb(){
       return cases.isBomb();
    }

    public String getValue(){
       return cases.getValue();
    }

    public void setValue(String value){
        casesCachees.setValue(value);
        casesDrapeau.setValue(value);
        casesDecouvertes.setValue(value);
        cases.setValue(value);
    }

    public void setBomb(boolean bomb){
        cases.setBomb(bomb);
        casesCachees.setBomb(bomb);
        casesDecouvertes.setBomb(bomb);
        casesDrapeau.setBomb(bomb);
    }

    public String afficherStatus(){
        return cases.afficherStatus();
    }


}
