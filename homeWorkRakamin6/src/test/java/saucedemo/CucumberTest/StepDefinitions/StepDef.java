package saucedemo.CucumberTest.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDef {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";
    @Given("Halaman login sauce demo")
    public void halamanLoginSauceDemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        String loginPageAssert = driver.findElement(By.xpath("//div[@class='login_logo']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User is on products page")
    public void userIsOnProductsPage() {
        String halamanProduct = driver.findElement(By.xpath("//div[@class='app_logo']")).getText();
        Assert.assertEquals(halamanProduct, "Swag Labs");
    }

    @And("Input Invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("salahPass");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String ErrorLogin = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        Assert.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
    }

    @And("User pick one product")
    public void userPickOneProduct() {
        driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']")).click();
    }

    @And("User click add to cart")
    public void userClickAddToCart() {
        String clickAddToCart = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]")).getText();
        Assert.assertEquals(clickAddToCart, "Sauce Labs Backpack");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @Then("Button change to remove")
    public void buttonChangeToRemove() {
        String changeRemove = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        Assert.assertEquals(changeRemove, "Remove");
    }

    @And("User Click button remove")
    public void userClickButtonRemove() {
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    @Then("Button change to add to cart")
    public void buttonChangeToAddToCart() {
        String changeAddToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).getText();
//        System.out.println(changeAddToCart);
        Assert.assertEquals(changeAddToCart, "Add to cart");
    }

    @And("Click cart icon")
    public void clickCartIcon() {
        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
    }

    @Then("Appear list your cart")
    public void appearListYourCart() {
        String yourCart = driver.findElement(By.xpath("//span[@class='title']")).getText();
        System.out.println(yourCart);
        Assert.assertEquals(yourCart, "Your Cart");
    }

    @And("Click button checkout")
    public void clickButtonCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("Appear form your information")
    public void appearFormYourInformation() {
        String formYourInfo = driver.findElement(By.xpath("//span[@class='title']")).getText();
        System.out.println(formYourInfo);
        Assert.assertEquals(formYourInfo, "Checkout: Your Information");
    }

    @And("input first name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Bob");
    }

    @And("input last name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Maulana Adam");
    }

    @And("input postal code")
    public void inputPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("61214");
    }

    @And("click continue")
    public void clickContinue() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("Appear checkout overview")
    public void appearCheckoutOverview() {
        String formYourInfo = driver.findElement(By.xpath("//span[@class='title']")).getText();
        System.out.println(formYourInfo);
        Assert.assertEquals(formYourInfo, "Checkout: Overview");
    }

    @Then("Show error message")
    public void showErrorMessage() {
        String ErrorCheckout = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")).getText();
        System.out.println(ErrorCheckout);
        Assert.assertEquals(ErrorCheckout, "Error: Last Name is required");
    }
}
