package PagePackage;

import BasePackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//img[@id='logo']")
    WebElement wbllogo;

    @FindBy(xpath = "//button[@id='headerfblogin']")
    WebElement freestudent;

    @FindBy(xpath="//a[@id='loginButton']")
    WebElement loginbtn;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  boolean CheckWblogo(){

        return wbllogo.isDisplayed();
    }

    public boolean CheckFreestudent(){

        return freestudent.isDisplayed();
    }

    public LoginPage ClickLogin(){
        loginbtn.click();
        return new LoginPage(driver);
    }
}
