package dummy;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class FetchDataFromExcelFile {
	@Test
	public void testApp() throws Exception
	{
		File f = new File("./excel/Xpaths.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet xssfSheet = wb.getSheet("New Arrivals");
		
		Iterator<Row> rowIterator = xssfSheet.rowIterator();
		
		while(rowIterator.hasNext())
		{
			Row next = rowIterator.next();
			
			Iterator<Cell> cellIterator = next.cellIterator();
			
			while(cellIterator.hasNext())
			{
				Cell cell = cellIterator.next();
				System.out.println(cell.getStringCellValue());
			}
		}
		
	}
}
