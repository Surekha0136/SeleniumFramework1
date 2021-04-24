package lib;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	  XSSFWorkbook wb;
	  XSSFSheet sheet;
	  public ExcelDataConfig(String ExcelPath)
	  {
	  try 
	  {
		  File src = new File (ExcelPath);
		  FileInputStream fis = new FileInputStream(src);
		  wb = new XSSFWorkbook(fis);
		  
	  }
	  catch(Exception e)
	  {
		  System.out.println(e.getMessage());
	  }
	  }
		  public String getData(int SheetNumber,int row,int column)
		  {
	          sheet = wb.getSheetAt(SheetNumber);
	          String data = sheet.getRow(row).getCell(column).getStringCellValue();
	          return data;
		  }
		  
		  public int getRowCount(int SheetIndex)
		  {
			  int row = wb.getSheetAt(SheetIndex).getLastRowNum();
			  row=row+1;
			  return row;
		  }
	  }



	

	


