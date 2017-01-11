package core.invoker;

import java.util.List;

import core.domain.keyword.action.Action;
import core.domain.keyword.action.ComplexAction;
import core.domain.keyword.subject.Subject;
import repository.ActionDataProvider;
import repository.ActionProto;
import repository.InnerActionProto;

/**
 * Created by AMBER on 01.01.2017.
 */
public class ComplexActionInvoker extends KeyWordInvoker<ComplexAction> {
    private ActionDataProvider actionDataProvider;
    private SubjectInvoker subjectInvoker = new SubjectInvoker();
    private AtomicActionInvoker atomicActionInvoker = new AtomicActionInvoker();

    public ComplexActionInvoker(final ActionDataProvider actionDataProvider) {
        this.actionDataProvider = actionDataProvider;
    }

    @Override
    public ComplexAction invoke(final String keyword) {
        ActionProto actionProto = actionDataProvider.getAction(keyword);
        List<InnerActionProto> innerActionsProto = actionProto.getInnerActions();
        ComplexAction action;
        try {
            action = ComplexAction.class.getDeclaredConstructor().newInstance();
            for (InnerActionProto innerActionProto : innerActionsProto) {
                Action innerAction;
                ActionProto actionProtoInner = actionDataProvider.getAction(innerActionProto.getId());
                String innerActionKeyword = actionProtoInner.getKeyword();
                switch (actionProtoInner.getType()) {
                case ATOMIC:
                    innerAction = atomicActionInvoker.invoke(innerActionKeyword);
                    Subject innerSubject = subjectInvoker.invoke(innerActionProto.getSubjectKeyword());
                    innerAction.setSubject(innerSubject);
                    break;
                case COMPLEX:
                    innerAction = this.invoke(innerActionKeyword);
                    break;
                default:
                    throw new RuntimeException("SorryForThat =)");
                }
                action.addAction(innerAction);
            }
            return action;
        } catch (Exception e) {
            throw new RuntimeException("Sorry for that =)", e);
        }
    }
}
