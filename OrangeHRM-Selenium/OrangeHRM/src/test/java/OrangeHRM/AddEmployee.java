package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.security.Key;
import java.time.Duration;

public class AddEmployee {

    WebDriver driver;

    @BeforeTest
    public void setUp(){

        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @DataProvider(name = "employeeData")
    public Object[][] employeeInfo(){
        return new Object[][]{
                {"Simon", "Johns", "Cowell", "001", "Simon123", "Supersimon123"},
                {"Carl", "Ben", "Taylor", "002", "Carl123", "Supercarl123"},
                {"Zild", "Zep", "Bennitez", "003", "Zild123", "Superzild123"},
                {"Blaster", "Grimes", "Smith", "004", "Blaster123", "Superblaster123"},
                {"Lori", "Cherry", "Vic", "005", "Lori123", "Superlori123"}
        };
    }

    @Test (dataProvider = "employeeData")
    public void addMultipleEmployee(String fName, String mName, String lName, String empId, String userName, String passWord){

        // Go to the addEmployee page
        driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();


        // Add employee information
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-firstname']")).sendKeys(fName);
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-middlename']")).sendKeys(mName);
        driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active orangehrm-lastname']")).sendKeys(lName);

        // Clear the default value
        WebElement clear = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        clear.sendKeys(Keys.CONTROL + "a");
        clear.sendKeys(Keys.BACK_SPACE);
        clear.sendKeys(empId);

        // Click the create login details
        driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();

        // Add login details
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(userName);
        driver.findElement(By.xpath("(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[1]")).click();
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(passWord);
        driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(passWord);

        // Save
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Successfully added: " + fName + " " + mName + " " + lName);

    }

    @AfterTest
    public void quit(){
        //driver.quit();
        System.out.println("Added Successfully!");
    }

}
