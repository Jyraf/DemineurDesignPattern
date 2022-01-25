public class DecorateurCaseBlanche extends DecorateurCase {

    //Gestion de la couleur blanche pour les cases grace au décorateur
    public DecorateurCaseBlanche(Case cases) {
        super(cases);
    }

    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[37m" + status + "\u001B[0m";
    }
}
