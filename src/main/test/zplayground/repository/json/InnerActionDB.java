
package zplayground.repository.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import repository.InnerActionProto;

public class InnerActionDB implements InnerActionProto {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("subject")
    @Expose
    private String subject;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getSubjectKeyword() {
        return subject;
    }
}
