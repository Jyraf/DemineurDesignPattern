public class App {
    public static void main(String[] args) {
        Builder plateauBuilder = new PlateauBuilder();
        Director director = new Director(plateauBuilder);
        Plateau plateau = director.makePetitPlateau();
        SimDifficultes difficultes = new SimDifficultes();
        String couleur = "blanc";
        InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau, difficultes, couleur);
        iu.menu();
    }
}