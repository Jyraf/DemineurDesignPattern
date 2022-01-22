public class PlateauBuilder implements Builder {
    int colunm = 0;
    int line = 0;
    //Builder concret du Plateau
    @Override
    public void buildColumn(int column) {
        this.colunm = column;
    }

    @Override
    public void buildLine(int line) {
        this.line = line;
    }

    public Plateau getPlateau(){
        return new Plateau(colunm, line);
    }


}
