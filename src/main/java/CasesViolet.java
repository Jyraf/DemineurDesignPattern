public class CasesViolet extends CasesDecorator {

    //Gestion de la couleur Violet pour les cases grace au décorateur
    public CasesViolet(SimCases cases) {
        super(cases);
    }
    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[35m" + status + "\u001B[0m";
    }
}
