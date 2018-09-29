package models.faces;

import java.util.concurrent.Callable;

public interface Evolvable extends Callable<Evolvable> {
    void evolve();

    @Override
    default Evolvable call() {
        evolve();
        return this;
    }
}
