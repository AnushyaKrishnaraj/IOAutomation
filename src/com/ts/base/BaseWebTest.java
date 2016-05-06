package com.ts.base;

import com.ts.utils.ExcelUtils;
import com.ts.utils.web.PageDriver;
import com.ts.utils.web.WBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by svelupula on 8/14/2015.
 */
public abstract class BaseWebTest extends BaseTest {

    public PageDriver driver;
    public ExcelUtils excelUtils;

    @BeforeSuite
    public void beforeSuite() {
        driver = new PageDriver(_config);
        WBy.loadJsonMap(String.format("%s/locators.json", System.getProperty("user.dir")));
        excelUtils = new ExcelUtils();
    }

    @AfterSuite
    public void afterSuite() {

        driver.quit();
    }

}
