package core.invoker;

import core.domain.keyword.role.Role;

/**
 * Created by AMBER on 01.01.2017.
 */
public class RoleInvoker extends KeyWordInvoker<Role> {
    @Override
    public Role invoke(final String keyword) {
        try {
            return (Role) getInvokedClass(keyword).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Sorry for that =)", e);
        }
    }
}
