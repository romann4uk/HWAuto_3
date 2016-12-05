package HW_3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class EditPlayerPage {

    private WebDriver driver;
    private static final String URL = "http://80.92.229.236:81/auth/login";
    public EditPlayerPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get(URL);
    }

    public void openEditPlayerPage() {
        driver.get(URL);
        WebElement username = driver.findElement(By.xpath(".//*[@id='username']"));
        username.clear();
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath(".//*[@id='password']"));
        password.clear();
        password.sendKeys("123");
        driver.findElement(By.xpath("//fieldset[@id='fieldset-Login']/dl/input")).click();
    }

    public void setPlayer(String value){
        WebElement player = driver.findElement(By.xpath("//input[@id='723a925886__login']"));
        player.clear();
        player.sendKeys(value);
    }

    public void clickOnSearch(){
        driver.findElement(By.xpath("//input[@name='search']")).click();
    }

    public void setEmailPlayers(String value){
        WebElement email = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_email']"));
        email.clear();
        email.sendKeys(value);
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

    public void clickOnSave(){
        driver.findElement(By.xpath("//input[@name='button_save']")).click();
    }

   public String getUsernameValue(){
        WebElement getUsernamValue = driver.findElement(By.xpath(".//input[contains(@id,'login')]"));
        String userNameValue = getUsernamValue.getAttribute("value");
        return userNameValue;
   }

    public String getEmailValue(){
        WebElement getEmailValue = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_email']"));
        String emailValue = getEmailValue.getAttribute("value");
        return emailValue;
    }

    public String getFnameValue(){
        WebElement getFnameValue = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_fname']"));
        String fnameValue = getFnameValue.getAttribute("value");
        return fnameValue;
    }

    public String getLnameValue(){
        WebElement getLnameValue = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_lname']"));
        String lnameValue = getLnameValue.getAttribute("value");
        return lnameValue;
    }

    public String getCityValue(){
        WebElement getCityValue = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_city']"));
        String cityValue = getCityValue.getAttribute("value");
        return cityValue;
    }

    public String getAddressValue(){
        WebElement getAddressValue = driver.findElement(By.xpath("//textarea[@id='ff14642ac1c__us_address']"));
        String addressValue = getAddressValue.getAttribute("value");
        return addressValue;
    }

    public String getPhoneValue(){
        WebElement getPhoneValue = driver.findElement(By.xpath("//input[@id='ff14642ac1c__us_phone']"));
        String phoneValue = getPhoneValue.getAttribute("value");
        return phoneValue;
    }

    public String clickOnEdit(String player){
        driver.findElement(By.xpath(".//tr[.//a[text()='" + player + "']]//img[@alt='Edit']")).click();
        return player;
    }


}



