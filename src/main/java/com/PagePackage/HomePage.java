package com.PagePackage;

import com.BasePackage.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath="//*[@id=\"logo\"]")
    WebElement wbllogo;
    @FindBy(xpath="//*[@id=\"headerfblogin\"]")
    WebElement Fsa;
    @FindBy(xpath="//*[@id=\"wblhead\"]")
    WebElement wbl;
    @FindBy(xpath="//*[@id=\"loginButton\"]")
    WebElement login;

    public HomePage(){
        PageFactory.initElements(driver,this);
        logger= Logger.getLogger(HomePage.class);
        logger.info("iam in homepage");
    }

    public String verifyTitle(){
        String title = driver.getTitle();
        return title;
    }

    public  boolean verifylogo(){
        boolean wlogo=wbllogo.isDisplayed();
        return wlogo;
    }

    public boolean verifyWbl(){
        boolean wbl1= wbl.isDisplayed();
        return wbl1;
    }

    public boolean verifyFsa(){
        boolean fsa1= Fsa.isDisplayed();
        return fsa1;
    }
 public SignInPage Verifyloginbtn(){
        login.click();
        return new SignInPage();
 }

}
