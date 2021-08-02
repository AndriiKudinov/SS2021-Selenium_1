package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    private static final String projectPath = System.getProperty("user.dir");

    private static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(projectPath + "/src/main/resources/excel/Data.xlsx");
        } catch (IOException e) {
            System.out.println("There is no data!");
            System.exit(1);
        }
    }

    public static String getStringValue(String sheetName, int index) {
        XSSFSheet sheet = workbook.getSheet(sheetName);
        return sheet.getRow(1).getCell(index).getStringCellValue();
    }

    public static int getNumericValue(String sheetName, int index) {
        XSSFSheet sheet = workbook.getSheet(sheetName);
        return (int) sheet.getRow(1).getCell(index).getNumericCellValue();
    }
}
