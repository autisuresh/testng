package data.driven.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public ArrayList<String> getData(String testcaseName) throws IOException {

        FileInputStream fis = new FileInputStream("D://javap//sample-demo//TestNG//Book1.xlsx");
        ArrayList<String> arr = new ArrayList<>();
        // accept file input stream argument
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i=0; i<sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();

                Iterator<Cell> cellIterator = firstrow.cellIterator();
                int k=0;
                int column = 0;
                while(cellIterator.hasNext()){
                    Cell value =cellIterator.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Testcases")){
                        column=k;
                    }
                    k++;
                }
                //System.out.println(column);

                while (rows.hasNext()){
                   Row row = rows.next();
                   if(row.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)){
                       Iterator<Cell> cells = row.cellIterator();
                       while (cells.hasNext()) {
                           //System.out.println(cells.next().getStringCellValue());
                           arr.add(cells.next().getStringCellValue());
                       }

                   }
                }
            }
        }
        return arr;
    }

    @Test
    public void testData() throws IOException {
        ArrayList<String> arrdata = this.getData("Purchase");
        arrdata.forEach(System.out::println);
    }
}
