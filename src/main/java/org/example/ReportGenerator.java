package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ReportGenerator {

    public static void generateXLSX(String fileName){

        try (Workbook workbook = new XSSFWorkbook();)
        {
            Sheet sheet = workbook.createSheet("Sheet 1");
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("From");
            row.createCell(1).setCellValue("Date");
            row.createCell(2).setCellValue("Category");
            row.createCell(3).setCellValue("Subject");

            try (FileOutputStream out = new FileOutputStream(fileName);)
            {
                workbook.write(out);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void addDataToSheet(String fileName, ArrayList<Mail> mails){
        File file = new File(fileName);
        if (!(file.exists() && file.isFile())){
            System.out.println("Cannot find file: " + fileName);
            return;
        }

        try (FileInputStream in = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(in);)
        {
            Sheet sheet = workbook.getSheet("Sheet 1");
            if (sheet == null) {
                System.out.println("Sheet not found, creating new one.");
                sheet = workbook.createSheet("Sheet 1");
            }

            int lastRow = sheet.getLastRowNum();
            for (Mail mail : mails) {
                Row row = sheet.createRow(lastRow++);
                row.createCell(0).setCellValue(mail.getSenderMail());
                row.createCell(1).setCellValue(mail.getDate());
                row.createCell(2).setCellValue(mail.getCategory());
                row.createCell(3).setCellValue(mail.getSubject());
            }
            try (FileOutputStream out = new FileOutputStream(file)) {
                workbook.write(out);
                out.close();
                System.out.println("Data added to file");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
