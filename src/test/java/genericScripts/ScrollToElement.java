package genericScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollToElement {
	public static void scrollToElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Point point = ele.getLocation();
		int x = point.getX();
		int y = point.getY();
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}

	public static void scrollToElement2(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Point point = ele.getLocation();
		int x = point.getX();
		int y = point.getY();
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}

	public static void scrollToElementStepByStep(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -300)");
	}
	
	public static void scrollToElementStepByStepPixel(WebDriver driver, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -"+y+")");
	}
	
	public static void scrollToElementByPixel(WebDriver driver, WebElement ele, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Point point = ele.getLocation();
		int x = point.getX() - pixel;
		int y = point.getY() - pixel;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}

	public static void scrollToElementBy300(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Point point = ele.getLocation();
		int x = point.getX() - 300;
		int y = point.getY() - 300;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}

	public static void scrollToElementBy700(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Point point = ele.getLocation();
		int x = point.getX() - 700;
		int y = point.getY() - 700;
		js.executeScript("window.scrollBy(" + x + ", " + y + ")");
	}

}
