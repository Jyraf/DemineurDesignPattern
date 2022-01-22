public class CasesViolet extends CasesDecorator {


    public CasesViolet(SimCases cases) {
        super(cases);
    }

    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[35m" + status + "\u001B[0m";
    }
}
