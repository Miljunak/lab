package agh.ics.oop;

public class World {

    public static void main(String[] args) {

        System.out.println("system wystartował");

        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,3);
        MapDirection dir1 = MapDirection.NORTH;
        System.out.println(dir1.next().toUnitVector());



        /*

        Scanner myObj = new Scanner(System.in);
        String tester1 = (myObj.nextLine()).replaceAll("\\s+","");
        Direction[] tester2 = new Direction[tester1.length()];

        for ( int i = 0 ; i < tester1.length(); i++ ){
            tester2[i] = switch (tester1.charAt(i)) {
                case 'f' -> Direction.FORWARD;
                case 'b' -> Direction.BACKWARD;
                case 'r' -> Direction.RIGHT;
                default -> Direction.LEFT;
            };
        }

        //run(tester2);

         */

        System.out.println("system zakończył działanie");
    }

    public static void run(MoveDirection[] dirs){
        System.out.println("Start");

        for (MoveDirection dir : dirs) {
            switch(dir){
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tylu");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
            }
        }

        System.out.println("Stop");
    }
}