package com.adactintestscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenSample {

	public static void main(String[] args) throws IOException {
		File f = new File("E:\\KK\\Automation_WS\\Adactin\\src\\test\\resources\\Excel\\TestData.xlsx");
		  FileInputStream fis= new FileInputStream(f);
		  Workbook wb = new XSSFWorkbook(fis);
		  Sheet s = wb.getSheet("data");
		  for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			  Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				System.out.println(c);
			}
		  }
		  
		  

	}

}
