package pom.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import page.object.model.AmazonLoginPage;

public class AmazonLoginTest {

    @Test
    public void Login() {
        System.setProperty("webdriver.chrome.driver","D:\\javap\\sample-demo\\TestNG\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://courses.rahulshettyacademy.com/");

        AmazonLoginPage amazonLoginPage = new AmazonLoginPage(driver);

        amazonLoginPage.LoginBtn().click();
        //amazonLoginPage.Username().sendKeys("Suresh Auti");
        amazonLoginPage.EmailId().sendKeys("auti.suresh@gmail.com");
        amazonLoginPage.Password().sendKeys("Suresh@123");
        amazonLoginPage.Continue().click();

    }
}
