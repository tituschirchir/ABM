package models.impls;

import models.faces.Agent;
import models.faces.Ecosystem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class FinancialEcosystem implements Ecosystem {
    private Queue<Agent> agentQueue = new ArrayDeque<>();

    @Override
    public void evolve() {
        agentQueue.forEach(Agent::evolve);
    }

    @Override
    public void addAgents(Agent... agents) {
        agentQueue.addAll(Arrays.asList(agents));
    }
}
