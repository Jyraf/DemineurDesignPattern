public interface EtatCase {

    //Interfaces des cases du démineur pour le State Case
    void selectionnerCase();

    void drapeauCase();

    String getValue();

    void setValue(String value);

    boolean isBomb();

    void setBomb(boolean bool);

    String afficherStatus();

    String getStatus();
}
