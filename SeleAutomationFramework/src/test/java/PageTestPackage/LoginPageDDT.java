package PageTestPackage;

import BasePackage.BaseClass;
import PagePackage.HomePage;
import PagePackage.LandingPage;
import PagePackage.LoginPage;
import UtilityPackage.ReadXL;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageDDT extends BaseClass {
    HomePage hp;
    LoginPage lp;
    LandingPage land;

    public LoginPageDDT(){
        super();
    }
    @BeforeMethod
    public void setup(){
        Intialization();
        hp = new HomePage(driver);
        lp = new LoginPage(driver);
        land = new LandingPage(driver);
        hp.ClickLogin();
    }
    @AfterMethod
    public void Teardown(){
        driver.close();
    }

    @Test(dataProvider="logindata")
    public void loginddt(String user,String pwd) throws InterruptedException {
        lp.loginmethod(user,pwd);

        land =new LandingPage(driver);
    }

    @DataProvider(name="logindata")
    String [][]getdata() throws IOException {
        String path="C:\\Users\\14088\\IdeaProjects\\SeleAutomationFramework\\src\\test\\resources\\FrameworkData.xlsx";
        int rownum= ReadXL.getRowCount(path, "Sheet1");
        int colcount=ReadXL.getCellCount(path, "Sheet1", 1);
        String logindata[][]=new String[rownum][colcount];
        //0 is for header..column is 0
        for(int i=1;i<=rownum;i++) {
            for(int j=0;j<colcount;j++ ) {
                logindata[i-1][j]=ReadXL.getCellData(path, "Sheet1", i, j);//1  0
            }
        }
        return logindata;
    }
}
