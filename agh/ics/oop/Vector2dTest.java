package agh.ics.oop;

import org.testng.annotations.Test;
import java.util.Objects;
import static org.testng.AssertJUnit.fail;

public class Vector2dTest {

    @Test
    public void testEquals(){

        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d( 1, 0);
        Vector2d v3 = new Vector2d(0,0);
        Object v4 = new Object();

        if (!v1.equals(v2)) fail("2 obiekty o tych samych x,y zostaja uznane za rozne");
        if (v1.equals(v3)) fail("2 obiekty o roznych x,y zostaja uznane za identyczne");
        if (v1.equals(v4)) fail("Funkcja uznaje (Object) za rowny wektor");
    }

    @Test
    public void testToString(){

        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d(2731, 111111111);

        if (!Objects.equals(v1.toString(), "(1,0)")) fail("Funkcja nie dziala");
        if (!Objects.equals(v2.toString(), "(2731,111111111)")) fail("Funkcja nie dziala");
    }

    @Test
    public void testPrecedes(){

        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d( 1, 0);
        Vector2d v3 = new Vector2d(0,0);
        if (!v1.precedes(v2)) fail("Funkcja nie dziala");
        if (v1.precedes(v3)) fail("Funkcja nie dziala");

    }

    @Test
    public void testFollows(){

        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d( 1, 0);
        Vector2d v3 = new Vector2d(0,0);

        if (!v1.follows(v2)) fail("Funkcja nie dziala");
        if (!v1.follows(v3)) fail("Funkcja nie dziala");

    }

    @Test
    public void testAdd(){

        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d( -1, 100);
        Vector2d v3 = new Vector2d(0,0);

        if (!Objects.equals(v1.add(v2), new Vector2d(0, 100))) fail("Funkcja nie dziala");
        if (!Objects.equals(v1.add(v3), v1)) fail("Funkcja nie dziala");

    }

    @Test
    public void testSubstract(){

        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d( -1, 100);
        Vector2d v3 = new Vector2d(0,0);

        if (!Objects.equals(v1.subtract(v2), new Vector2d(2, -100))) fail("Funkcja nie dziala");
        if (!Objects.equals(v1.subtract(v3), v1)) fail("Funkcja nie dziala");

    }

    @Test
    public void testUpperRight(){

        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d( -1, 100);
        Vector2d v3 = new Vector2d(0,0);

        if (!Objects.equals(v1.upperRight(v2), new Vector2d(1, 100))) fail("Funkcja nie dziala");
        if (!Objects.equals(v1.upperRight(v3), v1)) fail("Funkcja nie dziala");

    }

    @Test
    public void testLowerLeft(){

        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d( -1, 100);
        Vector2d v3 = new Vector2d(0,0);

        if (!Objects.equals(v1.lowerLeft(v2), new Vector2d(-1, 0))) fail("Funkcja nie dziala");
        if (!Objects.equals(v1.lowerLeft(v3), v3)) fail("Funkcja nie dziala");

    }

    @Test
    public void testOpposite(){

        Vector2d v1 = new Vector2d(1,0);
        Vector2d v2 = new Vector2d( 0, 0);

        if (!Objects.equals(v1.opposite(), new Vector2d(-1, 0))) fail("Funkcja nie dziala");
        if (v2.opposite() != v2) fail("Funkcja nie dziala");

    }
}
