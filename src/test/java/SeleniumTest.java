import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class SeleniumTest {

    @Test
    @DisplayName("Returns the ChromeDriver's options")
    void test1_options() {
        assertAll(() -> assertEquals(Selenium.options(), new ChromeOptions()),
                () -> assertEquals(Selenium.options(), Selenium.options()));
    }
    @Test
    void test2_options() {
        assertAll(() -> assertEquals(new ChromeOptions(), new ChromeOptions()),
                () -> assertEquals(Selenium.options(), Selenium.options()));
    }

    @Test
    @DisplayName("Main method")
    void test3_main() throws IOException {
        assertEquals(new String(Files.readAllBytes(Path.of(
                        "C:\\Users\\SiimM\\IdeaProjects\\Playtech\\output.txt"))),
                "Development QA Engineer (Intern) does not exist on the page");
    }

    @Test
    void test4_main() throws IOException {
        assertEquals(new String(Files.readAllBytes(Path.of(
                        "C:\\Users\\SiimM\\IdeaProjects\\Playtech\\output.txt"))),
                "Development QA Engineer (Intern) exists on the page");
    }
}