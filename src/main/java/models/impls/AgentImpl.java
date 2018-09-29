package models.impls;

import models.faces.Agent;
import models.faces.Behavior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AgentImpl implements Agent {
    private static int id = 0;
    private final String name;
    private List<Behavior> behavior = new ArrayList<>();
    private int agt_id;

    public AgentImpl(String name_) {
        name = name_;
        agt_id = id++;
    }

    @Override
    public int id() {
        return agt_id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public List<Behavior> behavior() {
        return behavior;
    }

    @Override
    public void addBehavior(Behavior... behaviors) {
        this.behavior.addAll(Arrays.asList(behaviors));
    }
}
