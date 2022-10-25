package agh.ics.oop;

import java.util.List;

public class World {
    public static void main(String[] args) {

        System.out.println("system wystartował");

        Animal futrzak = new Animal();
        System.out.println(futrzak);
        List<MoveDirection> moves = OptionParser.parse(args);
        for(MoveDirection ruch: moves) futrzak.move(ruch);
        System.out.println(futrzak);
        String testerka = String.valueOf(futrzak);
        System.out.println(testerka.contains("(1,4)"));

        //Implementacja dzialania, ktore nie dopuscilo by do spotkania sie 2 zwierzat na jednym polu
        //polega na trzymaniu danych na temat wszystkich zwierzat w liscie (lepiej w macierzy oznaczajac 0 lub 1)
        //Gdy nastepuje ruch to poprostu sprawdzic w czasie n dla listy lub czasie stalym dla macierzy czy pole jest
        //zajete czy juz nie.

        System.out.println("system zakończył działanie");
    }
}