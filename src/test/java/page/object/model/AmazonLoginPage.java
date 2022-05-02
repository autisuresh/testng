package page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {

    WebDriver driver;

    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


//    By loginbtn = By.className("login-btn");
//    By user_name = By.id("user_name");
//    By email = By.id("user_email");
//    By password = By.id("password");
//    By submitbtn = By.xpath("//input[@type='submit']");
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement loginbtn;

    @FindBy(id="user_name")
    WebElement user_name;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="email")
    WebElement email;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitbtn;

    public  WebElement LoginBtn() {return loginbtn;}

    public WebElement Username(){
        return user_name;
    }

    public WebElement EmailId(){
        return email;
    }

    public WebElement Continue() {
        return submitbtn;
    }

    public WebElement Password() {
        return password;
    }
}
