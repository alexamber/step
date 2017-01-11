package core.invoker;

import core.domain.keyword.action.AtomicAction;

/**
 * Created by AMBER on 01.01.2017.
 */
public class AtomicActionInvoker extends KeyWordInvoker<AtomicAction> {
    @Override
    public AtomicAction invoke(final String keyword) {
        try {
            return (AtomicAction) getInvokedClass(keyword).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Sorry for that =)", e);
        }
    }
}
