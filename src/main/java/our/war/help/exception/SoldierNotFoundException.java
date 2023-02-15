package our.war.help.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SoldierNotFoundException extends Exception {

    public SoldierNotFoundException(String message) {
        super(message);
    }
}
