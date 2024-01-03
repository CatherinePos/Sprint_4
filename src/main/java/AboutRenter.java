import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRenter {
    WebDriver driver;
    // Локатор кнопки Заголовка Для кого самокат
    private final By orderHeader = By.className("Order_Header__BZXOb");
    // Локатор поля Имя
    private final By name = By.xpath(".//input[@placeholder='* Имя']");
    // Локатор поля Фамилия
    private final By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    // Локатор поля Адрес Куда привезти заказ
    private final By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Локатор поля Станция метро
    private final By stateMetro = By.className("select-search__input");
    // Локатор поля Телефона На него позвонит курьер
    private final By telephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Локатор кнопки Далее
    private final By buttonNext = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Возможные значенпя стации метро
    private final String nameStateMetro = ".//button[@value='%s']";

    public AboutRenter(WebDriver driver) {
        this.driver = driver;
    }

    public AboutRenter waitForLoadOrderPage() {
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(orderHeader).getText() != null
                && !driver.findElement(orderHeader).getText().isEmpty()
        ));
        return this;
    }

    public AboutRenter inputName(String newName) {
        driver.findElement(name).sendKeys(newName);
        return this;
    }

    public AboutRenter inputSurname(String newSurname) {
        driver.findElement(surname).sendKeys(newSurname);
        return this;
    }

    public AboutRenter inputAddress(String newAddress) {
        driver.findElement(address).sendKeys(newAddress);
        return this;
    }

    public AboutRenter changeStateMetro(int stateNumber) {
        driver.findElement(stateMetro).click();
        By newStateMetro = By.xpath(String.format(nameStateMetro, stateNumber));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(newStateMetro));
        driver.findElement(newStateMetro).click();
        return this;
    }

    public AboutRenter inputTelephone(String newTelephone) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(telephone));
        driver.findElement(telephone).sendKeys(newTelephone);
        return this;
    }

    public void clickNextButton() {
        driver.findElement(buttonNext).click();
    }
}
