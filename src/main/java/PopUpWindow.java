import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpWindow {
    WebDriver driver;
    private final By popUpHeaderAfterCreateOrder = By.xpath(".//div[text()='Заказ оформлен']");

    public PopUpWindow(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderAfterCreateOrder() {
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(popUpHeaderAfterCreateOrder).getText() != null
                && !driver.findElement(popUpHeaderAfterCreateOrder).getText().isEmpty()
        ));
        return driver.findElement(popUpHeaderAfterCreateOrder).getText();
    }
}
