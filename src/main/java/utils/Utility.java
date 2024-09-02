package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	private static String data;

	public static String getDataFromExcel (String sheet,int row, int cell) throws EncryptedDocumentException, IOException {

	String path= "E:\\Software Testing\\Test Data.xlsx"; 
	FileInputStream file = new FileInputStream(path);
	Cell cells=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell);

	try {

	data=cells.getStringCellValue();

	}

	catch(Exception e) {

	double num=cells.getNumericCellValue();

	int pass =(int) num;

	data=String.valueOf(pass);

	}

	return data;

	}

	public static void takeSnapshot(WebDriver driver, int TestID) throws IOException { 
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss");
		  LocalDateTime now = LocalDateTime.now();

	File src=((TakesScreenshot)driver).getScreenshotAs (OutputType.FILE);

	File dest=new File("E:\\Software Testing\\Screenshots\\Test "+TestID+" "+dtf.format(now)+".jpg");

	

	FileHandler.copy(src, dest);
	}
}
