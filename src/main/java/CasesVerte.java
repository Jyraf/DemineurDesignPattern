public class CasesVerte extends CasesDecorator {


    public CasesVerte(SimCases cases) {
        super(cases);
    }

    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[32m" + status + "\u001B[0m";
    }
}
