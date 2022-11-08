package agh.ics.oop;

public class RectangularMap implements IWorldMap {
    public int width, height;
    public Object[][] mapka;
    public MapVisualizer visualizer;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.mapka = new Object[width][height];
        this.visualizer = new MapVisualizer(this);
    }

    public String toString(){
        return visualizer.draw(new Vector2d(0,0), new Vector2d(this.width - 1, this.height - 1));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if ((position.x >= 0 && position.y >= 0) && (position.x < this.width && position.y < this.height)){
            return this.mapka[position.x][position.y] == null;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d curr = animal.getPos();
        if (mapka[curr.x][curr.y] == null){
            this.mapka[curr.x][curr.y] = animal;
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if ((position.x >= 0 && position.y >= 0) && (position.x < this.width && position.y < this.height)){
            return this.mapka[position.x][position.y] != null;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if ((position.x >= 0 && position.y >= 0) && (position.x < this.width && position.y < this.height)){
            return this.mapka[position.x][position.y];
        }
        return null;
    }

    @Override
    public void removeAnimal(Vector2d position){
        this.mapka[position.x][position.y] = null;
    }
}
