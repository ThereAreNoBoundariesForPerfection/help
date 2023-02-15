package our.war.help.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorDetails {
    private final HttpStatus httpStatus;
    private final String message;
    private final String details;
}
