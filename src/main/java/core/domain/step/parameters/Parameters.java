package core.domain.step.parameters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AMBER on 26.12.2016.
 */
public class Parameters {
    public Map<String, String> parameters = new HashMap<>();

    public Parameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Map<String, String> get() {
        return parameters;
    }
}
