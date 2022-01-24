public interface EtatCase {

    //Interfaces des cases du démineur pour le State Case
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
