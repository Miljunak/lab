package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        String[] args = getParameters().getRaw().toArray(new String[0]);
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };

        try {
            List<MoveDirection> directions = OptionParser.parse(args);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException e) { System.out.println("> " + e.getMessage()); }

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid, 500, 500);
        map.genMap(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
