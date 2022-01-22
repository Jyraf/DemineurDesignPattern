public class Director {
    private Builder builder;
    //Director du Builder Plateau
    public Director(Builder builder){
        this.builder = builder;
    }
    //Création d'un grand plateau de 9 par 9
    public  Plateau makeGrandPlateau(){
        builder.buildColumn(9);
        builder.buildLine(9);
        return builder.getPlateau();
    }
    //Création d'un plateau moyen de 7 par 7
    public  Plateau makeMoyenPlateau(){
        builder.buildColumn(7);
        builder.buildLine(7);
        return builder.getPlateau();
    }
    //Création d'un petit plateau de 5 par 5
    public  Plateau makePetitPlateau(){
        builder.buildColumn(5);
        builder.buildLine(5);
        return builder.getPlateau();
    }

}
