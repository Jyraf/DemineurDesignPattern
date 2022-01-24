public class App {

    public static void main(String[] args) {
        //création du plateau grâce au Directeur
        Builder plateauBuilder = new PlateauBuilder();
        Director director = new Director(plateauBuilder);
        Plateau plateau = director.makePetitPlateau();

        //Instanciation de la difficulté
        Difficulte difficultes = new Difficulte();

        //instantation de la couleur
        String couleur = "blanc";

        //création de l'interface utilisateur
        InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau, difficultes, couleur);

        //affichage du menu
        iu.menu();
    }
}