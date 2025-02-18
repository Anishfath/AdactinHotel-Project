package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils1 {

    public static Object[][] getTestData(String excelFilePath) {
        Object[][] data = null;
        
        try {
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // Assuming you're working with the first sheet

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells(); // Get number of columns from the first row

            data = new Object[rowCount - 1][colCount]; // Skip header row

            // Start reading data from row 1 (skip header)
            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    switch (cell.getCellType()) {
                        case STRING:
                            data[i - 1][j] = cell.getStringCellValue();
                            break;
                        case BOOLEAN:
                            data[i - 1][j] = cell.getBooleanCellValue();
                            break;
                        case NUMERIC:
                            data[i - 1][j] = cell.getNumericCellValue();
                            break;
                        default:
                            data[i - 1][j] = "";  // If the cell is empty, handle accordingly
                    }
                }
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
