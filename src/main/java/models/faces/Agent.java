package models.faces;

import java.util.List;

public interface Agent extends Evolvable {
    int id();

    String name();

    List<Behavior> behavior();

    void addBehavior(Behavior... behaviors);

    @Override
    default void evolve() {
        behavior().forEach(Actionable::act);
    }
}
