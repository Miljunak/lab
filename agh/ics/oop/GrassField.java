package agh.ics.oop;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    public HashMap<Vector2d, Grass> grassPositions;
    public int count;
    public MapBoundary boundary;
    private Vector2d randomGrassSpawner(){
        int r1 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
        int r2 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
        Vector2d pos = new Vector2d(r1, r2);
        while (grassPositions.get(pos) != null || map.get(pos) != null){
            r1 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
            r2 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
            pos = new Vector2d(r1, r2);
        }
        grassPositions.put(pos, new Grass(pos));
        return pos;
    }
    public GrassField(int count){
        this.width = Integer.MAX_VALUE;
        this.height = Integer.MAX_VALUE;
        this.count = count;
        this.grassPositions = new HashMap<>();
        this.map = new HashMap<>();
        for (int i = 0; i < count; i++) randomGrassSpawner();
        this.visualizer = new MapVisualizer(this);
        this.boundary = new MapBoundary(grassPositions);
    }

    public void genMap(GridPane grid) {

        int lowerX = boundary.lowerBoundary().x;
        int lowerY = boundary.lowerBoundary().y;
        int higherX = boundary.upperBoundary().x;
        int higherY = boundary.upperBoundary().y;

        grid.getColumnConstraints().add(new ColumnConstraints(25));
        grid.getRowConstraints().add(new RowConstraints(25));
        grid.add(new Label("y \\ x"), 0, 0);

        for (int i = 0; i < higherX - lowerX + 1; i++ ) {
            Label label = new Label(Integer.toString(lowerX + i));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, i + 1, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(25));
        }

        for (int i = 0; i < higherY - lowerY + 1; i++ ) {
            Label label = new Label(Integer.toString(lowerY + i));
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, 0, higherY - lowerY - i + 1);
            grid.getRowConstraints().add(new RowConstraints(25));
        }

        for (Vector2d key: grassPositions.keySet()) {
            Grass grass = grassPositions.get(key);
            Label label = new Label(grass.toString());
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, key.x - lowerX + 1,higherY - key.y + 1);
        }

        for(Vector2d key: map.keySet()) {
            Animal animal = map.get(key);
            Label label = new Label(animal.toString());
            GridPane.setHalignment(label, HPos.CENTER);
            grid.add(label, key.x - lowerX + 1,higherY - key.y + 1);
        }
    }

    @Override
    public boolean place(Animal animal) {
        animal.addObserver(boundary);
        return super.place(animal);
    }

    @Override
    public Vector2d getLower() { return boundary.lowerBoundary(); }

    @Override
    public Vector2d getHigher() { return boundary.upperBoundary(); }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (super.isOccupied(position) || grassPositions.get(position) != null);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) return super.objectAt(position);
        return grassPositions.get(position);
    }

    /**
     * positionChanged not only informs map about changes but also removes grass that the animal
     * may have stepped on during last move, also spawns another grass if needed.
     */
    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos) {
        super.positionChanged(oldPos, newPos);
        if (grassPositions.get(newPos) != null && count != 0) {
            boundary.insertObject(randomGrassSpawner());
            //System.out.println(grasspos);
            //System.out.println(boundary.ListX);
            //System.out.println(boundary.ListY);
            grassPositions.remove(newPos);
        }
    }
}
