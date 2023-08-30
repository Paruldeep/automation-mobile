package com.thescore;

import com.thescore.config.Driver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicInit {

    @BeforeClass
    public void beforeClass(ITestContext context) {
        String osType = context.getCurrentXmlTest().getParameter("os.type");
        Driver.setOS(osType);
    }

    @AfterClass
    public void cleanUp() {
        Driver.getInstance().quit();
    }
}
