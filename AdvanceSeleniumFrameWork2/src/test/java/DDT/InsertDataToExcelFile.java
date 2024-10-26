package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelFile {

	public static void main(String[] args) throws Throwable {

FileInputStream fis = new FileInputStream("./src/test/resources/TestData2pm.xlsx");

Workbook book = WorkbookFactory.create(fis);
	
Sheet sheet = book.getSheet("Sheet1");
	
Row row = sheet.createRow(6);

Cell cel = row.createCell(6);
	
cel.setCellValue("http://localhost:8888");

FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData2pm.xlsx");
book.write(fos);
book.close();

	
	}

}
