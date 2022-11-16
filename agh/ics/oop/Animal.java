package agh.ics.oop;

public class Animal {
    private MapDirection dir;
    private final Vector2d pos;
    private IWorldMap map;

    public Animal(){
        this.dir = MapDirection.NORTH;
        this.pos = new Vector2d(2,2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.dir = MapDirection.NORTH;
        this.map = map;
        this.pos = initialPosition;
    }

    public Vector2d getPos() {
        return pos;
    }

    @Override
    public String toString(){
        return Character.toString(dir.toString().charAt(0));
    }

    public boolean isAt(Vector2d posistion){
        return pos.equals(posistion);
    }

    void move(MoveDirection direction){
        if(direction == MoveDirection.RIGHT) dir = dir.next();
        else if(direction == MoveDirection.LEFT) dir = dir.previous();
        else {
            int changer = direction == MoveDirection.FORWARD ? 1 : -1;
            switch (dir) {
                case EAST -> {
                    if (map.canMoveTo(new Vector2d(pos.x + changer, pos.y))) {
                        map.removeAnimal(pos);
                        pos.x += changer;
                    }
                }
                case WEST -> {
                    if (map.canMoveTo(new Vector2d(pos.x - changer, pos.y))) {
                        map.removeAnimal(pos);
                        pos.x -= changer;
                    }
                }
                case NORTH -> {
                    if (map.canMoveTo(new Vector2d(pos.x, pos.y + changer))) {
                        map.removeAnimal(pos);
                        pos.y += changer;
                    }
                }
                default -> {
                    if (map.canMoveTo(new Vector2d(pos.x, pos.y - changer))) {
                        map.removeAnimal(pos);
                        pos.y -= changer;
                    }
                }
            }
            map.place(this);
        }
    }
}
