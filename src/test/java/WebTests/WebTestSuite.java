package WebTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTestSuite {

    private static WebDriver driver;

    @BeforeAll
    public static void Setup() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver102\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @BeforeEach
    public void Start() {
        driver.get("https://d3udduv23dv8b4.cloudfront.net/#/");
    }

    @AfterAll
    public static void Quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void ContactPageTest() {
        //Arrange
        WebElement contactForm = driver.findElement(By.cssSelector("[aria-label='contact']"));
        //Act
        contactForm.click();
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("xxx");
        WebElement tel=driver.findElement(By.id("telephone"));
        tel.sendKeys("xxx");
        List<WebElement> btnList =driver.findElements(By.tagName("a"));
        WebElement button=null;
        for (WebElement btn : btnList)
        {
            if(btn.getText().equals("SUBMIT"))
            {
                button=btn;
            }
        }button.click();


        //Assert
        String expEmailErr="Email is invalid";
        WebElement actErr=driver.findElement(By.id("email-err"));
        Assertions.assertEquals(expEmailErr,actErr.getText());

        String expTelError="Telephone is invalid";
        WebElement actTelErr=driver.findElement(By.id("telephone-err"));
        Assertions.assertEquals(expTelError,actTelErr.getText());

        //Act
        for (WebElement btn : btnList)
        {
            if(btn.getText().equals("CLEAR"))
            {
                button=btn;
            }
        }button.click();

        //Assert
        // Check the err-email and err-telephone isEnabled or isDispayed()
        //Assert if its empty.







    }
    @Test
    public void MenuPageTest()
    {
        //Arrange
        WebElement menuForm = driver.findElement(By.cssSelector("[aria-label='menu']"));
        //Act
        menuForm.click();
        List<WebElement> menuList = driver.findElements(By.className("v-tab"));
        WebElement menuT = null;
        for (WebElement menus : menuList)
        {
            // looping through the item to get the sides and then click on the side
        }




    }
    //Act
    //Get all the tile of the sides
    //get the price and the kilojule
    //assert the price and kilojules.

    //Assert


}






