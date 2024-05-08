package id.visionplus.v2.Action;

/* Updated by	: Michael
 * Updated Date	: 4 April 2024
 * Summary		: Modify Scroll Down Until Element Found
 * 1. Modify that when arrive at the bottom, do scroll up until element
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import id.visionplus.v2.Utils.AndroidGesture;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.concurrent.TimeUnit;


public class Scroll extends AndroidGesture {

    AndroidDriver android;
    WebDriverWait wait;
    int previousHeight = 0;

    public Scroll(AndroidDriver android) {
        super(android);
        this.android = android;
        PageFactory.initElements(new AppiumFieldDecorator(android), this);
    }

    public void scrollToText(String text) {
        AndroidGesture gesture = new AndroidGesture(android);
        gesture.scrollToText(text);
    }

    public void scrollUntilElementFound(By locator) {
        System.out.println("Arrive at scroll down until");
        int flag = 0;
        long startTime = System.currentTimeMillis();
        long timeoutInMillis = 30 * 1000; // Timeout set to 30 seconds
        int currentHeight;
        int totalHeight = getTotalHeight();

        while (flag == 0 && System.currentTimeMillis() - startTime <= timeoutInMillis) {
            try {
                WebElement element = android.findElement(locator);
                if (element.isDisplayed()) {
                    System.out.println("Element Found");
                    flag = 1;
                    break;
                }
            } catch (NoSuchElementException e) {
                scrollDown(0.2);
            }
        }

        if (flag == 0) {
            System.out.println("Element not found within the timeout period.");
            System.out.println("Reached bottom of the page, initiate scroll up");
            scrollUpUntilElementFound(locator);        
        }
    }

    private int getTotalHeight() {
        // Scroll to the bottom of the page
        scrollDown(0.2);
        
        // Get the position of the last element
        WebElement lastElement = android.findElement(By.xpath("(//*)[last()]"));
        int totalHeight = lastElement.getLocation().getY() + lastElement.getSize().getHeight();
        
        return totalHeight;
    }

    public void scrollUpUntilElementFound(By locator) {
        System.out.println("Arrive at scroll Up until");
        int flag = 0;
        long startTime = System.currentTimeMillis();
        long timeoutInMillis = 180 * 1000; // Timeout set to 180 seconds

        while (flag == 0 && System.currentTimeMillis() - startTime <= timeoutInMillis) {
            try {
                WebElement element = android.findElement(locator);
                if (element.isDisplayed()) {
                    System.out.println("Element Found");
                    flag = 1;
                    break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Element Not Found, initiate scroll Up");
                scrollUp(0.2);
            }
        }

        if (flag == 0) {
            System.out.println("Element not found within the timeout period.");
            System.out.println("Reached Upper of the page, initiate scroll down");
            scrollUntilElementFound(locator);        
        }
    }

    public void scrollDown(double value) {
        AndroidGesture gesture = new AndroidGesture(android);
        gesture.scrollDownWithParameter(value);
    }

    public void scrollUp(double value) {
        AndroidGesture gesture = new AndroidGesture(android);
        gesture.scrollUpWithParameter(value);
    }
}
