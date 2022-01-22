public class CasesRouge extends CasesDecorator {

    //Gestion de la couleur Rouge pour les cases grace au décorateur
    public CasesRouge(SimCases cases) {
        super(cases);
    }
    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[31m" + status + "\u001B[0m";
    }
}
