package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingPageTest extends BaseClass {
    HomePage hp;
    LoginPage lp;
    LandingPage land;

    public LandingPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        Intialization();
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        land = new LandingPage(driver);
        hp.ClickLogin();
        lp.loginmethod(prop.getProperty("username"), prop.getProperty("password"));
        land = lp.clicksubmit();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void TestWbl(){
        boolean wb = land.checkWBL();
        Assert.assertTrue(wb);
    }

    @Test
    public void TestMailID(){
        boolean mail = land.checkMailid();
        Assert.assertTrue(mail);
    }
}
