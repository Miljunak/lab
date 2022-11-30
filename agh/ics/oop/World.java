package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.List;

public class World {
    public static void main(String[] args) {

        /*
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        try {
            List<MoveDirection> directions = OptionParser.parse(args);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException e) { System.out.println("> " + e.getMessage()); }
         */

        Application.launch(App.class, args);
    }
}