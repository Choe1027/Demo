package com.choe.easysql.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cyk
 * @date 2018/8/23/023 17:45
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
public class PoiImport {


    public static void importExcel(){
        try {
            String path = "C:\\Users\\Administrator\\Desktop\\student.xls";
            FileInputStream fis = new FileInputStream(new File(path));
            Workbook work = new HSSFWorkbook(fis);


            Sheet sheet = null;
            Row row = null;
            Cell cell = null;

//            List<Object> list = new ArrayList<List<Object>>();
            //遍历Excel中所有的sheet
            for (int i = 0; i < work.getNumberOfSheets(); i++) {
                sheet = work.getSheetAt(i);
                if(sheet==null){continue;}

                //遍历当前sheet中的所有行
                for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                    row = sheet.getRow(j);
                    if(row==null||row.getFirstCellNum()==j){continue;}

                    System.out.println("====="+j+"===start=====");
                    //遍历所有的列
                    List<Object> li = new ArrayList<Object>();
                    for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                        cell = row.getCell(y);

                        int cellType = cell.getCellType();
                        switch (cellType){

                            case 0:  // 数字
                                double numericCellValue = cell.getNumericCellValue();
                                System.out.print(numericCellValue);
                                break;
                            case 1: // 字符串
                                String stringCellValue = cell.getStringCellValue();
                                System.out.print(stringCellValue);
                                break;
                        }

                    }
                    System.out.println("====="+j+"===end=====");
//                    list.add(li);
                }
            }
//            return list;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        importExcel();
    }
}
