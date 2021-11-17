package pages;

import logic.PreSetData;
import logic.SetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class Login extends SetUp {
    private static By login = By.xpath("//input[@placeholder='Login']");
    private static By password = By.xpath("//input[@placeholder='Password']");

    public static void sendLogin() {
      WebElement loginEl = getWait().until(ExpectedConditions.elementToBeClickable(login));
      WebElement passwordEl = getWait().until(ExpectedConditions.elementToBeClickable(password));
      loginEl.sendKeys(PreSetData.login);
      passwordEl.sendKeys(PreSetData.password);
      passwordEl.submit();
    }


}
