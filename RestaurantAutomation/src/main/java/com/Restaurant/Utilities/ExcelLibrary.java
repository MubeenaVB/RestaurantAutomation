package com.Restaurant.Utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {

	public ArrayList<String> getData(String Testcase) throws Exception {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fil = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/DataDriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fil);
		int sheets = 0;
		// Accessing the sheets of the workbook
		sheets = wb.getNumberOfSheets();
		// iterating through all the sheets and finding the required one
		for (int i = 0; i < sheets; i++) {
			// fetching the required sheet
			if (wb.getSheetName(i).equalsIgnoreCase("TestData")) {
				// working on the right sheeet
				XSSFSheet sheet = wb.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator();
				// getting access to the specific row which is the first row

				Row firstrow = rows.next();
				// once is the column is identified;scan for Sadmin

				Iterator<Cell> cel = firstrow.cellIterator();
				int k = 0;
				int col = 0;
				// Identifying the coulmn TestCases by scanning the entire row using cell
				// iterator
				while (cel.hasNext()) {
					Cell value = cel.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						col = k;
					}
					k++;
				}
				// now scan the entire row and get all the deatils in the row
				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(col).getStringCellValue().equalsIgnoreCase(Testcase)) {
						Iterator<Cell> cell = r.cellIterator();
						cell.next();
						while (cell.hasNext())
						// type = string
						{
							Cell c = cell.next();
							if (c.getCellType() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}

					}

				}
			}

		}
		return a;
	}

}