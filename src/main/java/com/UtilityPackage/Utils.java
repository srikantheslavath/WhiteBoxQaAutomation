package com.UtilityPackage;

import com.BasePackage.BaseClass;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class Utils extends BaseClass {
    public static long PAGE_LOAD_TIMEOUT=20;
    public static long IMPLICIT_WAIT=10;


    public Utils(){
        super();
    }

    public static Object[][] getExcelData(String filename , String sheetName){
        Object[][] data =null;
        XSSFWorkbook wb = null;
try {
    wb = new XSSFWorkbook("C:\\Users\\Sampath Velupula\\IdeaProjects\\WhiteBoxQaAutomation\\" +
            "src\\main\\resources\\TestData\\Userdatasheet.xlsx");
    XSSFSheet sheet = wb.getSheet(sheetName);
    int rowsIndex = sheet.getLastRowNum();
    data = new Object[rowsIndex][];

    for (int i = 1; i <= rowsIndex; i++) {
        XSSFRow row = sheet.getRow(i);

        int cols = row.getLastCellNum();
        Object[] colData = new Object[cols];

        for (int j = 0; j < cols; j++) {
            colData[j] = row.getCell(j).toString();
        }
        data[i - 1] = colData;
    }
}catch(IOException e){
    e.printStackTrace();
}finally {
    try {
        wb.close();
    }catch(IOException e){
        e.printStackTrace();
}
 return data;
}

    }



}
