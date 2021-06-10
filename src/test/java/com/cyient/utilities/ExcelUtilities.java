package com.cyient.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public static Object[][] getSheetIntoObjectArray(String filelink, String excelsheetname) throws IOException {
		
		FileInputStream file = new FileInputStream(filelink);
		XSSFWorkbook book = new XSSFWorkbook(file); 
		XSSFSheet sheet = book.getSheet(excelsheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] main = new Object[rowCount - 1][cellCount];
		for (int r = 1; r < rowCount; r++) {
			for (int c = 0; c < cellCount; c++) {
				XSSFRow row = sheet.getRow(r);
				XSSFCell cell = row.getCell(c);
				DataFormatter format = new DataFormatter();
				String cellValue = format.formatCellValue(cell);
				System.out.println(cellValue);
				main[r - 1][c] = cellValue;
			}
		}
		return main;
	}

}