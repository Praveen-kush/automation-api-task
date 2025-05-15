package Excel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static Object[][] readExcel(String filePath) {
		try {
			FileInputStream file = new FileInputStream(filePath);
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
			int totalRows = sheet.getPhysicalNumberOfRows();
			int totalCols = sheet.getRow(0).getLastCellNum();
			for(int i = 0; i < totalRows; i++) {
				Row row = sheet.getRow(i);
				for(int j = 0; j < totalCols; j++) {
					Cell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value + "\t");	
				}
				System.out.println();
			}
			workbook.close();
			file.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		Object[][] data = null;
		return data;
	}

}
