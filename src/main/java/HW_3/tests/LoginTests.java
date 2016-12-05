package HW_3.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HW_3.pages.LoginPage;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    WebDriver driver; // Declare var
    LoginPage loginPage;

    @BeforeTest
    public void beforeTest() {
        //open browser
        driver = new FirefoxDriver(); //initialize/create object/open firefox
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test
    public void positiveTest() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.open(); //open poker URL
        loginPage.setUsername("admin");
        loginPage.setPassword("123");
        loginPage.clickOnLogin();
        Assert.assertEquals(driver.getTitle(), "Players", "Wrong title after login");
        Assert.assertNotEquals(driver.getCurrentUrl(), LoginPage.URL + "/auth/login", "You are still on login page.");
    }

    @Test
    public void negativeTestWrongPasssord(){
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.open(); //open poker URL
        loginPage.setUsername("admin");
        loginPage.setPassword("12345");
        loginPage.clickOnLogin();
//        loginPage.login("admin", "123");
        String expectedMsg = "Invalid username or password";
        String actualMsg = loginPage.getErrorMessage();
        Assert.assertEquals(driver.getCurrentUrl(), LoginPage.URL + "/auth/login", "You are NOT on login page.");
        Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");
    }

    @Test
    public void negativeTestWrongLogin(){
        loginPage.setUsername("adm");
        loginPage.setPassword("123");
        loginPage.clickOnLogin();
//        loginPage.login("admin", "123");
        String expectedMsg = "Invalid username or password";
        String actualMsg = loginPage.getErrorMessage();
        Assert.assertEquals(driver.getCurrentUrl(), LoginPage.URL + "/auth/login", "You are NOT on login page.");
        Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        Assert.assertEquals(actualMsg, expectedMsg, "Validation error message is not valid.");

    }

    @Test
    public void negativeTestEmptyFields(){
        loginPage.setUsername("");
        loginPage.setPassword("");
        loginPage.clickOnLogin();
        String expectedUsnameMsg = "Value is required and can't be empty";
        String expectedPasswordMsg = "Value is required and can't be empty";
        String actualUsnameMsg = loginPage.getErrorMessageEmptyUsnameFields();
        String actualPasswordMsg = loginPage.getErrorMessageEmptyPassFields();
        Assert.assertEquals(driver.getCurrentUrl(), LoginPage.URL + "/auth/login", "You are NOT on login page.");
        Assert.assertEquals(driver.getTitle(), "Login", "Wrong title after unsuccessful login");
        Assert.assertEquals(actualUsnameMsg, expectedUsnameMsg, "Validation error message is not valid.");
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "Validation error message is not valid.");
    }

    @AfterTest
    public void afterTest() {

        //close browser
        driver.quit();
    }
}