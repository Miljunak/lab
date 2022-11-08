package agh.ics.oop;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class AnimalParserTest {

    @Test
    public void testOrientation(){

        Animal fox = new Animal();
        assertTrue(String.valueOf(fox).contains("Północ"));
        fox.move(MoveDirection.RIGHT);
        fox.move(MoveDirection.RIGHT);
        fox.move(MoveDirection.LEFT);
        assertTrue(String.valueOf(fox).contains("Wschód"));
        assertFalse(String.valueOf(fox).contains("Północ"));
        for(int i = 0; i < 3; i++) fox.move(MoveDirection.FORWARD);
        assertTrue(String.valueOf(fox).contains("Wschód"));

    }

    @Test
    public void testPosistionBorders(){

        Animal dog = new Animal();
        assertTrue(String.valueOf(dog).contains("(2,2)"));
        dog.move(MoveDirection.FORWARD);
        assertTrue(String.valueOf(dog).contains("(2,3)"));
        dog.move(MoveDirection.LEFT);
        for(int i = 0; i < 10; i++) dog.move(MoveDirection.BACKWARD);
        assertTrue(String.valueOf(dog).contains("(4,3)"));
        assertFalse(String.valueOf(dog).contains("(2,2)"));
        dog.move(MoveDirection.LEFT);
        for(int i = 0; i < 10; i++) dog.move(MoveDirection.FORWARD);
        dog.move(MoveDirection.RIGHT);
        for(int i = 0; i < 10; i++) dog.move(MoveDirection.FORWARD);
        assertTrue(String.valueOf(dog).contains("(0,0)"));

    }

    @Test
    public void testParser(){

        String[] good = new String[] {"f", "r", "forward", "left", "right", "l", "b", "backward"};
        String[] bad = new String[] {"f", "r", "forwards", "left", "right", "l", "B", "backward"};
        List<MoveDirection> goods = OptionParser.parse(good);
        List<MoveDirection> bads = OptionParser.parse(bad);
        MoveDirection[] confirmation = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD,
                MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
        MoveDirection[] confirmation2 = new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.RIGHT,
                MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.BACKWARD};
        for(int i = 0; i < 8; i++) assertSame(confirmation[i], goods.get(i));
        for(int i = 0; i < 6; i++) assertSame(confirmation2[i], bads.get(i));

    }
}
