package logic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.Login;

import java.util.List;


public class StreamChecker extends SetUp {

    private static By statusBlock = By.xpath("//a[contains(@class, 'card-stream')]");
    public static void streamCheck() {
        int goodResults = 0;
        Login.sendLogin();
//        sleep(1000);
        List<WebElement> goodStreams = getWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(statusBlock));
        System.out.println("Total number of goodStreams to check: " + goodStreams.size());
        for (WebElement e : goodStreams) {
            int onair = Integer.parseInt(e.getAttribute("$onair"));
            if (onair > 0) {
                String par = e.getAttribute("text")
                        .replaceAll("AnalyzeDisableRemove", " ")
                        .replaceAll("Inactive", "");
                System.out.println(par + " ok");
                goodResults++;
            } else {
                String par = e.getAttribute("text")
                                .replaceAll("EnableRemove", "----------------------\n");
                System.out.println("\n----------------------HOUSTON! WE HAVE A PROBLEM WITH " + par);
            }
        }
        Assert.assertEquals(goodResults, goodStreams.size()-1);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
