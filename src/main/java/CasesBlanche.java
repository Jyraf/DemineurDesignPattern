public class CasesBlanche extends CasesDecorator {


    public CasesBlanche(SimCases cases) {
        super(cases);
    }

    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[37m" + status + "\u001B[0m";
    }
}
