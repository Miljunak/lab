package agh.ics.oop;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    public ArrayList<Grass> grassPositions;
    private boolean isInside(ArrayList<Grass> field, Vector2d pos){
        for (Grass trawa : field) {
            if (trawa.getPosition().equals(pos)) return true;
        }
        return false;
    }
    public GrassField(int count){
        this.width = Integer.MAX_VALUE;
        this.height = Integer.MAX_VALUE;
        this.grassPositions = new ArrayList<>();
        for (int i = 0; i < count; i++){
            int r1 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
            int r2 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
            Vector2d pos = new Vector2d(r1, r2);
            while (isInside(grassPositions, pos)){
                r1 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
                r2 = ThreadLocalRandom.current().nextInt(0, (int) (sqrt(count*10) + 1));
                pos = new Vector2d(r1, r2);
            }
            grassPositions.add(new Grass(pos));
        }
        this.map = new ArrayList<>();
        this.visualizer = new MapVisualizer(this);
    }

    @Override
    public Vector2d getLower() {
        Vector2d lower = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (Animal animol : map) lower = animol.getPos().lowerLeft(lower);
        for (Grass grass : grassPositions) lower = grass.getPosition().lowerLeft(lower);
        return lower;
    }

    @Override
    public Vector2d getHigher() {
        Vector2d higher = new Vector2d(0,0);
        for (Animal animol : map) higher = animol.getPos().upperRight(higher);
        for (Grass grass : grassPositions) higher = grass.getPosition().upperRight(higher);
        return higher;
    }

    public void bruteForceGrass(Vector2d pos){
        grassPositions.add(new Grass(pos));
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animol : map) {
            if (animol.getPos().equals(position)) return true;
        }
        for (Grass grass : grassPositions) {
            if (grass.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animol : map) {
            if (animol.getPos().equals(position)) return animol;
        }
        for (Grass grass : grassPositions) {
            if (grass.getPosition().equals(position)) return grass;
        }
        return null;
    }
}
