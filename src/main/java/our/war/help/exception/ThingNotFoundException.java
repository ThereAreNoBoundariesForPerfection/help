package our.war.help.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ThingNotFoundException extends Exception {

    public ThingNotFoundException(String message) {
        super(message);
    }
}
