public class App {
    public static void main(String[] args) {
        //création du plateau grace au Directeur
        Builder plateauBuilder = new PlateauBuilder();
        Director director = new Director(plateauBuilder);
        Plateau plateau = director.makePetitPlateau();

        //Instantation de la difficultée
        SimDifficultes difficultes = new SimDifficultes();

        //instantation de la couleur
        String couleur = "blanc";

        //création de l'interfaceUtilisateur
        InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau, difficultes, couleur);

        //affichage du menu
        iu.menu();
    }
}