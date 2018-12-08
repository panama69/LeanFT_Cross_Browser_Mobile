package net.presales;

import static org.junit.Assert.*;

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

        browser.navigate("www.advantageonlineshopping.com");

        browser.sync();
//        Link sPEAKERSShopNowLink = browser.describe(Link.class, new LinkDescription.Builder()
//                .innerText("SPEAKERS Shop Now ")
//                .tagName("DIV").build());
//        sPEAKERSShopNowLink.highlight();
//        sPEAKERSShopNowLink.click();
//
//        browser.sync();
//        Image speakerImage = browser.describe(Image.class, new ImageDescription.Builder()
//                .alt("")
//                .index(2)
//                .tagName("IMG")
//                .type(com.hp.lft.sdk.web.ImageType.NORMAL).build());
//        speakerImage.highlight();
//        speakerImage.click();
//        browser.sync();

        AppModel model = new AppModel(browser);
        model.AdvantageShoppingPage().SPEAKERSLink().highlight();
        model.AdvantageShoppingPage().SPEAKERSLink().click();
        browser.sync();

        model.AdvantageShoppingPage().FetchImageImageId4200Image().highlight();
        model.AdvantageShoppingPage().FetchImageImageId4200Image().click();
        browser.sync();

        model.AdvantageShoppingPage().SaveToCartButton().highlight();
        model.AdvantageShoppingPage().SaveToCartButton().click();
        browser.sync();

    }

    @Test
    public void testMobileIOS() throws GeneralLeanFtException, InterruptedException, ReportException {

        // Find a device based on its capabilities
        // in this case an IOS device with version 9.0 or higher of the OS
        Browser browser;
        try {
            System.out.println("Running test on iOS mobile browser");
            DeviceDescription description = new DeviceDescription();
            description.setOsType("IOS");
            description.setOsVersion(">=9.0");

            Device device = MobileLab.lockDevice(description);
            browser = BrowserFactory.launch(BrowserType.SAFARI, device);
            navigateBrowser(browser);
            Reporter.reportEvent("Image of Mobile", "Using Safari on iOS", Status.Passed, browser.getSnapshot());
        }
        catch (GeneralLeanFtException glftex) {System.out.println("GeneralLeanFtException: " + glftex.getMessage());}
        catch (InterruptedException iex) {System.out.println("InterruptedException: " + iex.getMessage());}
        catch (ReportException rex){System.out.println("ReportException: " + rex.getMessage());}
    }

    @Test
    public void testMobileAndroid() {

        // Find a device based on its capabilities
        try {

            System.out.println("Running test on Android mobile browser");
            DeviceDescription description = new DeviceDescription();
            description.setOsType("Android");
            description.setOsVersion(">=6.0");

            Device device = MobileLab.lockDevice(description);
            Browser browser2 = BrowserFactory.launch(BrowserType.CHROME, device);
            navigateBrowser(browser2);
            Reporter.reportEvent("Image of Mobile", "Using Chrome on Android", Status.Passed, browser2.getSnapshot());
            windowsSync(1500);

        }
        catch (GeneralLeanFtException glftex) {System.out.println("GeneralLeanFtException: " + glftex.getMessage());}
        catch (InterruptedException iex) {System.out.println("InterruptedException: " + iex.getMessage());}
        catch (ReportException rex){System.out.println("ReportException: " + rex.getMessage());}
        catch (StringIndexOutOfBoundsException soobEx) {System.out.println("StringIndexOutOfBoundsException: " + soobEx.getMessage());}
    }

    @Test
    public void testDesktop () {
        try {
            System.out.println("Running test on desktop browser");
            Browser browser1 = BrowserFactory.launch(BrowserType.FIREFOX);
            navigateBrowser(browser1);
            Reporter.reportEvent("Image of Desktop", "Using Chrome browser", Status.Passed, browser1.getSnapshot());
            windowsSync(1500);
        }
        catch (GeneralLeanFtException glftex) {System.out.println("GeneralLeanFtException: "); glftex.printStackTrace();}
        catch (InterruptedException iex) {System.out.println("InterruptedException: " + iex.getMessage());}
        catch (ReportException rex){System.out.println("ReportException: " + rex.getMessage());}
    }

    private void windowsSync(long milliSeconds) throws InterruptedException{
        Thread.sleep(milliSeconds);
    }
}