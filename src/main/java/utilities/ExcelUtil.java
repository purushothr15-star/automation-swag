package utilities;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {

    public static String getData(String sheetName, String columnName, int rowNum){
            String data = null;
            XSSFWorkbook workbook;
            XSSFSheet sheet;
            try{
                FileInputStream fis = new FileInputStream("C:\\Users\\aishw\\PurushothProjects\\swag-labs-automation\\src\\main\\resources\\Test Data.xlsx");
                   workbook = new XSSFWorkbook(fis) ;
                   sheet = workbook.getSheet(sheetName);
                   Row row = sheet.getRow(rowNum);
                   int lastCell = row.getLastCellNum();
                   for(int i=0; i<lastCell;i++){
                       data = row.getCell(i).getStringCellValue();
                       if(data==columnName)break;
                       return data;
                   }

            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return data;
    }
}
