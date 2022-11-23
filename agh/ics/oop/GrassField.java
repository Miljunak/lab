package agh.ics.oop;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    public HashMap<Vector2d, Grass> grassPositions;
    public int count;
    private void randomGrassSpawner(){
        int r1 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
        int r2 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
        Vector2d pos = new Vector2d(r1, r2);
        while (grassPositions.get(pos) != null || map.get(pos) != null){
            r1 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
            r2 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
            pos = new Vector2d(r1, r2);
        }
        grassPositions.put(pos, new Grass(pos));
    }
    public GrassField(int count){
        this.width = Integer.MAX_VALUE;
        this.height = Integer.MAX_VALUE;
        this.count = count;
        this.grassPositions = new HashMap<>();
        this.map = new HashMap<>();
        for (int i = 0; i < count; i++) randomGrassSpawner();
        this.visualizer = new MapVisualizer(this);
    }

    @Override
    public Vector2d getLower() {
        Vector2d lower = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animal : map.values()) lower = animal.getPos().lowerLeft(lower);
        for (Grass grass : grassPositions.values()) lower = grass.getPosition().lowerLeft(lower);
        return lower;
    }

    @Override
    public Vector2d getHigher() {
        Vector2d higher = new Vector2d(0,0);
        for (Animal animal : map.values()) higher = animal.getPos().upperRight(higher);
        for (Grass grass : grassPositions.values()) higher = grass.getPosition().upperRight(higher);
        return higher;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (super.isOccupied(position) || grassPositions.get(position) != null);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) return super.objectAt(position);
        return grassPositions.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPos, Vector2d newPos) {
        super.positionChanged(oldPos, newPos);
        if (grassPositions.get(newPos) != null && count != 0) {
            randomGrassSpawner();
            grassPositions.remove(newPos);
        }
    }
}
