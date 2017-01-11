
package zplayground.repository.json;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import core.domain.keyword.action.ActionType;
import repository.ActionProto;

public class ActionDB implements ActionProto {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("inner.action")
    @Expose
    private List<InnerActionDB> actions = null;

    public long getId() {
        return id;
    }

    public ActionType getType() {
        return ActionType.valueOf(type);
    }

    public String getKeyword() {
        return keyword;
    }

    public List<InnerActionDB> getInnerActions() {
        return actions;
    }

}
