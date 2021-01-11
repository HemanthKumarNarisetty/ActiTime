package com.actitime.generics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyValue(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("./data/comman.property");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelValue(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./data/input.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String  value=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void setExcelValue(String sheetName,int row,int cell,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./data/input.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./data/input.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	

}
