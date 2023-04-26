package com.PageTestPackage;

import com.BasePackage.BaseClass;
import com.PagePackage.HomePage;
import com.UtilityPackage.Utils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {

    HomePage homePage;


    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initialization();
        homePage= new HomePage();

    }

    @Test(priority = 1)
    public void verifyTitletest() {
        String actual = homePage.verifyTitle();
        String Expected = "QA/QE/SDET Training.";
        Assert.assertEquals(Expected, actual);
    }

    @Test(priority = 2)
    public void verifylogotest(){
        boolean wbllogo=homePage.verifylogo();
        Assert.assertTrue(wbllogo);
    }

    @Test(priority = 3)
    public void verifyWblTest(){
        boolean wbl1=homePage.verifyWbl();
        Assert.assertTrue(wbl1);
    }
    @Test(priority = 4)
    public void verifyloginbtnTest(){
        homePage.Verifyloginbtn();

    }

    @AfterMethod
    public void TearDown(){
        driver.close();
    }











}
