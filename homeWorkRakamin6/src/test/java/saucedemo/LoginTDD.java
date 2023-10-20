package saucedemo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginTDD {
    @Test
    public void login_tdd() throws FileNotFoundException {
        WebDriver driver;
        String baseurl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();

        String csvDir = System.getProperty("user.dir")+"/src/test/data/test-data.csv";

        try(CSVReader reader = new CSVReader(new FileReader(csvDir))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null){
                String email = nextLine[0]; // Read column 1 for email
                String password = nextLine[1]; // Read column 2 for email
                String status = nextLine[2]; // Read column 3 for email

                // apply chrome setup
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.get(baseurl);

                driver.findElement(By.id("email")).sendKeys(email);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath("//button[@type='submit']")).click();

                if (status.equals("success")) { // Jika sukses
                    driver.findElement(By.xpath("//div[contains(text(), 'dashboard')]")).click();
                    String username = driver.findElement(By.xpath("//dd[contains(text(), 'hai')]/preceding-sibling::dt")).getText();
                    Assert.assertEquals(username, "tdd-selenium");
                } else { // Jika failed
                    String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
                    Assert.assertEquals(ErrorLogin, "Kredensial yang Anda berikan salah");
                }
//                driver.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
