import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EtatDifficulteTest {

    //FACILE

    @Test
    void testChangementDifficulteDefautVersFacile(){
        //Arrange
        Difficulte difficulte = new Difficulte();

        //Act
        int nbBombDefaut = difficulte.nbBomb();
        difficulte.facile();
        int nbBombFacile = difficulte.nbBomb();

        //Assert
        assertEquals(nbBombDefaut, 5);
        assertEquals(nbBombFacile, 5);
    }

    @Test
    void testChangementDifficulteNormalVersFacile(){
        //Arrange
        Difficulte difficulte = new Difficulte();
        difficulte.normal();

        //Act
        int nbBombNormal = difficulte.nbBomb();
        difficulte.facile();
        int nbBombFacile = difficulte.nbBomb();

        //Assert
        assertEquals(nbBombNormal, 10);
        assertEquals(nbBombFacile, 5);
    }

    @Test
    void testChangementDifficulteDifficileVersFacile(){
        //Arrange
        Difficulte difficulte = new Difficulte();
        difficulte.difficile();

        //Act
        int nbBombDifficile = difficulte.nbBomb();
        difficulte.facile();
        int nbBombFacile = difficulte.nbBomb();

        //Assert
        assertEquals(nbBombDifficile, 15);
        assertEquals(nbBombFacile, 5);
    }

    //NORMAL

    @Test
    void testChangementDifficulteDefautVersNormal(){
        //Arrange
        Difficulte difficulte = new Difficulte();

        //Act
        int nbBombDefaut = difficulte.nbBomb();
        difficulte.normal();
        int nbBombNormal = difficulte.nbBomb();

        //Assert
        assertEquals(nbBombDefaut, 5);
        assertEquals(nbBombNormal, 10);
    }

    @Test
    void testChangementDifficulteFacileVersNormal(){
        //Arrange
        Difficulte difficulte = new Difficulte();
        difficulte.facile();

        //Act
        int nbBombFacile = difficulte.nbBomb();
        difficulte.normal();
        int nbBombNormal = difficulte.nbBomb();

        //Assert
        assertEquals(nbBombFacile, 5);
        assertEquals(nbBombNormal, 10);
    }

    @Test
    void testChangementDifficulteDifficileVersNormal(){
        //Arrange
        Difficulte difficulte = new Difficulte();
        difficulte.difficile();

        //Act
        int nbBombDifficile = difficulte.nbBomb();
        difficulte.normal();
        int nbBombNormal = difficulte.nbBomb();

        //Assert
        assertEquals(nbBombDifficile, 15);
        assertEquals(nbBombNormal, 10);
    }

    //DIFFICILE

    @Test
    void testChangementDifficulteDefautVersDifficile(){
        //Arrange
        Difficulte difficulte = new Difficulte();

        //Act
        int nbBombDefaut = difficulte.nbBomb();
        difficulte.difficile();
        int nbBombDifficile = difficulte.nbBomb();

        //Assert
        assertEquals(nbBombDefaut, 5);
        assertEquals(nbBombDifficile, 15);
    }

    @Test
    void testChangementDifficulteFacileVersDifficile(){
        //Arrange
        Difficulte difficulte = new Difficulte();
        difficulte.facile();

        //Act
        int nbBombFacile = difficulte.nbBomb();
        difficulte.difficile();
        int nbBombDifficile = difficulte.nbBomb();

        //Assert
        assertEquals(nbBombFacile, 5);
        assertEquals(nbBombDifficile, 15);
    }

    @Test
    void testChangementDifficulteNormalVersDifficile(){
        //Arrange
        Difficulte difficulte = new Difficulte();
        difficulte.normal();

        //Act
        int nbBombNormal = difficulte.nbBomb();
        difficulte.difficile();
        int nbBombDifficile = difficulte.nbBomb();

        //Assert
        assertEquals(nbBombNormal, 10);
        assertEquals(nbBombDifficile, 15);
    }


}
