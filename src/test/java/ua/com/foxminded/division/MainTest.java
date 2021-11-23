package ua.com.foxminded.division;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    @Test
    public void printWarning() throws NumberFormatException {
        Main main = new Main();
        assertThrows(NumberFormatException.class, () -> {
            main.main(new String[]{"123"});
        });
    }
    @Test
    public void printDivisionTest() {
        Main main = new Main();
        main.main(new String[]{"1234", "5"});
    }
}
