package mysleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SomeUtil {
    private Logger log = LoggerFactory.getLogger(SomeUtil.class);

    public String getUserName(String userId) {
        log.info("getUserName - " + userId);
        return "some user name";
    }
}
