package our.war.help.config;

import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class FormatterDateForDataBase {

    public String formatterDefault(LocalDateTime localDateTime) {
        DateTimeFormatter dTF = DateTimeFormatter.ofPattern("MM dd, uuu HH:mm:ss");
        return dTF.format(localDateTime);
    }

}
