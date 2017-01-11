package repository;

import java.util.List;

import core.domain.keyword.action.ActionType;

/**
 * Created by AMBER on 12.01.2017.
 */
public interface ActionProto {
    long getId();

    String getKeyword();

    <T extends InnerActionProto> List<T> getInnerActions();

    ActionType getType();
}
