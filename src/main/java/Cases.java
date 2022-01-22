public interface Cases {
    //Interfaces des cases du démineur pour le State Cases
    void ouvrirCases();

    void fermerCases();

    void flagCases();

    String getValue();

    void setValue(String value);

    boolean isBomb();

    void setBomb(boolean bool);

    String afficherStatus();

    String getStatus();
}
