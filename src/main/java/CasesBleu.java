public class CasesBleu extends CasesDecorator {

    //Gestion de la couleur bleu pour les cases grace au décorateur
    public CasesBleu(SimCases cases) {
        super(cases);
    }
    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[34m" + status + "\u001B[0m";
    }
}
