package dataDriventest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
    
	private static File f;
	private static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFCell cell;
	static int rowCount;
	static int cellCount;
	
	public static int getRowCount(String path,String sheetName) throws IOException
	{   
		
		 f=new File(path);
		 fis=new FileInputStream(f);
		 wb=new XSSFWorkbook(fis);
		 sheet=wb.getSheet(sheetName);
		 rowCount= sheet.getLastRowNum();
		 fis.close();
	     wb.close();
		 return rowCount;
		
	}
	public static int getCellCount(String path,String sheetName,int row) throws IOException
	{
		 f=new File(path);
		 fis=new FileInputStream(f);
		 wb=new XSSFWorkbook(fis);
		 sheet=wb.getSheet(sheetName);
		 cellCount=sheet.getRow(row).getLastCellNum();
		 fis.close();
	     wb.close();
		 return cellCount;
	}
	public static String getCellData(String path,String sheetName,int row,int col) throws IOException
	{
		 f=new File(path);
		 fis=new FileInputStream(f);
		 wb=new XSSFWorkbook(fis);
		 sheet=wb.getSheet(sheetName);
		 cell = sheet.getRow(row).getCell(col);
		 DataFormatter dataFormatter = new DataFormatter();
	     String value = dataFormatter.formatCellValue(cell);
	     fis.close();
	     wb.close();
	     return value;
	}
}
