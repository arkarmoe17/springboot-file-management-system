package com.arkarmoe.file_managment_system.report;

import com.arkarmoe.file_managment_system.model.Project;
import com.arkarmoe.file_managment_system.utils.ContentDispositionHeader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Arkar Moe
 * 11-Sept-2019
 * **/
public class Report {

    private static final String FILE_NAME = "./files/Project_Template.xlsx";

    public ResponseEntity<InputStreamResource> exportExcel(List<Project> responses) throws IOException {

        //today
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
        Date today = new Date();
        String currentDate = sdf.format(today);

        FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        CreationHelper creationHelper = workbook.getCreationHelper();

        //read sheet
        Sheet sheet = workbook.getSheet("Project");
        System.out.println("Sheet Name:{}"+sheet.getSheetName());

        // Date cell style
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd"));
        dateCellStyle.setAlignment(HorizontalAlignment.CENTER);
        dateCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dateCellStyle.setBorderBottom(BorderStyle.THIN);
        dateCellStyle.setBorderRight(BorderStyle.THIN);
        dateCellStyle.setBorderLeft(BorderStyle.THIN);
        dateCellStyle.setBorderTop(BorderStyle.THIN);
        dateCellStyle.setWrapText(true);

        //data cell style
        XSSFCellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setWrapText(true);
        //dataStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_25_PERCENT.getIndex());
        //dataStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        //Create a row
        int rowNum =5 ;
        for(Project p :responses){
            Row row = sheet.getRow(rowNum++);

            //cell style
            Cell c1 = row.createCell(0);
            Cell c2 = row.createCell(1);
            Cell c3 = row.createCell(2);
            Cell c4 = row.createCell(3);
            Cell c5 = row.createCell(4);
            Cell c6 = row.createCell(5);
            Cell c7 = row.createCell(6);

            c1.setCellStyle(dataStyle);
            c2.setCellStyle(dataStyle);
            c3.setCellStyle(dataStyle);
            c4.setCellStyle(dataStyle);
            c5.setCellStyle(dataStyle);
            c6.setCellStyle(dateCellStyle);//date
            c7.setCellStyle(dataStyle);

            //set cell data
            c1.setCellValue(p.getSiteCode());
            c2.setCellValue(p.getRegion());
            c3.setCellValue(p.getTowerType());
            c4.setCellValue(p.getTowerHight());
            c5.setCellValue(p.getPartner());
            c6.setCellValue(p.getRfiDate());
            c7.setCellValue(p.getRentalPrice());
        }

        //Resize


        String path = "project_export_"+currentDate+".xlsx";
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        System.out.println("fileOutputStream :>>>>>>>>>>>>"+fileOutputStream);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        System.out.println("resource >>>>>"+resource);
        workbook.write(fileOutputStream);

        MediaType mediaType;
        mediaType = MediaType.valueOf("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

        //close workbook
        fileOutputStream.close();
        workbook.close();

        //get content type header
        HttpHeaders headers = ContentDispositionHeader.getHeader(file);

        return ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(mediaType)
                .body(resource);
    }
}
