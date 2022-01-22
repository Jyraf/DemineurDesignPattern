public class CasesVerte extends CasesDecorator {

    //Gestion de la couleur Verte pour les cases grace au décorateur
    public CasesVerte(SimCases cases) {
        super(cases);
    }
    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[32m" + status + "\u001B[0m";
    }
}
