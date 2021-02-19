package sweb.disi.unitn.it.validation;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UserValidator {

    final static Logger logger = LogManager.getLogger(UserValidator.class);

    private String userId;

    public UserValidator(String userId) {
        this.userId = userId;
    }

    public boolean isValid(String value) {
        logger.info("Validation! userid: " + this.userId);
        ReadContext ctx = JsonPath.parse(value);
        List<String> allUserId = ctx.read("$..userId");
        if (!allUserId.isEmpty())
            logger.info("body: " + allUserId.get(0).toString());
        return allUserId.stream().allMatch((s -> this.userId.equals(s)));
    }
}
