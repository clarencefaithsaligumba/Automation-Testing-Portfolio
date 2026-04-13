package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;

public class UpdatePersonalDetails {

    WebDriver driver;

    @BeforeTest
    public void setupBrowser(){
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }


    @Test
    public void updatePersonalInfo(){
        driver.findElement(By.xpath("//a[contains(@href, 'viewMyDetails')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Update employee full name
        WebElement first = driver.findElement(By.xpath("//input[contains(@name, 'firstName')]"));
        first.sendKeys(Keys.CONTROL + "a");
        first.sendKeys(Keys.BACK_SPACE);
        first.sendKeys("Mary");
        WebElement middle = driver.findElement(By.xpath("//input[contains(@name, 'middleName')]"));
        middle.sendKeys(Keys.CONTROL + "a");
        middle.sendKeys(Keys.BACK_SPACE);
        middle.sendKeys("Elizabeth");
        WebElement last = driver.findElement(By.xpath("//input[contains(@name, 'lastName')]"));
        last.sendKeys(Keys.CONTROL + "a");
        last.sendKeys(Keys.BACK_SPACE);
        last.sendKeys("Johnson");

        // Nickname
        WebElement nickName = driver.findElement(By.xpath("(//div[contains(@class,'input-group')]//input)[4]"));
        nickName.sendKeys(Keys.CONTROL + "a");
        nickName.sendKeys(Keys.BACK_SPACE);
        nickName.sendKeys("May");

        // Update employee id
        WebElement employeeId = driver.findElement(By.xpath("(//div[contains(@class,'input-group')]//input)[5]"));
        employeeId.sendKeys(Keys.CONTROL + "a");
        employeeId.sendKeys(Keys.BACK_SPACE);
        employeeId.sendKeys("mJohnson");;
        WebElement otherId = driver.findElement(By.xpath("(//div[contains(@class,'input-group')]//input)[6]"));
        otherId.sendKeys(Keys.CONTROL + "a");
        otherId.sendKeys(Keys.BACK_SPACE);
        otherId.sendKeys("3001");

        // Driver's License
        WebElement number = driver.findElement(By.xpath("(//div[contains(@class, 'oxd-input')]//input)[7]"));
        number.sendKeys(Keys.CONTROL + "a");
        number.sendKeys(Keys.BACK_SPACE);
        number.sendKeys("789456123");

        WebElement expDate = driver.findElement(By.xpath("(//input[contains(@placeholder, 'yyyy-dd-mm')])[1]"));
        expDate.sendKeys(Keys.CONTROL + "a");
        expDate.sendKeys(Keys.BACK_SPACE);
        expDate.sendKeys("2029-05-08");

        // Nationality
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='oxd-select-option'])[193]")).click();

        // Marital Status
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")).click();
        driver.findElement(By.xpath("(//div[@class='oxd-select-option'])[2]")).click();

        // Date of birth
        driver.findElement(By.xpath("(//i[contains(@class, 'oxd-icon bi-calendar')])[2]")).click();
        // Month
        driver.findElement(By.xpath("//li[@class='oxd-calendar-selector-month']")).click();
        driver.findElement(By.xpath("(//li[@class='oxd-calendar-dropdown--option'])[11]")).click();
        // Year
        driver.findElement(By.xpath("//li[@class='oxd-calendar-selector-year']")).click();
        driver.findElement(By.xpath("(//li[@class='oxd-calendar-dropdown--option'])[29]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'put-link')])[4]")).click();


        // Gender
        driver.findElement(By.xpath("(//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input'])[2]"));

        // Save
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Blood Type
        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]")).click();
        driver.findElement(By.xpath("(//div[@role='option'])[6]")).click();

        // Test Field
        WebElement tField = driver.findElement(By.xpath("(//div[contains(@class, 'oxd-input')]//input)[16]"));
        tField.sendKeys(Keys.CONTROL + "a");
        tField.sendKeys(Keys.BACK_SPACE);
        tField.sendKeys("789");

        // Save
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

    }

    @AfterTest
    public void end(){
        // driver.quit();
        System.out.println("Updated Successfully!");
    }


}
