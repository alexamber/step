package core.domain.keyword;

import java.util.Arrays;
import java.util.List;

/**
 * Created by AMBER on 25.12.2016.
 */
public abstract class KeyWord {

    public List<String> kWords() {
        return Arrays.asList(this.getClass().getAnnotation(Word.class).value());
    }

    public boolean is(final String keyWord) {
        return kWords().contains(keyWord);
    }
}
