package zplayground.actions;

import core.domain.keyword.action.AtomicAction;

/**
 * Created by AMBER on 02.01.2017.
 */
public class AA extends AtomicAction {

    @Override
    public void act() {
        System.out.println(getRole().getClass().getSimpleName() + getClass().getSimpleName()
                + (getSubject() != null ? getSubject().getClass().getSimpleName() : "NULL")
                + (getParameters() != null ? getParameters().get() : "NULL_PARS"));
    }
}
