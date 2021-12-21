package Test;

import Base.BasePage;
import Base.BaseTest;
import Page.*;
import org.junit.Test;

public class SearchTest extends BaseTest {
    String email = "testtdeneme3@gmail.com";
    String password = "testdeneme1";

    @Test
    public void searchTest() {
        HomePage homePage = new HomePage(driver);
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);

        basePage.wait(2);
        homePage.closePopup();
        basePage.wait(2);
//        homePage.goTologinPage();
//        basePage.wait(2);
//        loginPage.isLoginPageOpen();
//        basePage.wait(2);
//        loginPage.login(email, password);
//        loginPage.isLogin();
//        basePage.wait(2);
        homePage.search("bilgisayar");
        basePage.wait(2);
        productListPage.isProductListPageOpen("bilgisayar");
        basePage.wait(2);
        productListPage.goToSecondPage();
        basePage.wait(2);
        productListPage.isSecondPageOpen();
        basePage.wait(2);
        productListPage.randomProduct();
        basePage.wait(2);
        String productDetailPrice = productDetailPage.addToBasket();
        basePage.wait(2);
        homePage.goToBasket();
        basePage.wait(2);
        basketPage.controlProductPrice(productDetailPrice);
        basePage.wait(2);
        basketPage.counter();
        basePage.wait(2);
        basketPage.isTwoCounter();
        basePage.wait(2);
        basketPage.deleteProduct();
        basePage.wait(2);
        basketPage.isEmpty();

    }

}
