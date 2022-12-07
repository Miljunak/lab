package agh.ics.oop;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SimulationEngine implements IEngine, Runnable {

    List<Animal> animals = new ArrayList<>();
    public List<MoveDirection> moves;
    public GrassField map;

    public SimulationEngine(List<MoveDirection> moves, GrassField map, Vector2d[] positions ){
        this.moves = moves;
        this.map = map;
        for(Vector2d pos: positions) {
            animals.add(new Animal(this.map, pos));
            this.map.place(animals.get(animals.size() - 1));
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < moves.size(); i++) {
            Animal curr = animals.get(i%animals.size());
            System.out.println(map);
            System.out.println(moves.get(i));
            curr.move(moves.get(i));
        }
        System.out.println(map);
    }
}
