package agh.ics.oop;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.fail;

public class MapDirectionTest {

    @Test
    public void testNext(){
        MapDirection dir = MapDirection.NORTH;
        if (dir.next() != MapDirection.EAST) System.out.println("Blad 1!");
        else{
            if (dir.next().next() != MapDirection.SOUTH) System.out.println("Blad 2!");
            else{
                if (dir.next().next().next() != MapDirection.WEST) System.out.println("Blad 3!");
                else{
                    if (dir.next().next().next().next() != MapDirection.NORTH) System.out.println("Blad 4!");
                    else System.out.println("Wszystko Dziala");
                }
            }
        }
    }

    @Test
    public void testPrevious(){
        MapDirection dir1 = MapDirection.NORTH;
        MapDirection dir2 = MapDirection.SOUTH;
        MapDirection dir3 = MapDirection.EAST;
        MapDirection dir4 = MapDirection.WEST;

        if (dir1.previous() != MapDirection.WEST) fail("Blad!");
        if (dir2.previous() != MapDirection.EAST) fail("Blad!");
        if (dir3.previous() != MapDirection.NORTH) fail("Blad!");
        if (dir4.previous() != MapDirection.SOUTH) fail("Blad!");
    }
}
