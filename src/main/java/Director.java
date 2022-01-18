public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public  Plateau makeGrandPlateau(){
        builder.buildColumn(9);
        builder.buildLine(9);
        return builder.getPlateau();
    }

    public  Plateau makeMoyenPlateau(){
        builder.buildColumn(7);
        builder.buildLine(7);
        return builder.getPlateau();
    }

    public  Plateau makePetitPlateau(){
        builder.buildColumn(5);
        builder.buildLine(5);
        return builder.getPlateau();
    }

}
