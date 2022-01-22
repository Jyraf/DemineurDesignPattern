public class CasesJaune extends CasesDecorator {


    public CasesJaune(SimCases cases) {
        super(cases);
    }

    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[33m" + status + "\u001B[0m";
    }
}
