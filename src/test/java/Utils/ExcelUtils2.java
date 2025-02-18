package Utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils2 {

    public static Object[][] getHotelSearchData(String filePath) {
        Object[][] data = null;
        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][columnCount];  // Exclude header row

            for (int i = 1; i < rowCount; i++) {  // Start from row 1 to exclude header
                Row row = sheet.getRow(i);
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                data[i - 1][j] = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                                    data[i - 1][j] = cell.getDateCellValue();
                                } else {
                                    data[i - 1][j] = cell.getNumericCellValue();
                                }
                                break;
                            case BOOLEAN:
                                data[i - 1][j] = cell.getBooleanCellValue();
                                break;
                            default:
                                data[i - 1][j] = null;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
