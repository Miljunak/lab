package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    List<Animal> animals = new ArrayList<>();
    public List<MoveDirection> moves;
    public IWorldMap map;

    public SimulationEngine(List<MoveDirection> moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        for(Vector2d pos: positions) {
            if (map.canMoveTo(pos)) {
                animals.add(new Animal(this.map, pos));
                this.map.place(animals.get(animals.size() - 1));
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < moves.size(); i++){
            Animal curr = animals.get(i% animals.size());
            System.out.println(map);
            System.out.println(moves.get(i));
            curr.move(moves.get(i));
        }
        System.out.println(map);
    }
}
