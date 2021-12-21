package Page;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private By emailTextBox = By.id("email");
    private By passwordTextBox = By.id("password");
    private By loginPageText = By.xpath("//div[@class=\"blockWrap\"]/h2");
    private By loginButton = By.id("loginButton");
    private By myAccount = By.xpath("//a[@class=\"menuLink user\"]");
    final static Logger logger = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isLoginPageOpen() {
        String loginPage = getText(loginPageText);
        Assert.assertEquals(loginPage, "Giriş Yap");
        logger.info("Giriş sayfası açıldı");

    }

    public void login(String email, String password) {
        write(emailTextBox, email);
        wait(2);
        write(passwordTextBox, password);
        wait(2);
        click(loginButton);

    }

    public void isLogin() {
        Boolean isDisplayed = findElement(myAccount).isDisplayed();
        Assert.assertTrue(isDisplayed);
        logger.info("Giriş  yapıldı");


    }
}
