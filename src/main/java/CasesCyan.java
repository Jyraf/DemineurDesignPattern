public class CasesCyan extends CasesDecorator {

    //Gestion de la couleur Cyan pour les cases grace au décorateur
    public CasesCyan(SimCases cases) {
        super(cases);
    }
    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[36m" + status + "\u001B[0m";
    }
}
