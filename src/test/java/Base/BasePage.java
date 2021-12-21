package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class BasePage {
    public WebDriver driver;
    final static Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }


    public void click(By by) {
        try {
            findElement(by).click();
            logger.info(by.toString() + " tıklandı");
        } catch (Exception e) {
            logger.error(by.toString() + " tıklanmadı");
        }

    }

    public void wait(int second) {
        try {
            Thread.sleep(second * 1000);
            logger.info("Beklendi");
        } catch (Exception e) {
            logger.error("Beklenmedi");

        }

    }

    public void write(By by, String text) {
        try {
            findElement(by).sendKeys(text);
            logger.info(by.toString() + " " + text + " yazıldı");


        } catch (Exception e) {
            logger.error(by.toString() + " " + text + " yazılmadı");
        }


    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void clickEnter(By by) {
        try {
            findElement(by).sendKeys(Keys.ENTER);
            logger.info(by.toString() + " tıklandı");
        } catch (Exception e) {
            logger.error(by.toString() + " tıklanmadı");
        }

    }

    public int getRandomNumber(int limit) {
        Random random = new Random();
        int randomNumber = random.nextInt(limit);
        return randomNumber;

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public List<WebElement> getElements(By by) {
        List<WebElement> elementList = driver.findElements(by);
        return elementList;
    }

    public String getAttribute(By by, String attribute) {
        return findElement(by).getAttribute(attribute);

    }
}
