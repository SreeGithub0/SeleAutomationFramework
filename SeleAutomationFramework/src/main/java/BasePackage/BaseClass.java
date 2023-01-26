package BasePackage;

import UtilityPackage.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.internal.Util;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass { //parent class

    public static WebDriver driver;
    public static Properties prop;

    public static Logger log ;

    public BaseClass(){ //constructor

        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream("C:\\Users\\14088\\IdeaProjects\\SeleAutomationFramework\\src\\main\\java\\ConfigPackage\\ConfigProperties.properties");
            prop.load(fis);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
            //System.out.println(e);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void Intialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        log.info("window will be maximized");
        driver.get(prop.getProperty("url"));
       log.info("it append url");

       log = Logger.getLogger("SeleAutomationFramework");
        PropertyConfigurator.configure("C:\\Users\\14088\\IdeaProjects\\SeleAutomationFramework\\src\\main\\Resourcs\\Log4j.Properties");

        driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);

    }
}
