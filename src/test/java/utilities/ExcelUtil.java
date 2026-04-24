package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    private static final Logger logger = LogManager.getLogger(ExcelUtil.class);

    public static Object[][] getTestData(String sheetName) {
        Object[][] data = null;
        try {
            String path = ConfigReader.getProperty("testdata.path");
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            data = new Object[rowCount][colCount];
            DataFormatter formatter = new DataFormatter();

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i + 1);
                for (int j = 0; j < colCount; j++) {
                    if (row != null) {
                        Cell cell = row.getCell(j);
                        data[i][j] = formatter.formatCellValue(cell);
                    }
                }
            }
            workbook.close();
            logger.info("Read test data from sheet: " + sheetName);
        } catch (IOException e) {
            logger.error("Error reading test data file", e);
        }
        return data;
    }
}
