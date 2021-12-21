package Page;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage extends BasePage {
    private By searchResultText = By.className("resultText");
    private By secondPageButton = By.xpath("//*[@id=\"contentListing\"]//a[2]");
    private By products = By.cssSelector(".listingGroup .listView .pro .productName"); //*[@id="view"]/ul/li
    final static Logger logger = Logger.getLogger(ProductListPage.class);

    public ProductListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isProductListPageOpen(String searchText) {
        Boolean searchPageOpen = getText(searchResultText).toLowerCase().contains(searchText);
        Assert.assertTrue(searchPageOpen);
        logger.info("search sayfası açıldı");
    }

    public void goToSecondPage() {
        click(secondPageButton);
        logger.info("2.sayfa açıldı");
    }

    public void isSecondPageOpen() {
        String currentUrl = getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.n11.com/arama?q=bilgisayar&pg=2");
        logger.info("Sayfa 2 açık");
    }

    public void randomProduct() {
        List<WebElement> elementList = getElements(products);
        int randomProductNumber = getRandomNumber(elementList.size());
        WebElement randomProduct = elementList.get(randomProductNumber);
        randomProduct.click();
    }
}
