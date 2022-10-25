package agh.ics.oop;

public class Animal {
    private MapDirection dir;
    private final Vector2d pos;

    public Animal(){
        this.dir = MapDirection.NORTH;
        this.pos = new Vector2d(2,2);
    }

    @Override
    public String toString(){
        return "("+pos.x+","+pos.y+"), " + dir.toString();
    }

    public boolean isAt(Vector2d posistion){
        return pos.equals(posistion);
    }

    void move(MoveDirection direction){
        if(direction == MoveDirection.RIGHT) dir = dir.next();
        else if(direction == MoveDirection.LEFT) dir = dir.previous();
        else if(direction == MoveDirection.FORWARD){
            switch(dir){
                case EAST -> {
                    if (pos.x != 4) pos.x++;
                }
                case WEST -> {
                    if (pos.x != 0) pos.x--;
                }
                case NORTH -> {
                    if (pos.y != 4) pos.y++;
                }
                default -> {
                    if (pos.y != 0) pos.y--;
                }
            }
        }
        else{
            switch(dir){
                case EAST -> {
                    if (pos.x != 0) pos.x--;
                }
                case WEST -> {
                    if (pos.x != 4) pos.x++;
                }
                case NORTH -> {
                    if (pos.y != 0) pos.y--;
                }
                default -> {
                    if (pos.y != 4) pos.y++;
                }
            }
        }

    }
}
