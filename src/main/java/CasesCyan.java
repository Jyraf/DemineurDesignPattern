public class CasesCyan extends CasesDecorator {


    public CasesCyan(SimCases cases) {
        super(cases);
    }

    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[36m" + status + "\u001B[0m";
    }
}
