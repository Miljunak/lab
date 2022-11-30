package agh.ics.oop;

import java.util.List;
import java.util.ArrayList;

/**
 * Class made for validating given input and returning it in form of MoveDirection ArrayList.
 * Throws an exception if one of the arguments is not valid.
 */

public class OptionParser {
    public static List<MoveDirection> parse(String[] arr) {
        List<MoveDirection> res = new ArrayList<>();
        for (String s : arr) {
            switch (s) {
                case "f", "forward" -> res.add(MoveDirection.FORWARD);
                case "b", "backward" -> res.add(MoveDirection.BACKWARD);
                case "l", "left" -> res.add(MoveDirection.LEFT);
                case "r", "right" -> res.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(s + " is not legal move specification");
            }
        }
        return res;
    }
}