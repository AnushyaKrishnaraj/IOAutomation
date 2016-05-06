package com.ts.tests;

import com.ts.pages.LoginPage;
import com.ts.base.BaseWebTest;
import com.ts.utils.web.Browsers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by kanushya on 4/26/2016.
 */
public class LoginPageTest extends BaseWebTest {

    private LoginPage _lp;
    private String cookieName;
    private String sheetName;

    @BeforeTest
    @Parameters({"seesionCookie","sheetName"})
    public void init(String cookieName,String sheetName)
    {
        _lp = new LoginPage(driver);
        this.cookieName = cookieName;
        this.sheetName = sheetName;
    }

    @DataProvider(name = "users-data")
    public Object[][] getUsers() throws Exception {
    	System.out.println("Reading the excel file " );
        Object[][] data = excelUtils.getSimpleExcelData(driver._configuration.DataFileName,sheetName);
        return data;
    }

    @Test(priority = 1,dataProvider = "users-data")
    public void testLogin(String uname,String pwd)throws Exception
    {
        _lp.getLoginPage();
        boolean actual = _lp.perfromLogin(uname, pwd);
        assertTrue(actual);
        driver.takeScreenShot();
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testLogout() throws InterruptedException,IOException
    {
        boolean postSession = _lp.performLogout();
        assertTrue(postSession);
        driver.takeScreenShot();
    } 

}
