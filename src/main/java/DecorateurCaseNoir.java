public class DecorateurCaseNoir extends DecoratorCase {

    //Gestion de la couleur Noir pour les cases grace au décorateur
    public DecorateurCaseNoir(Case cases) {
        super(cases);
    }

    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[30m" + status + "\u001B[0m";
    }
}
