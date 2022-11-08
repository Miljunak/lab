package agh.ics.oop;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class MapTest {

    @Test
    public void testBorder(){
        List<MoveDirection> directions = OptionParser.parse(new String[]{"f", "f", "b", "b", "b", "b", "b", "r",
                "f", "f", "l", "l", "f", "f", "f", "f"});
        IWorldMap map = new RectangularMap(3, 3);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(10,1), new Vector2d(-1, 0) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0,0)));
        assertFalse(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(10,1)));
    }

    @Test
    public void testCollisions(){
        List<MoveDirection> directions = OptionParser.parse(new String[]{"f", "b", "f", "b"});
        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(1,1), new Vector2d(1,2) };
        IWorldMap map = new RectangularMap(3, 3);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertFalse(map.isOccupied(new Vector2d(1,0)));
    }

    @Test
    public void testStress(){
        List<MoveDirection> directions = OptionParser.parse(new String[]{"f", "b", "f", "r", "r", "l", "r", "l",
                "f", "f", "b", "b", "b", "b", "b", "r", "f"});
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(1,1), new Vector2d(1,0) };
        IWorldMap map = new RectangularMap(2, 2);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0,1)));
        assertFalse(map.isOccupied(new Vector2d(1,0)));
    }
}
