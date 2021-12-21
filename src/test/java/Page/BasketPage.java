package Page;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class BasketPage extends BasePage {
    private By productPrice = By.cssSelector(".prodPrice .priceArea span");
    private By counterButton = By.className("spinnerUp");
    private By deleteButton = By.className("removeProd");
    private By emptyBasketText = By.cssSelector(".cartEmptyText .title");
    private By counter = By.className("quantity");
    final static Logger logger = Logger.getLogger(BasketPage.class);

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void controlProductPrice(String productDetailPrice) {
        String basketPage_productPrice = getText(productPrice);
        Assert.assertEquals(productDetailPrice, basketPage_productPrice);
        logger.info("Product detay ve sepet sayfasında ürün fiyatları eşittir.");
    }

    public void counter() {
        click(counterButton);

    }

    public void deleteProduct() {
        click(deleteButton);
    }

    public void isEmpty() {
        Boolean basketText = getText(emptyBasketText).toLowerCase().contains("boş");
        Assert.assertTrue(basketText);
        logger.info("Sepet boş");

    }

    public void isTwoCounter() {
        String twoCounter = getAttribute(counter, "value");
        Assert.assertEquals(twoCounter, "2");
        logger.info("Adet:" + twoCounter);

    }
}
