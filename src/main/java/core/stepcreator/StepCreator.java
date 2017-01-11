package core.stepcreator;

import java.util.HashMap;
import java.util.Map;

import core.domain.keyword.action.Action;
import core.domain.keyword.role.Role;
import core.domain.keyword.subject.Subject;
import core.domain.step.Step;
import core.domain.step.parameters.Parameters;
import core.invoker.AtomicActionInvoker;
import core.invoker.ComplexActionInvoker;
import core.invoker.RoleInvoker;
import core.invoker.SubjectInvoker;
import repository.ActionDataProvider;
import repository.ActionProto;

/**
 * Created by AMBER on 30.12.2016.
 */
public class StepCreator {
    private ActionDataProvider actionDataProvider;

    public StepCreator(ActionDataProvider actionDataProvider) {
        this.actionDataProvider = actionDataProvider;
    }

    public Step createStep(final String stepString) {
        String[] keyWords = stepString.split("\\+");
        String roleStr = keyWords[0];
        String actionStr = keyWords[1];
        String subjectStr = keyWords.length > 2 ? keyWords[2] : null;
        ActionProto actionDB = actionDataProvider.getAction(actionStr);

        Subject subject = new SubjectInvoker().invoke(subjectStr);
        Role role = new RoleInvoker().invoke(roleStr);
        Action action;
        switch (actionDB.getType()) {
        case ATOMIC:
            action = new AtomicActionInvoker().invoke(actionStr);
            break;
        case COMPLEX:
            action = new ComplexActionInvoker(actionDataProvider).invoke(actionStr);
            break;
        default:
            throw new RuntimeException("Sorry=)");
        }
        // TODO implement mech to work with parameters
        Map<String, String> pars = new HashMap<>();
        pars.put("par1", stepString);
        Parameters parameters = new Parameters(pars);
        return new Step(role, action, subject, parameters);
    }
}
