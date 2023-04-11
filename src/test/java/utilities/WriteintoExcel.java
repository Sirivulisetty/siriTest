package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteintoExcel {
public  void writeProductDetails(int r,int col,String data) throws IOException {
String path = "C:\\Users\\INCAPSULATE\\eclipse-workspace\\Flipkart.com\\productDetails.xlsx";
FileInputStream fs = new FileInputStream(path);
Workbook wb = new XSSFWorkbook(fs);
Sheet sheet1 = wb.getSheetAt(0);
int lastRow = sheet1.getLastRowNum();
for(int i=0; i<=lastRow; i++){
Row row = sheet1.getRow(r);
Cell cell = row.createCell(col);

cell.setCellValue(data);

}

FileOutputStream fos = new FileOutputStream(path);
wb.write(fos);
fos.close();
}

}