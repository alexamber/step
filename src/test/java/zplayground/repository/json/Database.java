
package zplayground.repository.json;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import repository.ActionDataProvider;

public class Database implements ActionDataProvider {

    @SerializedName("actions")
    @Expose
    private List<ActionDB> actionDBs = null;

    public static Database getFrom(final File file) {
        try {
            return new Gson().fromJson(new String(Files.readAllBytes(file.toPath())), Database.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<ActionDB> getActions() {
        return actionDBs;
    }

    @Override
    public ActionDB getAction(final long id) {
        return actionDBs.stream().filter(a -> a.getId() == id).findFirst()
                .orElseThrow(() -> new RuntimeException("NoSuchInnerAction " + id));
    }

    @Override
    public ActionDB getAction(final String keyWord) {
        return actionDBs.stream().filter(a -> a.getKeyword().toLowerCase().equals(keyWord.toLowerCase())).findFirst()
                .orElseThrow(() -> new RuntimeException("NoSuchAction " + keyWord));
    }

}
