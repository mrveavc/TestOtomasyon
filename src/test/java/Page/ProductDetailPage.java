package Page;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
    private By addToBasket = By.xpath("//div[4]/div/div[2]/a");
    private By productPrice = By.xpath("//div/ins");
    final static Logger logger = Logger.getLogger(ProductDetailPage.class);

    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String addToBasket() {
        click(addToBasket);
        logger.info("Sepete eklendi");
        return getText(productPrice);


    }
}
