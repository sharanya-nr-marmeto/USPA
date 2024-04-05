package testScripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import genericScripts.ScrollToElement;
import pom.HomePage;

public class Dummy extends OpenCloseApplication
{
	
	@Test
	public void testApp() throws Exception
	{
//		HomePage homePage = new HomePage(driver);
		File f = new File("./excel/Xpaths.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		XSSFSheet xssfSheet = wb.getSheet("HPCollections_2");

		Iterator<Row> rowIterator = xssfSheet.rowIterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			
			String item = row.getCell(0).getStringCellValue();
			
			WebElement collection = driver.findElement(By.xpath(item));
			ScrollToElement.scrollToElementBy300(driver, collection);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(collection));
			collection.click();
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			driver.findElement(By.cssSelector("div[id='logo'] a img")).click();
//			*/
		}
		wb.close();
	
	}
	

}
