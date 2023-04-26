package com.BasePackage;

import com.UtilityPackage.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class BaseClass {
    public static WebDriver driver;
    public static Properties prop;
    public static Logger logger;

    public BaseClass() {
        try {
            prop = new Properties();// creating properties class object
            FileInputStream ip = new FileInputStream("C:\\Users\\Sampath Velupula\\IdeaProjects\\WhiteBoxQaAutomation\\" +
                    "src\\main\\java\\com\\ConfigPackage\\Config.Properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String log4jpath = System.getProperty("C:\\Users\\Sampath Velupula\\IdeaProjects\\" +
                "WhiteBoxQaAutomation\\src\\main\\resources\\Log4j.Properties");
        PropertyConfigurator.configure(log4jpath);
    }


    public static void initialization() {
        // object of chromedriver class using webdriver interface
        String browserName = prop.getProperty("browser");
        WebDriverManager.chromedriver().setup();
//       if(browserName.equals("chrome")){
//          System.setProperty("webdriver.chrome.driver","C:\\Users\\Sampath Velupula\\IdeaProjects\\WalmartAutomation\\" +
//                   "src\\main\\resources\\BrowserDrivers\\chromedriver.exe");
//      }else if (browserName.equals("firefox")){
//           System.setProperty("webdriver.gecko.driver","C:\\Users\\Sampath Velupula\\IdeaProjects\\WalmartAutomation\\" +
//                  "src\\main\\resources\\BrowserDrivers\\geckodriver.exe");
//       }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
        driver.manage().deleteAllCookies();


    }
}