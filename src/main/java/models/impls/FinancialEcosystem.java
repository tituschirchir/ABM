package models.impls;

import models.faces.Agent;
import models.faces.Ecosystem;
import units.TimeKeeper;

import java.time.DayOfWeek;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FinancialEcosystem implements Ecosystem {
    private Queue<Agent> agentQueue = new ArrayDeque<>();

    @Override
    public void evolve() {
        TimeKeeper.getInstance().evolve();
        DayOfWeek dayOfWeek = TimeKeeper.dateTime().getDayOfWeek();
        if (DayOfWeek.SATURDAY != dayOfWeek && DayOfWeek.SUNDAY != dayOfWeek)
            agentQueue.forEach(Agent::evolve);
    }

    @Override
    public void addAgents(Agent... agents) {
        agentQueue.addAll(Arrays.asList(agents));
    }
}
