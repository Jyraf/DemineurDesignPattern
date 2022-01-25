import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauBuilderTest {

    @Test
    void testCreationPetitPlateau(){
        //Arrange
        Builder plateauBuilder = new PlateauBuilder();
        Director director = new Director(plateauBuilder);


        //Act
        Plateau plateau = director.makePetitPlateau();


        //Assert
        assertEquals(plateau.column, 5);
        assertEquals(plateau.line, 5);

    }

    @Test
    void testCreationMoyenPlateau(){
        //Arrange
        Builder plateauBuilder = new PlateauBuilder();
        Director director = new Director(plateauBuilder);


        //Act
        Plateau plateau = director.makeMoyenPlateau();


        //Assert
        assertEquals(plateau.column, 7);
        assertEquals(plateau.line, 7);

    }

    @Test
    void testCreationGrandPlateau(){
        //Arrange
        Builder plateauBuilder = new PlateauBuilder();
        Director director = new Director(plateauBuilder);


        //Act
        Plateau plateau = director.makeGrandPlateau();


        //Assert
        assertEquals(plateau.column, 9);
        assertEquals(plateau.line, 9);

    }


}
