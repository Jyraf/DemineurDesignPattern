public class DecorateurCaseRouge extends DecorateurCase {

    //Gestion de la couleur Rouge pour les cases grace au décorateur
    public DecorateurCaseRouge(Case cases) {
        super(cases);
    }

    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[31m" + status + "\u001B[0m";
    }
}
