package our.war.help.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ThingAlreadyExistsException extends RuntimeException {

    public ThingAlreadyExistsException(String message) {
        super(message);
    }
}
