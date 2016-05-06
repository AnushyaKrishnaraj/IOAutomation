package com.ts.pages;

import org.apache.poi.util.SystemOutLogger;

import com.ts.utils.web.*;


/**
 * Created by kanushya on 4/26/2016.
 */
public class LoginPage extends PortalPage {


    public LoginPage(PageDriver driver) {
        super(driver);
    }

    public void getLoginPage() throws Exception
    {
    	driver.implicitWait(2000);
    	driver.findElement("xpath=home.loginLink").click();
        driver.implicitWait(2000); 
    	driver.takeScreenShot();
        driver.findElement("xpath=home.linkedinlink").click();
        driver.implicitWait(2000);
        driver.takeScreenShot();
     }

    public String getCookie(String cookieName)
    {
        return driver.getCookie(cookieName);
    }

    public boolean perfromLogin(String userName,String password)
    {
        boolean isVisible = false;
        WwindowHandles window = new WwindowHandles();
        window.windowHandles(driver.getWebDriver());
        HtmlElement userId = driver.findElement("id=login.username");
        HtmlElement pwd =  driver.findElement("id=login.password");
        try {
            userId.clear();
            pwd.clear();
            userId.sendKeys(userName);
            pwd.sendKeys(password);
            driver.takeScreenShot();
            driver.findElement("name=login.loginBtn").click();
            window.windowHandles(driver.getWebDriver());
            driver.waitForLoad();
            //driver.elementClickWait(WBy.get("class=home.logoutLink"));
            isVisible = driver.findElement("xpath=home.logoutLink").isDisplayed();
            System.out.println(isVisible);
        }
        catch (Exception e)
        {
            _logger.error(e);
        }
        
        return isVisible;

    }

    public boolean performLogout() throws InterruptedException
    {
        driver.findElement("xpath=home.logoutLink").click();
        driver.waitForLoad();
        Thread.sleep(2000);
        return driver.findElement("xpath=home.linkedinlink").isDisplayed();
    }


}
