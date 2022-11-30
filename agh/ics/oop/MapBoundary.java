package agh.ics.oop;

import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    public ArrayList<Vector2d> ListX;
    public ArrayList<Vector2d> ListY;
    public MapBoundary(HashMap<Vector2d, Grass> grassPositions){

        this.ListX = new ArrayList<>();
        for (Vector2d key: grassPositions.keySet()) ListX.add(grassPositions.get(key).getPos());
        ListX.sort(Comparator.comparingInt(a -> a.x));

        this.ListY = new ArrayList<>();
        for (Vector2d key: grassPositions.keySet()) ListY.add(grassPositions.get(key).getPos());
        ListY.sort(Comparator.comparingInt(a -> a.y));
    }

    public void insertObject(Vector2d item) {

        boolean foundX = false, foundY = false;

        for ( int i = 0; i < ListX.size(); i++ ) {
            Vector2d curr = ListX.get(i);
            if (item.x < curr.x) {
                ListX.add(i, item);
                foundX = true;
                break;
            }
        }
        if (!foundX) ListX.add(ListX.size(), item);

        for ( int i = 0; i < ListY.size(); i++ ) {
            Vector2d curr = ListY.get(i);
            if (item.y < curr.y) {
                ListY.add(i, item);
                foundY = true;
                break;
            }
        }
        if (!foundY) ListY.add(ListY.size(), item);
    }

    public Vector2d upperBoundary() {
        return new Vector2d(ListX.get(ListX.size() - 1).x, ListY.get(ListY.size() - 1).y);
    }

    public Vector2d lowerBoundary() {
        return new Vector2d(ListX.get(0).x, ListY.get(0).y);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {

        for ( int i = 0; i < ListX.size(); i++ ) {
            Object curr = ListX.get(i);
            if (newPosition.equals(curr)) ListX.remove(i);
            if (oldPosition.equals(curr)) ListX.remove(i);
        }
        for ( int i = 0; i < ListY.size(); i++ ) {
            Object curr = ListY.get(i);
            if (newPosition.equals(curr)) ListY.remove(i);
            if (oldPosition.equals(curr)) ListY.remove(i);
        }
        insertObject(newPosition);
    }
}
