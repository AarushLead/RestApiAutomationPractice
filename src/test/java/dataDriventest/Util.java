package dataDriventest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {
     
	private static File f;
	private static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		
		
			
			 f=new File("D:\\JAVAWORKSPACE\\RestApiAutomationPractice\\excel\\excelread.xlsx");
			 fis=new FileInputStream(f);
			 wb=new XSSFWorkbook(fis);
			 sheet=wb.getSheet("sheet1");
			 Iterator<Row> rowItr = sheet.iterator();
			 while(rowItr.hasNext())
			 {
				   Row row = rowItr.next();
				   Iterator<Cell> cellItr = row.cellIterator();
				   while(cellItr.hasNext())
				   {
					   Cell cell = cellItr.next();
					   switch(cell.getCellTypeEnum())
					   {
					   case BOOLEAN:
						   System.out.print(cell.getBooleanCellValue());
						   break;
					   case STRING:
						   System.out.print(cell.getRichStringCellValue().getString());
						   break;
					   case NUMERIC:
						   if(DateUtil.isCellDateFormatted(cell))
						   {
							   System.out.print(cell.getDateCellValue());
						   }else {
							   System.out.print(cell.getNumericCellValue());
						   }
						   break;
					   case FORMULA:
				            System.out.print(cell.getCellFormula());
				            break;
				        case BLANK:
				            System.out.print("");
				            break;
				        default:
				            System.out.print("");
					   }
					  
				   }
			 }
			 System.out.println("\t");
			
		}

	}
