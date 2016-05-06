package com.ts.tests;

import com.ts.pages.HomePage;
import com.ts.base.BaseWebTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Created by kanushya on 4/26/2016.
 */
public class HomePageTest extends BaseWebTest {

    private HomePage _hp;

    @BeforeClass
    public void beforeClass() {
        _hp = new HomePage(driver);
    }

    @Test(priority = 1, alwaysRun = true)
    public void testSlidesCount() throws IOException{
    	try {
			driver.implicitWait(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.takeScreenShot();
        assertEquals(6, _hp.getSliderItemsCount());
        driver.takeScreenShot();
}

   /* @Test(priority = 2)
    public void testFBLink()
    {
        boolean isFBPage = _hp.getFacebookPage();
        assertTrue(isFBPage);
    } */


}
