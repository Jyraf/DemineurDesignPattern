public class CasesRouge extends CasesDecorator {


    public CasesRouge(SimCases cases) {
        super(cases);
    }

    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[31m" + status + "\u001B[0m";
    }
}
