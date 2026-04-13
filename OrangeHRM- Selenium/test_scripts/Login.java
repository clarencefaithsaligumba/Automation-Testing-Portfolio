package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class Login {

    WebDriver driver;

    @BeforeTest
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @DataProvider(name = "loginDetails")
    public Object[][] userPass(){
        return new Object[][]{
                {"Admin", "admin123"}
        };
    }

    @Test(dataProvider = "loginDetails")
    public void login(String userName, String passWord){

        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @AfterTest
    public void quit(){
        // driver.quit();
        System.out.println("Login Successfully!");
    }

}
