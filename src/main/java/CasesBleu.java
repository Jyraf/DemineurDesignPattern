public class CasesBleu extends CasesDecorator {


    public CasesBleu(SimCases cases) {
        super(cases);
    }

    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[34m" + status + "\u001B[0m";
    }
}
