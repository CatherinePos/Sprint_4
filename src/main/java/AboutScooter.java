import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Constants.ScooterColoursConstants.*;

public class AboutScooter {
    WebDriver driver;
    // Локатор Заголовка Про аренду
    private final By rentHeader = By.className("Order_Header__BZXOb");
    // Локатор поля Когда привезти самокат
    private final By date = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Локатор поля Срок аренды
    private final By durationRent = By.xpath(".//span[@class='Dropdown-arrow']");
    // Локатор поля Цвет самоката черный жемчуг
    private final By colourBlack = By.id("black");
    // Локатор поля Цвет самоката серая безысходность
    private final By colourGrey = By.id("grey");
    // Локатор поля Комментарий для курьера
    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Локатор кнопки подтверждения заказа
    private final By createOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public AboutScooter(WebDriver driver) {
        this.driver = driver;
    }

    public AboutScooter waitAboutRentHeader() {
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(rentHeader).getText() != null
                && !driver.findElement(rentHeader).getText().isEmpty()
        ));
        return this;
    }

    public AboutScooter inputDate(String newDate) {
        driver.findElement(date).sendKeys(newDate);
        return this;
    }

    public AboutScooter inputDuration(String newDuration) {
        driver.findElement(durationRent).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.className("Dropdown-menu"))).click();
        return this;
    }

    public AboutScooter changeColour(String colour) {
        if (colour.equals(BLACK)) {
            driver.findElement(colourBlack).click();
        } else if (colour.equals(GREY)) {
            driver.findElement(colourGrey).click();
        }
        return this;
    }

    public AboutScooter inputComment(String newComment) {
        driver.findElement(comment).sendKeys(newComment);
        return this;
    }
    public void clickButtonCreateOrder() {
        driver.findElement(createOrderButton).click();
    }
}
