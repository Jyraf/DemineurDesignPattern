public class App {
    public static void main(String[] args) {
        System.out.println("\033[0;30m" + "RED COLORED" + "\033[1;33m" + " NORMAL");

        Builder plateauBuilder = new PlateauBuilder();
        Director director = new Director(plateauBuilder);
        Plateau plateau = director.makePetitPlateau();
        SimDifficultes difficultes = new SimDifficultes();
        InterfaceUtilisateur iu = new InterfaceUtilisateur(plateau, difficultes);
        iu.menu();
    }
}