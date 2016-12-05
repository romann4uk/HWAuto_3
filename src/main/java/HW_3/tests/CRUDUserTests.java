package HW_3.tests;

import HW_3.pages.EditPlayerPage;
import HW_3.pages.PlayersPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CRUDUserTests {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //неявное ожидание ожидание скрипта или DOM ст-ры
    }

    @BeforeMethod
    public void beforeMethod() {

        PlayersPage playersPage = new PlayersPage(driver);
        playersPage.openPlayers();
    }

    @Test

    public void userCreationTest() {

        SoftAssert softAssert = new SoftAssert();

        String random_value = RandomStringUtils.randomAlphabetic(12);
        PlayersPage playersPage = new PlayersPage(driver);
        EditPlayerPage editPlayerPage = new EditPlayerPage(driver);

        playersPage.openPlayers();
        playersPage.clickOnInsert();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        playersPage.setUsername(random_value);
        playersPage.setEmailPlayersInsert(random_value + "@test.com");
        playersPage.setPassw(random_value);
        playersPage.setConfirmPassw(random_value);
        playersPage.setFirstName("Ivan");
        playersPage.setLastName("Ivanov");
        playersPage.setCity("Kharkov");
        playersPage.setAddress("Mira 1");
        playersPage.setPhone("+38057211111");
        playersPage.clickOnSave();

        playersPage.setUsername(random_value);

        editPlayerPage.clickOnSearch();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        editPlayerPage.clickOnEdit(random_value);

        String player = editPlayerPage.getUsernameValue();
        softAssert.assertEquals(player, random_value, "Username does not match");

        String playerEmail = editPlayerPage.getEmailValue();
        softAssert.assertEquals(playerEmail ,random_value + "@test.com","Email does not match");

        String playerFname = editPlayerPage.getFnameValue();
        softAssert.assertEquals(playerFname,"Ivan","Fname does not match");

        String playerLname = editPlayerPage.getLnameValue();
        softAssert.assertEquals(playerLname,"Ivanov","Lname does not match");

        String playerCity = editPlayerPage.getCityValue();
        softAssert.assertEquals(playerCity,"Kharkov","City does not match");

        String playerAddress = editPlayerPage.getAddressValue();
        softAssert.assertEquals(playerAddress,"Mira 1","Address does not match");

        String playerPhone = editPlayerPage.getPhoneValue();
        softAssert.assertEquals(playerPhone,"+38057211111","Phone does not match");

        playersPage.setEmailPlayersInsert(random_value + "@test.com");
        playersPage.setFirstName("Roman");
        playersPage.setLastName("Romanov");
        playersPage.setCity("Toronto");
        playersPage.setAddress("Ranocheclose 1");
        playersPage.setPhone("+16479811111");
        playersPage.clickOnSave();
        editPlayerPage.clickOnSearch();
        editPlayerPage.clickOnEdit(random_value);

        player = editPlayerPage.getUsernameValue();
        softAssert.assertEquals(player, random_value, "Username does not match");

        playerEmail = editPlayerPage.getEmailValue();
        softAssert.assertEquals(playerEmail ,random_value + "@test.com","Email does not match");

        playerFname = editPlayerPage.getFnameValue();
        softAssert.assertEquals(playerFname,"Roman","Fname does not match");

        playerLname = editPlayerPage.getLnameValue();
        softAssert.assertEquals(playerLname,"Romanov","Lname does not match");

        playerCity = editPlayerPage.getCityValue(); //actual
        softAssert.assertEquals(playerCity,"Toronto","City does not match");

        playerAddress = editPlayerPage.getAddressValue();
        softAssert.assertEquals(playerAddress,"Ranocheclose 1","Address does not match");

        playerPhone = editPlayerPage.getPhoneValue(); //actual
        softAssert.assertEquals(playerPhone,"+16479811111","Phone does not match");
        softAssert.assertAll();

        playersPage.clickOnSave();

    }

    @Test

    public void negativeEmptyMandatory() {

        SoftAssert softAssert = new SoftAssert();

        String random_value = RandomStringUtils.randomAlphabetic(12);
        PlayersPage playersPage = new PlayersPage(driver);
        EditPlayerPage editPlayerPage = new EditPlayerPage(driver);

        playersPage.openPlayers();
        playersPage.clickOnInsert();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        playersPage.setEmailPlayersInsert(random_value + "@test.com");
        playersPage.setPassw(random_value);
        playersPage.setConfirmPassw(random_value);
        playersPage.setFirstName("Ivan");
        playersPage.setLastName("Ivanov");
        playersPage.setCity("Kharkov");
        playersPage.setAddress("Mira 1");
        playersPage.setPhone("+38057211111");
        playersPage.clickOnSave();
        String actualResults = playersPage.getEmptyPlayersFields();
        String expectedResult = "Username: Value is required and can't be empty";
        Assert.assertEquals(driver.getTitle(),"Players - Insert","Title not mutche");
        Assert.assertEquals(actualResults,expectedResult, "Eror massege is wrong");
    }

        @Test

        public void negativUserNameMore12() {

            String random_value = RandomStringUtils.randomAlphabetic(12);
            PlayersPage playersPage = new PlayersPage(driver);
            EditPlayerPage editPlayerPage = new EditPlayerPage(driver);

            playersPage.openPlayers();
            playersPage.clickOnInsert();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            playersPage.setUsername("1234567891233");
            playersPage.setEmailPlayersInsert(random_value + "@test.com");
            playersPage.setPassw(random_value);
            playersPage.setConfirmPassw(random_value);
            playersPage.setFirstName("Ivan");
            playersPage.setLastName("Ivanov");
            playersPage.setCity("Kharkov");
            playersPage.setAddress("Mira 1");
            playersPage.setPhone("+38057211111");
            playersPage.clickOnSave();
            String actualResults = playersPage.getMoreThan12();
            String expectedResult = "Username: '1234567891233' is more than 12 characters long";
            Assert.assertEquals(driver.getTitle(),"Players - Insert","Title not mutche");
            Assert.assertEquals(actualResults,expectedResult, "User name more than 12");
        }

            @AfterTest
    public void AfterTest (){
        driver.quit();

    }
}

