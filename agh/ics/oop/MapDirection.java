package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){
        switch(this){
            case NORTH -> {
                return "Północ";
            }
            case SOUTH -> {
                return "Południe";
            }
            case EAST -> {
                return "Wschód";
            }
            default -> {
                return "Zachód";
            }
        }
    }

    MapDirection next(){
        return switch(this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            default -> NORTH;
        };
    }

    MapDirection previous(){
        return switch(this){
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            default -> NORTH;
        };
    }

    Vector2d toUnitVector(){
        return switch(this){
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            default -> new Vector2d(1, 0);
        };
    }
}
