package com.vtiger.genericlib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream("../VTiger/src/main/resources/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}

	public String getExcelData(String sheetName, int rowNum, int cellNum) throws IOException {
		FileInputStream fis = new FileInputStream("../VTiger/src/main/resources/WorkBook.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String data = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}

	public void setExcelData(String sheetName, int rowNum, int cellNum, String data)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("../VTiger/src/main/resources/WorkBook.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./WorkBook.xlsx");
		wb.write(fos);
		wb.close();
	}
}
