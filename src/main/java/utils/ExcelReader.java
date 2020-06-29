package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

//import com.App.qa.utils.CommonFunctions;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;

//import com.App.qa.testBase.Testbase;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;

public class ExcelReader {

private static XSSFSheet ExcelWSheet;
private static XSSFWorkbook ExcelWBook;
private static XSSFCell Cell;
private static XSSFRow Row;


	
	public static void setExcelFile(String Path, String SheetName) throws Exception{
		try {
			// Open the Excel file
			
			FileInputStream ExcelFile = new FileInputStream(Path);
			
			// Access the required test data sheet
			
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			
			throw (e);
		}
	}
	
	public static HashMap<String,String> getTableArray(String FilePath, String SheetName, int iTestCaseRow) throws Exception{

		String[] tabArray = null;
		
		 HashMap<String,String> currentHash = new HashMap<String,String>();
		
		try {
			
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			
			// Access the required test data sheet
			
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			
			int totalCols = getColumnUsed();
			
			tabArray=new String[totalCols-1];
			
			for(int j=1;j<totalCols;j++)
			{
				
//				tabArray[j-1]=getCellData(iTestCaseRow,j);
				currentHash.put(getCellData(0,j), getCellData(iTestCaseRow,j));
				System.out.println(currentHash);
			}
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("Could not read the Excel sheet");
			
			e.printStackTrace();
		}
		
		return (currentHash);
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception{
		
		try {
			
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			
			String CellData = Cell.getStringCellValue();
			
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String getTestCaseName(String sTestCase) throws Exception{
		
		String value = sTestCase;
		
		try {
			
			int posi = value.indexOf("@");
			
			value = value.substring(0,posi);
			
			posi = value.lastIndexOf(".");
			
			value = value.substring(posi+1);
			
			return value;
		} catch (Exception e)
		{
			throw(e);
		}
	}
	
	
public static int getRowContains(String sTestCaseName, int colNum) throws Exception{
	
	int i;
	
	try {
		
		int rowCount = ExcelReader.getRowUsed();
		
		for(i=0;i<rowCount;i++)
		{
			if(ExcelReader.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)) {
				break;
			}
		}
		
		return i;
	} catch (Exception e) {
		
		throw (e);
	}
}
	
public static int getRowUsed() throws Exception{
	
	try {
		
		int RowCount = ExcelWSheet.getLastRowNum()+1;
		
		return RowCount;
		
	}catch (Exception e) {
	
		System.out.println(e.getMessage());
		
		throw (e);
	}
}

public static int getColumnUsed() throws Exception{
	
	try {
		
		int ColumnCount = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
		
		return ColumnCount;
		
	}catch (Exception e) {
	
		System.out.println(e.getMessage());
		
		throw (e);
	}
}

public static List<HashMap<String,String>>  getExcelData(String sTestCaseName, String fileLoc, String sheetName) throws Exception{

	int i;
	int rowCount = ExcelReader.getRowUsed();
	int usefulRows = 0;
	for(i=1;i<rowCount;i++) {
		if(ExcelReader.getCellData(i,0).equalsIgnoreCase(sTestCaseName)) {
			usefulRows++;
		}		
	}
	
	Object [][] tabArray = null;

	 HashMap<String,String> currentHash = new HashMap<String,String>();
	 List<HashMap<String,String>> mydata = new ArrayList<>();
	 
	tabArray = new String[usefulRows][ExcelReader.getColumnUsed()-1];
	
	try {
		int currentRow = 0;
		for( i=1;i<rowCount;i++) {
			
			if(ExcelReader.getCellData(i,0).equalsIgnoreCase(sTestCaseName)) {
				
				currentHash=getTableArray(fileLoc, sheetName,i);
				currentRow++;
			
			
			
			if(!currentHash.isEmpty()) {
			mydata.add(currentHash);
			System.out.println(mydata);
//			currentHash.clear(); 
			}
			}
		}
		
		return mydata;
	}catch (Exception e) {
	
		throw (e);
	}
}

public static HashMap<String,String> storeValues = new HashMap();
public static List<HashMap<String,String>> data(String filepath,String sheetName)
{
   List<HashMap<String,String>> mydata = new ArrayList<>();
   try
   {
      FileInputStream fs = new FileInputStream(filepath);
      XSSFWorkbook workbook = new XSSFWorkbook(fs);
      XSSFSheet sheet = workbook.getSheet(sheetName);
      XSSFRow HeaderRow = sheet.getRow(0);
//      System.out.println("HeaderRow"+HeaderRow);
      System.out.println("Rows"+sheet.getPhysicalNumberOfRows());
      for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
      {
         XSSFRow currentRow = sheet.getRow(i);
//         System.out.println("currentRow"+currentRow);
         HashMap<String,String> currentHash = new HashMap<String,String>();
         System.out.println("column"+currentRow.getPhysicalNumberOfCells());
         for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
         {
            XSSFCell currentCell = currentRow.getCell(j);
//            switch (currentCell.getCellType())
            {
//            case Cell.CELL_TYPE_STRING:
//               System.out.println(HeaderRow.getCell(j).getStringCellValue()+"  "+currentCell.getStringCellValue());
               currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
//               break;
            }
         }
         mydata.add(currentHash);
//         System.out.println(mydata);
      }
      fs.close();
   }
   catch (Exception e)
   {
      e.printStackTrace();
   }
   return mydata;
}


//public static String getScreenShot() {
//	TakesScreenshot ts = (TakesScreenshot) driver;
//	File src = ts.getScreenshotAs(OutputType.FILE);
//	String path = filePath+"\\screenshots\\"+System.currentTimeMillis()+".png";
//	File defile = new File(path);
//	try {
//		FileUtils.copyFile(src, defile);
//	}
//	catch (Exception e) {
//		
//		System.out.println("Capture failed"+e.getMessage());
//		
//	}
//	return path;
//}

	
}
