package com.PageTestPackage;

import com.BasePackage.BaseClass;
import com.PagePackage.HomePage;
import com.PagePackage.LandingPage;
import com.PagePackage.SignInPage;
import com.UtilityPackage.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignInPageTest extends BaseClass {

    HomePage homePage;
    SignInPage signin;
    LandingPage land;

    public SignInPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        homePage= new HomePage();
        signin= new SignInPage();
        homePage.Verifyloginbtn();
    }

    @Test(priority = 1)
    public void VerifyFSAtest(){
        boolean fsa=signin.verifyfsa();
        Assert.assertTrue(fsa);

    }

    @Test(priority = 2)
    public void VerifyTitleTest(){
        String title =signin.verifyTitle();
        Assert.assertEquals(title,"QA/QE/SDET Training.");
    }

    @DataProvider
    public  Object[][] loginDataDriven(){
        Object data[][]= Utils.getExcelData("Userdatasheet","Sheet1");
        return data;
    }

    @Test(priority = 3 , dataProvider ="loginDataDriven")
    public void LoginTest(String username , String password){
        signin.verifyLogin(username,password);
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

























}
