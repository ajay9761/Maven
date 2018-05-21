package Project.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ToolsQA.DemoMavenEclipseProject.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH = "C:/Users/TechproL-6/workspace1/DemoMavenEclipseProject/"
			+ "src/main/java/Project/qa/testdata/DDT.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	//private static Object FileUtils;

	public void SwitchToFrame(){
	driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;
		try{
		file=new FileInputStream(TESTDATA_SHEET_PATH);
		}catch (FileNotFoundException e){
		e.printStackTrace();
		}
		try{
		//Workbook workbook = WorkbookFactory.create(file);
		book=WorkbookFactory.create(file);
		}catch(InvalidFormatException e){
		e.printStackTrace();
		}catch(IOException e){
		e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++){
			for(int k =0;k<sheet.getRow(0).getLastCellNum();k++){
		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
		}
		return data;
	}
	public static void TakeScreenShotEndOfTest() throws IOException{
		// TODO Auto-generated method stub
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/"+ System.currentTimeMillis()+".png"));
		
	}
}


