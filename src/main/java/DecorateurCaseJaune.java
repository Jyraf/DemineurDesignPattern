public class DecorateurCaseJaune extends DecoratorCase {

    //Gestion de la couleur Jaune pour les cases grace au décorateur
    public DecorateurCaseJaune(Case cases) {
        super(cases);
    }

    //modification de la methode afficherStatus pour y ajouter la couleur
    @Override
    public String afficherStatus() {
        String status = cases.afficherStatus();
        return "\u001B[33m" + status + "\u001B[0m";
    }
}
