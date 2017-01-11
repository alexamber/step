package core.domain.keyword.action;

import java.util.ArrayList;
import java.util.List;

import core.domain.keyword.role.Role;
import core.domain.step.parameters.Parameters;

/**
 * Created by AMBER on 25.12.2016.
 */
public class ComplexAction extends Action {

    private List<Action> actions = new ArrayList<>();

    public List<Action> getActions() {
        return actions;
    }

    public void addAction(final Action action) {
        actions.add(action);
    }

    public void act() {
        System.out.println(getRole().getClass().getSimpleName() + getClass().getSimpleName());
        System.out.println("***");
        actions.forEach(a -> a.act());
        System.out.println("***");
    }

    @Override
    public void setRole(final Role role) {
        super.setRole(role);
        actions.forEach(a -> a.setRole(role));
    }

    @Override
    public void setParameters(final Parameters parameters) {
        super.setParameters(parameters);
        actions.forEach(a -> a.setParameters(parameters));
    }

}
