package core.domain.step;

import core.domain.keyword.action.Action;
import core.domain.keyword.role.Role;
import core.domain.keyword.subject.Subject;
import core.domain.step.parameters.Parameters;

/**
 * Created by AMBER on 27.12.2016.
 */
public class Step {
    Role role;
    Action action;
    Subject subject;
    Parameters parameters;

    public Step(final Role role, final Action action, final Subject subject, final Parameters parameters) {
        this.role = role;
        this.subject = subject;
        this.parameters = parameters;
        this.action = action;
        action.setRole(role);
        action.setSubject(subject);
        action.setParameters(parameters);
    }

    public void perform() {
        action.act();
    }
}
