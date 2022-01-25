import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EtatCaseTest {

    //DECOUVERTE

    @Test
    void testChangementCaseDefautVersDecouverte(){
        //Arrange
        int x = 0;
        int y = 0;
        Case mCase = new Case(x , y , "0", false);

        //Act
        String statusDefaut = mCase.getStatus();
        mCase.selectionnerCase();
        String statusDecouverte = mCase.getStatus();

        //Assert
        assertEquals(statusDefaut, "?");
        assertEquals(statusDecouverte, "0");
    }



    @Test
    void testChangementCaseDrapeauVersDecouverte(){
        //Arrange
        int x = 0;
        int y = 0;
        Case mCase = new Case(x , y , "0", false);
        mCase.drapeauCase();

        //Act
        String statusDrapeau = mCase.getStatus();
        mCase.selectionnerCase();
        String statusDecouverte = mCase.getStatus();

        //Assert
        assertEquals(statusDrapeau, "f");
        assertEquals(statusDecouverte, "0");
    }

    //DRAPEAU

    @Test
    void testChangementCaseDefautVersDrapeau(){
        //Arrange
        int x = 0;
        int y = 0;
        Case mCase = new Case(x,y,"0", false);

        //Act
        String statusDefaut = mCase.getStatus();
        mCase.drapeauCase();
        String statusDrapeau = mCase.getStatus();

        //Assert
        assertEquals(statusDefaut, "?");
        assertEquals(statusDrapeau, "f");
    }

    @Test
    void testChangementCaseDrapeauVersDrapeau(){
        //Arrange
        int x = 0;
        int y = 0;
        Case mCase = new Case(x,y,"0", false);
        mCase.drapeauCase();

        //Act
        String statusDrapeau = mCase.getStatus();
        mCase.drapeauCase();
        String statusCachee = mCase.getStatus();

        //Assert
        assertEquals(statusDrapeau, "f");
        assertEquals(statusCachee, "?");
    }

}
