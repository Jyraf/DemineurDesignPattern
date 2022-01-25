import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecorateurCaseTest {

    @Test
    void affichageCouleurBlanc(){
        //Arrange
        int x = 0;
        int y = 0;
        DecorateurCase mCase = new DecorateurCaseBlanche(new Case(x, y, "0", false));

        //Act
        String result = mCase.afficherStatus();
        mCase.selectionnerCase();
        String newResult = mCase.afficherStatus();

        //Assert
        assertEquals(result, "\u001B[37m?\u001B[0m");
        assertNotEquals(result, "\u001B[37m0\u001B[0m");
        assertNotEquals(newResult, "\u001B[37m?\u001B[0m");
        assertEquals(newResult, "\u001B[37m0\u001B[0m");

    }

    @Test
    void affichageCouleurBleu(){
        //Arrange
        int x = 0;
        int y = 0;
        DecorateurCase mCase = new DecorateurCaseBleu(new Case(x, y, "0", false));

        //Act
        String result = mCase.afficherStatus();
        mCase.selectionnerCase();
        String newResult = mCase.afficherStatus();

        //Assert
        assertEquals(result, "\u001B[34m?\u001B[0m");
        assertNotEquals(result, "\u001B[34m0\u001B[0m");
        assertNotEquals(newResult, "\u001B[34m?\u001B[0m");
        assertEquals(newResult, "\u001B[34m0\u001B[0m");


    }

    @Test
    void affichageCouleurCyan(){
        //Arrange
        int x = 0;
        int y = 0;
        DecorateurCase mCase = new DecorateurCaseCyan(new Case(x, y, "0", false));

        //Act
        String result = mCase.afficherStatus();
        mCase.selectionnerCase();
        String newResult = mCase.afficherStatus();

        //Assert
        assertEquals(result, "\u001B[36m?\u001B[0m");
        assertNotEquals(result, "\u001B[36m0\u001B[0m");
        assertNotEquals(newResult, "\u001B[36m?\u001B[0m");
        assertEquals(newResult, "\u001B[36m0\u001B[0m");
    }

    @Test
    void affichageCouleurJaune(){
        //Arrange
        int x = 0;
        int y = 0;
        DecorateurCase mCase = new DecorateurCaseJaune(new Case(x, y, "0", false));

        //Act
        String result = mCase.afficherStatus();
        mCase.selectionnerCase();
        String newResult = mCase.afficherStatus();

        //Assert
        assertEquals(result, "\u001B[33m?\u001B[0m");
        assertNotEquals(result, "\u001B[33m0\u001B[0m");
        assertNotEquals(newResult, "\u001B[33m?\u001B[0m");
        assertEquals(newResult, "\u001B[33m0\u001B[0m");
    }

    @Test
    void affichageCouleurNoir(){
        //Arrange
        int x = 0;
        int y = 0;
        DecorateurCase mCase = new DecorateurCaseNoir(new Case(x, y, "0", false));

        //Act
        String result = mCase.afficherStatus();
        mCase.selectionnerCase();
        String newResult = mCase.afficherStatus();

        //Assert
        assertEquals(result, "\u001B[30m?\u001B[0m");
        assertNotEquals(result, "\u001B[30m0\u001B[0m");
        assertNotEquals(newResult, "\u001B[30m?\u001B[0m");
        assertEquals(newResult, "\u001B[30m0\u001B[0m");
    }

    @Test
    void affichageCouleurRouge(){
        //Arrange
        int x = 0;
        int y = 0;
        DecorateurCase mCase = new DecorateurCaseRouge(new Case(x, y, "0", false));

        //Act
        String result = mCase.afficherStatus();
        mCase.selectionnerCase();
        String newResult = mCase.afficherStatus();

        //Assert
        assertEquals(result, "\u001B[31m?\u001B[0m");
        assertNotEquals(result, "\u001B[31m0\u001B[0m");
        assertNotEquals(newResult, "\u001B[31m?\u001B[0m");
        assertEquals(newResult, "\u001B[31m0\u001B[0m");
    }

    @Test
    void affichageCouleurVerte(){
        //Arrange
        int x = 0;
        int y = 0;
        DecorateurCase mCase = new DecorateurCaseVerte(new Case(x, y, "0", false));

        //Act
        String result = mCase.afficherStatus();
        mCase.selectionnerCase();
        String newResult = mCase.afficherStatus();

        //Assert
        assertEquals(result, "\u001B[32m?\u001B[0m");
        assertNotEquals(result, "\u001B[32m0\u001B[0m");
        assertNotEquals(newResult, "\u001B[32m?\u001B[0m");
        assertEquals(newResult, "\u001B[32m0\u001B[0m");
    }

    @Test
    void affichageCouleurViolette(){
        //Arrange
        int x = 0;
        int y = 0;
        DecorateurCase mCase = new DecorateurCaseViolette(new Case(x, y, "0", false));

        //Act
        String result = mCase.afficherStatus();
        mCase.selectionnerCase();
        String newResult = mCase.afficherStatus();

        //Assert
        assertEquals(result, "\u001B[35m?\u001B[0m");
        assertNotEquals(result, "\u001B[35m0\u001B[0m");
        assertNotEquals(newResult, "\u001B[35m?\u001B[0m");
        assertEquals(newResult, "\u001B[35m0\u001B[0m");
    }

}
