package agh.ics.oop;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class GrassFieldTest {

    @Test
    public void testImportance(){
        List<MoveDirection> directions = OptionParser.parse(new String[]{"f"});
        IWorldMap map = new GrassField(0);
        ((GrassField) map).bruteForceGrass(new Vector2d(0,0));
        Vector2d[] positions = { new Vector2d(0,0) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        assertTrue(map.objectAt(new Vector2d(0,0)) instanceof Animal);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(0,0)) instanceof Grass);
    }
}
