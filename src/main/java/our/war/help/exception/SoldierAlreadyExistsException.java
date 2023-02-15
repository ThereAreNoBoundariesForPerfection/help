package our.war.help.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SoldierAlreadyExistsException extends RuntimeException {

    public SoldierAlreadyExistsException(String message) {
        super(message);
    }
}
