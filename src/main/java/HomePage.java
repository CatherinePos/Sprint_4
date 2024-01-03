import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    // Локатор кнопки Заголовка
    private final By homeHeader = By.className("Home_Header__iJKdX");
    // Локатор кнопки Заказать сверху
    private final By upOrderButton = By.className("Button_Button__ra12g");
    // Локатор кнопки Заказать снизу
    private final By downOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Локатор кнопки о Куки
    private final By Cukie = By.xpath(".//button[text()='да все привыкли']");
    // Локатор кнопки Заголовка Вопросы о важном
    private final By questionsHeader = By.className("Home_FourPart__1uthg");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitLoadAfterClickQuestion(By answer) {
        new WebDriverWait(driver, 5).until(driver -> (driver.findElement(answer).getText() != null
                && !driver.findElement(answer).getText().isEmpty()
        ));
    }

    public HomePage scrollToQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsHeader));
        return this;
    }

    public HomePage clickQuestion(By question) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(question))
                .click();
        return this;
    }

    public HomePage waitForLoadHomePage() {
        new WebDriverWait(driver, 15).until(driver -> (driver.findElement(homeHeader).getText() != null
                && !driver.findElement(homeHeader).getText().isEmpty()
        ));
        return this;
    }
    public HomePage clickUpOrderButton() {
        driver.findElement(upOrderButton).click();
        return this;
    }

    public HomePage clickDownOrderButton() {
        driver.findElement(downOrderButton).click();
        return this;
    }
    public HomePage clickCukie() {
        driver.findElement(Cukie).click();
        return this;
    }

    public HomePage scrollToDownOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(downOrderButton));
        return this;
    }
}
