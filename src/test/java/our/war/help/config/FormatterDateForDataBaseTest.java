package our.war.help.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FormatterDateForDataBaseTest {

    @MockBean
    private FormatterDateForDataBase formatterDateForDataBase;

    @BeforeEach
    void setUp() {
        formatterDateForDataBase = new FormatterDateForDataBase();
    }

    @AfterEach
    void tearDown() {
        formatterDateForDataBase = null;
    }

    @Test
    void formatterDefault() {
        LocalDateTime dateTime = LocalDateTime.of(2022, 10, 31, 15, 30, 45);
        String expected = "10 31, 2022 15:30:45";
        String actual = formatterDateForDataBase.formatterDefault(dateTime);
        assertEquals(expected, actual);
    }
}