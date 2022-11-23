package agh.ics.oop;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class GrassFieldTest {
    @Test
    public void testEating(){
        List<MoveDirection> directions = OptionParser.parse(new String[]{"f","f","f"});
        GrassField map = new GrassField(1);
        Vector2d[] positions = { new Vector2d(0,0) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        assertTrue(map.objectAt(new Vector2d(0,0)) instanceof Animal);
        engine.run();
    }
}
