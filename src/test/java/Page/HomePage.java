package Page;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By loginButton = By.className("btnSignIn");
    private By closePopupButton = By.cssSelector(".myLocation-headsUp .agt-s-info .btnBlack");
    private By closePopup = By.cssSelector(".popin .closeBtn");
    private By basketButton = By.className("myBasket");
    private By searchTextBox = By.id("searchData");
    private By basketClosePopup = By.xpath("//*[@id=\"userKvkkModal\"]//div[2]");
    final static Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void closePopup() {
        click(closePopupButton);
        click(closePopup);
    }

    public void goTologinPage() {
        click(loginButton);
        logger.info("Login sayfasına gidildi ");

    }

    public void search(String searchText) {
        write(searchTextBox, searchText);
        clickEnter(searchTextBox);
        logger.info(searchText + " aratıldı");

    }

    public void goToBasket() {
        click(basketButton);
        click(basketClosePopup);
        logger.info("Sepete gidildi");

    }

}
