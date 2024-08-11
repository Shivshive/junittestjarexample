package bambooSpec;

import com.atlassian.bamboo.specs.api.builders.Variable;

public class BambooConstant {
    public static Variable[] variables(){
        return new Variable[]{
                new Variable("tags","@Test"),
                new Variable("runner","junit"),
                new Variable("env","SQI"),
        };
    }
}
