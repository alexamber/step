package core.domain.keyword.action;

import core.domain.keyword.KeyWord;
import core.domain.keyword.role.Role;
import core.domain.keyword.subject.Subject;
import core.domain.step.parameters.Parameters;

/**
 * Created by AMBER on 02.01.2017.
 */
public abstract class Action extends KeyWord {
    private Role role;
    private Subject subject;
    private Parameters parameters;

    public abstract void act();

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(final Subject subject) {
        this.subject = subject;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(final Parameters parameters) {
        this.parameters = parameters;
    }
}
