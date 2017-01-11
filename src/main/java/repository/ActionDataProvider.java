package repository;

import java.util.List;

/**
 * Created by AMBER on 02.01.2017.
 */
public interface ActionDataProvider {
    <T extends ActionProto> T getAction(final String keyword);

    <T extends ActionProto> T getAction(final long id);

    <T extends ActionProto> List<T> getActions();
}
