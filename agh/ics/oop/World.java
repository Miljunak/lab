package agh.ics.oop;
import java.util.Scanner;

public class World {

    public static void main(String[] args) {

        System.out.println("system wystartował");

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

        run(tester2);

        System.out.println("system zakończył działanie");
    }

    public static void run(Direction[] dirs){
        System.out.println("Start");

        for (Direction dir : dirs) {
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