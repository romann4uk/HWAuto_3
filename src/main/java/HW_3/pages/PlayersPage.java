package HW_3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;


public class PlayersPage {

    private WebDriver driver;
    public static final String URL = "http://80.92.229.236:81/auth/login";
    public PlayersPage(WebDriver driver) {this.driver = driver;}
    public void open(){
        driver.get(URL);
    }

    public void openPlayers() {
        driver.get(URL);
        WebElement username = driver.findElement(By.xpath(".//*[@id='username']"));
        username.clear();
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
        password.clear();
        password.sendKeys("123");
        driver.findElement(By.xpath("//fieldset[@id='fieldset-Login']/dl/input")).click();
    }

    public void setUsername(String value){
        WebElement username = driver.findElement(By.xpath("(.//input[contains(@id,'login')])[1]"));
        username.clear();
        username.sendKeys(value);
    }

    public void setEmailPlayersInsert(String value){
        WebElement email = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_email']"));
        email.clear();
        email.sendKeys(value);
    }

    public void setPassw(String value) {
        WebElement passw = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_password']"));
        passw.clear();
        passw.sendKeys(value);
    }

    public void setConfirmPassw(String value) {
        WebElement confirmPassw = driver.findElement(By.xpath("//input[@id='ff14642ac1c__confirm_password']"));
        confirmPassw.clear();
        confirmPassw.sendKeys(value);
    }

    public void setFirstName(String value) {
        WebElement firstName = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_fname']"));
        firstName.clear();
        firstName.sendKeys(value);
    }

    public void setLastName(String value) {
        WebElement lastName = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_lname']"));
        lastName.clear();
        lastName.sendKeys(value);
    }

    public void setCity(String value) {
        WebElement city = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_city']"));
        city.clear();
        city.sendKeys(value);
    }

    public void setAddress(String value) {
        WebElement address = driver.findElement(By.xpath("//textarea[@id='ff14642ac1c__us_address']"));
        address.clear();
        address.sendKeys(value);
    }

    public void setPhone(String value) {
        WebElement phone = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_phone']"));
        phone.clear();
        phone.sendKeys(value);
    }

    public void clickOnInsert(){
        driver.findElement(By.xpath("//div[@id='datagrid_actionpanel__723a925886']/a[2]")).click();
    }

    public void clickOnSave(){
        driver.findElement(By.xpath("//input[@name='button_save']")).click();
    }

    public String getEmptyPlayersFields() {
        WebElement errorMsgPasswordFieldElement = driver.findElement(By.xpath(".//li[text()=\"Username: Value is required and can't be empty\"] "));
        String errorPasswordMsg = errorMsgPasswordFieldElement.getText();
        return errorPasswordMsg;

    }
    public String getMoreThan12() {
        WebElement errorMsgPasswordFieldElement = driver.findElement(By.xpath(".//li[text()=\"Username: '1234567891233' is more than 12 characters long\"]"));
        String errorPasswordMsg = errorMsgPasswordFieldElement.getText();
        return errorPasswordMsg;

    }

}
