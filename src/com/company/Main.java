package com.company;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/User/Downloads/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Mazimize current window
        driver.manage().window().maximize();

        //Go to Best Sellers Tab
        driver.get("http://automationpractice.com/index.php");
        WebElement bestsellers = driver.findElement(By.className("blockbestsellers"));
        bestsellers.click();

        //Add an item to cart
        driver.get("http://automationpractice.com/index.php?controller=cart&add=1&id_product=7&token=e817bb0705dd58da8db074c69f729fd8");

        //Go back to continue shopping
        WebElement Cont = driver.findElement(By.xpath("//a[@title='Continue shopping']"));
        Cont.click();

        //Now go to Women Tab
        WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));
        women.click();

        //Delay execution for 2 seconds
        //try ... catch ... was suggested by Selenium for operation!
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Locating the shirt we want
        WebElement shirt = driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']"));
        //Instantiating Actions class
        Actions actions = new Actions(driver);
        //Hovering on the shirt
        actions.moveToElement(shirt);
        // Locating the Add To Cart button from Sub Menu
        WebElement subMenu = driver.findElement(By.xpath("//a[@title='Add to cart']"));
        //To mouseover on sub menu
        actions.moveToElement(subMenu);
        //build()- used to compile all the actions into a single step
        actions.click().build().perform();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Move to Cart
        driver.get("http://automationpractice.com/index.php?controller=order");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Continue to checkout
        driver.get("http://automationpractice.com/index.php?controller=order&step=1");

         /*THIS SECTION IS FOR CREATING A NEW ACCOUNT!

        WebElement email = driver.findElement(By.id("email_create"));
        email.sendKeys("mynewemail@yahoo.com");
        WebElement create = driver.findElement(By.id("SubmitCreate"));
        create.click();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Register a new account
        WebElement radiobutton = driver.findElement(By.id("id_gender2"));
        radiobutton.click();

        WebElement fname = driver.findElement(By.id("customer_firstname"));
        fname.sendKeys("My New");
        WebElement lname = driver.findElement(By.id("customer_lastname"));
        lname.sendKeys("Email");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("123456789");

        //Toggle-drop down menu selector
        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByValue("1");
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByValue("4");
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByValue("1990");

        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("767 5th Ave");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("New York");
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByVisibleText("New York");
        WebElement zip = driver.findElement(By.id("postcode"));
       zip.sendKeys("10153");
        WebElement phone = driver.findElement(By.id("phone_mobile"));
        phone.sendKeys("212-336-1440");

        WebElement register = driver.findElement(By.id("submitAccount"));
        register.click();

        END REGISTERING SECTION*/

        WebElement newemail = driver.findElement(By.id("email"));
        newemail.sendKeys("mynewemail@yahoo.com");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("123456789");
        WebElement submit = driver.findElement(By.id("SubmitLogin"));
        submit.click();

        WebElement proceed = driver.findElement(By.name("processAddress"));
        proceed.click();

        WebElement term = driver.findElement(By.id("cgv"));
        term.click();
        WebElement proceed2 = driver.findElement(By.name("processCarrier"));
        proceed2.click();

        WebElement bankwire = driver.findElement(By.className("bankwire"));
        bankwire.click();

        //xpath method
        //driver.findElement(By.xpath("//button[contains(@class, 'button-medium')]")).click();

        //CSS Selector method
        driver.findElement(By.cssSelector("button.button-medium")).click();

        /*driver.quit();*/
    }
}

