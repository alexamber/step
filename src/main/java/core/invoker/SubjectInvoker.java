package core.invoker;

import core.domain.keyword.subject.Subject;

/**
 * Created by AMBER on 01.01.2017.
 */
public class SubjectInvoker extends KeyWordInvoker<Subject> {

    @Override
    public Subject invoke(final String keyword) {
        if (null == keyword)
            return null;
        try {
            return (Subject) getInvokedClass(keyword).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Sorry for that =)", e);
        }
    }
}
