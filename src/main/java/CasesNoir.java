public class CasesNoir extends CasesDecorator {


    public CasesNoir(SimCases cases) {
        super(cases);
    }

    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[30m" + status + "\u001B[0m";
    }
}
