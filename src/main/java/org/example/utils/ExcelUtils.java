package org.example.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelUtils {

    public String readExcelSheet(int row, int col) {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\akgupta\\Desktop\\workspace\\SampleFramework\\src\\main\\resources\\TestData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            String value = sheet.getRow(row).getCell(col).getStringCellValue();
            return value;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void writeExcelSheet(int row, int col, String message){
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\akgupta\\Desktop\\workspace\\SampleFramework\\src\\main\\resources\\TestData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            if(sheet.getRow(row)==null){
                sheet.createRow(row);
            }
             if(sheet.getRow(row).getCell(col)==null){
                 sheet.getRow(row).createCell(col);
             }

            sheet.getRow(row).getCell(col).setCellValue(message);
             file.close();
            FileOutputStream file1 = new FileOutputStream("C:\\Users\\akgupta\\Desktop\\workspace\\SampleFramework\\src\\main\\resources\\TestData.xlsx");
            workbook.write(file1);
            file1.close();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}