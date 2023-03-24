import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium {
    public static void main(String[] args) throws IOException {
        playtechInternship();
    }

    public static void playtechInternship() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SiimM\\Desktop\\ajutine\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver(options());
        try {
            driver.manage().window().maximize();
            driver.get("https://www.playtech.ee");

            //Clicks on tab with coordinates
            Actions action = new Actions(driver);
            WebElement internship = driver.findElement(By.linkText("INTERNSHIP"));
            int x = internship.getLocation().getX();
            int y = internship.getLocation().getY();
            action.moveByOffset(x+1, y+1).click();
            action.build().perform();

            verification(driver, "Development QA Engineer (Intern)",
                    "Development QA Engineer (Intern) exists on the page",
                    "Development QA Engineer (Intern) does not exist on the page");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

    /**
     * Gives the ChromeOptions the proper options
     * @return options
     */

    public static ChromeOptions options() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

    /**
     * Checks if a button with a link text of the parameter text is found and displayed on a website
     * @param driver - ChromeDriver
     * @param text - link text
     * @return boolean
     */

    public static boolean check_if_visible(ChromeDriver driver, String text) {
        List<WebElement> buttons = driver.findElements(By.linkText(text));
        return buttons.size() > 0 && buttons.get(0).isDisplayed();
    }

    /**
     * Verifies if a button is displayed on a website with a link text of the parameter text
     * and writes parameter displayed or notDisplayed in a text file
     * @param driver - ChromeDriver
     * @param text - link text
     * @param displayed - if button is visible, writes this in the file
     * @param notDisplayed - if button is not visible, writes this in the file
     * @throws IOException
     */

    public static void verification(ChromeDriver driver, String text, String displayed, String notDisplayed) throws IOException {
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(check_if_visible(driver, text)
                    ? displayed
                    : notDisplayed);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}