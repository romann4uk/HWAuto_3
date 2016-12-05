package HW_3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public static final String URL = "http://80.92.229.236:81";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL + "/auth/login");
    }

    public void login(String username, String password) {
            setUsername(username);
            setPassword(password);
            clickOnLogin();
    }

    public void setUsername(String username) {
        WebElement usernameInput = driver.findElement(By.id("username")); // Find username input
        usernameInput.clear();
        usernameInput.sendKeys(username); // Set username
    }

    public void setPassword(String password) {
        WebElement passwordInput = driver.findElement(By.id("password")); // Find password input
        passwordInput.clear();
        passwordInput.sendKeys(password); // Set password
    }

    public void clickOnLogin() {
        WebElement loginButton = driver.findElement(By.id("logIn")); // Find login button
        loginButton.click(); // click on LogIn button
    }

    public String getErrorMessage() {
        WebElement errorMsgElement = driver.findElement(By.xpath("//ul[@class='errors']/li"));
        String errorMsg = errorMsgElement.getText();
        return errorMsg;
//        return driver.findElement(By.xpath("//ul[@class='errors']/li")).getText();
    }
    public String getErrorMessageEmptyUsnameFields() {
        WebElement errorMsgUsnameElement = driver.findElement(By.xpath("//dd[@id='username-element']/ul/li"));
        String errorUsnameMsg = errorMsgUsnameElement.getText();
        return errorUsnameMsg;
//        return driver.findElement(By.xpath("//dd[@id='username-element']/ul/li")).getText();
    }

    public String getErrorMessageEmptyPassFields() {
        WebElement errorMsgPasswordFieldElement = driver.findElement(By.xpath("//dd[@id='password-element']/ul/li"));
        String errorPasswordMsg = errorMsgPasswordFieldElement.getText();
        return errorPasswordMsg;
//        return driver.findElement(By.xpath("//dd[@id='password-element']/ul/li")).getText();
    }
}