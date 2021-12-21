package Test;

import Base.BasePage;
import Base.BaseTest;
import Page.HomePage;
import Page.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {
    String email = "testtdeneme3@gmail.com";
    String password = "testdeneme1";

    @Test
    public void isLoginPageOpen() {
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        basePage.wait(2);
        homePage.closePopup();
        basePage.wait(2);
        homePage.goTologinPage();
        basePage.wait(2);
        loginPage.isLoginPageOpen();
    }

    @Test
    public void successLogin() {
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        basePage.wait(2);
        homePage.closePopup();
        basePage.wait(2);
        homePage.goTologinPage();
        basePage.wait(2);
        loginPage.isLoginPageOpen();
        basePage.wait(2);
        loginPage.login(email, password);
        loginPage.isLogin();


    }
}
