package deltaXProject.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import deltaXProject.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;

	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "testData/TestData.xlsx";

	private static XSSFSheet ExcelWSheet;

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method
	public static void loadTestData() {

		try {

			// Open the Excel file
			InputStream stream = TestUtil.class.getClassLoader().getResourceAsStream(TESTDATA_SHEET_PATH);

			// Access the required test data sheet

			XSSFWorkbook ExcelWBook = new XSSFWorkbook(stream);

			ExcelWSheet = ExcelWBook.getSheet("Sheet1");

		} catch (Exception e) {

		}

	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) {

		try {

			XSSFCell cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue();

			case Cell.CELL_TYPE_NUMERIC:
				Integer val = new Double(cell.getNumericCellValue()).intValue();
				return val.toString();
			default:
				return "";
			}

		} catch (Exception e) {

			throw new RuntimeException("Failed to get data", e);

		}

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}

}
