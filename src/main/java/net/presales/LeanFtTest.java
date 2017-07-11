package net.presales;

import static org.junit.Assert.*;

import com.hp.lft.sdk.internal.common.MessageFieldNames;
import com.hp.lft.sdk.mobile.Button;
import com.hp.lft.sdk.mobile.ButtonDescription;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.*;
import com.hp.lft.sdk.mobile.*;
import com.hp.lft.report.*;

import com.hp.lft.verifications.*;

import sun.plugin.services.BrowserService;
import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {

    public LeanFtTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new LeanFtTest();
        globalSetup(LeanFtTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    private void navigateBrowser (Browser browser) throws GeneralLeanFtException, InterruptedException {
        browser.sync();
        browser.navigate("www.advantageonlineshopping.com");
        //browser.describe(Link.class, new LinkDescription.Builder().tagName("SPAN").innerText("SPEAKERS").build()).highlight();

        browser.describe(Link.class, new LinkDescription.Builder()
                .tagName("SPAN").innerText("SPEAKERS").build()).click();
        browser.sync();
    }

    @Test
    public void testMobile() throws GeneralLeanFtException, InterruptedException, ReportException {

        // Find a device based on its capabilities
        // in this case an IOS device with version 9.0 or higher of the OS
        DeviceDescription description = new DeviceDescription();
        description.setOsType("IOS");
        description.setOsVersion(">=9.0");

        Device device = MobileLab.lockDevice(description);
        Browser browser = BrowserFactory.launch(BrowserType.SAFARI, device);
        navigateBrowser(browser);
        Reporter.reportEvent("Image of Mobile","",Status.Passed, browser.getSnapshot());

    }

    @Test
    public void testDesktop () throws GeneralLeanFtException, ReportException, InterruptedException {
        Browser browser = BrowserFactory.launch(BrowserType.FIREFOX);
        navigateBrowser(browser);
        Reporter.reportEvent("Image of Desktop","",Status.Passed, browser.getSnapshot());
        browser.close();

    }
}