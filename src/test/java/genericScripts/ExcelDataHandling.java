package genericScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataHandling {
	@Test(enabled = false)
	public static void readExcel() throws Exception
	{
		File f = new File("./excel/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet xssfSheet = wb.getSheet("Rihaa");
		int lastRowNum = xssfSheet.getLastRowNum();
		XSSFRow row = xssfSheet.getRow(0);
		int lastCellNum = row.getLastCellNum();
		
		for(int i=1;i<lastRowNum;i++)
		{
			for(int j=0;j<lastCellNum;j++)
			{
				System.out.print(xssfSheet.getRow(i).getCell(j).toString()+" ");
			}
			System.out.println();
		}
	}
	
	@Test
	public static void writeExcel(String email, String password) throws Exception
	{
//		String email = "abc@gmail.com";
//		String password = "abc@1234";
		
		File f = new File("./excel/TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet xssfSheet = wb.getSheet("Rihaa-NewUsers");
		int lastRowNum = xssfSheet.getLastRowNum();
		XSSFRow row = xssfSheet.createRow(lastRowNum+1);
		row.createCell(0).setCellValue(email);
		row.createCell(1).setCellValue(password);
		
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		
		wb.close();
		
		
	}
}
