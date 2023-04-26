package com.PagePackage;

import com.BasePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseClass {

    @FindBy(xpath="//*[@id=\"loginbyfb\"]")
    WebElement FreeStudent;
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id="password" )
    WebElement password;
    @FindBy(xpath="//*[@id=\"login\"]")
    WebElement loginbtn;

    public SignInPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean verifyfsa(){
        boolean fsa2= FreeStudent.isDisplayed();
        return fsa2;

    }


    public String verifyTitle(){
        String title=driver.getTitle();
        return title;

    }

    public LandingPage verifyLogin( String un , String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginbtn.click();
        return new LandingPage();
    }



















}
