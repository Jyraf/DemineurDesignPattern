public class CasesNoir extends CasesDecorator {

    //Gestion de la couleur Noir pour les cases grace au décorateur
    public CasesNoir(SimCases cases) {
        super(cases);
    }
    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[30m" + status + "\u001B[0m";
    }
}
