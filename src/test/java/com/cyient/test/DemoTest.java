package com.cyient.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//we will delete this file
public class DemoTest {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("src/test/resources/testdata/OpenEMRData.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(file); // open
		XSSFSheet sheet = book.getSheet("validCredentialTest");
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getPhysicalNumberOfRows();
		
		Object[][] main= new Object[rowCount -1][cellcount];
		
		for(int r=1; r<rowCount; r++) 
		{ 
			for(int c=0; c<cellcount; c++) 
			{ 
			XSSFRow row = sheet.getRow(r); 
			XSSFCell cell = row.getCell(c); 
			DataFormatter format = new DataFormatter(); 
			String cellValue = format.formatCellValue(cell); 
			System.out.print(cellValue); 
			
			main[r -1][c] = cellValue;
			} 
		}
	}

}