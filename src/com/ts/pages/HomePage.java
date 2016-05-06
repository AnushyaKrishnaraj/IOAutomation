package com.ts.pages;

import com.ts.pages.PortalPage;
import com.ts.utils.*;
import com.ts.utils.web.PageDriver;

/**
 * Created by kanushya on 4/26/2016.
 */
public class HomePage extends PortalPage {

    public HomePage(PageDriver driver) {
        super(driver);
        _logger.debug("Open Home Page");
        try {
            driver.findElement("xpath=header.home").click();
        }
        catch(Exception e)
        {
            _logger.error(e);
        }
    }

    public int getSliderItemsCount() {
        return driver.findElements("xpath=home.slider.items").size();
    }
    


 /*   public boolean getFacebookPage()
    {
        boolean status = false;
        try{
	        driver.visibilityWait(PathLocator.get("header.social.fblink"));
            driver.executeJavaScript("arguments[0].click();","header.social.fblink");
            driver.waitForLoad();
            status = driver.getCurrentUrl().contains("facebook")?true:false;
        }
        catch(Exception e)
        {
        	_logger.error(e);
        }
        return status;
    } */
}
