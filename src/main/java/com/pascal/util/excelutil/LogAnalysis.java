/*
package com.pascal.util.excelutil;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogAnalysis {
    private static final Map<String, Date> timeMap = new HashMap<String, Date>() {
        {
            // timeMap.put("zeroBefin", dataFormatter.parse("00:00:00"));
        }
    };
    private static SimpleDateFormat dataFormatter = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");

    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream(new File("E:\\LOG\\20180110\\guizhou0110.xlsx"));
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            int totalSheetCount = workbook.getNumberOfSheets();
            System.out.print("total sheet num" + totalSheetCount + "\t\n");
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            //另一种方法得到ROW
            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row roW = sheet.getRow(rowIndex);
            }
            //调用总条数
            int rowNumOfSheet0 = 0;
            //0至1点调用总数
            int numHour1 = 0;
            int numHour2 = 0;
            int numHour3 = 0;
            int numHour4 = 0;
            int numHour5 = 0;
            int numHour6 = 0;
            int numHour7 = 0;
            int numHour8 = 0;
            int numHour9 = 0;
            int numHour10 = 0;
            int numHour11 = 0;
            int numHour12 = 0;
            int numHour13 = 0;
            int numHour14 = 0;
            int numHour15 = 0;
            int numHour16 = 0;
            int numHour17 = 0;
            int numHour18 = 0;
            int numHour19 = 0;
            int numHour20 = 0;
            int numHour21 = 0;
            int numHour22 = 0;
            int numHour23 = 0;
            int numHour24 = 0;
            //各时段调用总数
            Map<String, Object[]> methodCallPerhourMap = new LinkedHashMap<>();
            //各方法调用总数
            Map<String, Object[]> methodCallMap = new LinkedHashMap<>();
            //各方法超时数
            Map<String, Object[]> methodOvertimeMap = new LinkedHashMap<>();
            //各时段各方法超时数
            List<Map<String, Integer>> overTimeList = new ArrayList<>();
            int overTimeNum = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                rowNumOfSheet0++;
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                //另一种方法得到CELL,得到第一列，计算每个方法调用总数
                Cell ceLL = row.getCell(0);
                String methodName = ceLL.getStringCellValue();
                if (methodCallMap.containsKey(methodName)) {
                    methodCallMap.put(methodName, new Object[]{methodName, Integer.valueOf(String.valueOf(methodCallMap.get(methodName)[1])) + 1});
                } else {
                    int i = 1;
                    methodCallMap.put(methodName, new Object[]{methodName, i});
                }
                //修改第一行标题
                methodCallMap.put("method", new Object[]{"methodName", "callNum"});
                //计算超时
                Cell cell3 = row.getCell(3);
                Cell cell1 = row.getCell(1);
                if (cell3.getCellTypeEnum() == CellType.NUMERIC && cell3.getNumericCellValue() >= 60000) {
                    //超时总数
                    overTimeNum++;
                    //各方法超时数
                    if (methodOvertimeMap.containsKey(methodName)) {
                        methodOvertimeMap.put(methodName, new Object[]{methodName, Integer.valueOf(String.valueOf(methodOvertimeMap.get(methodName)[1])) + 1});
                    } else {
                        int i = 1;
                        methodOvertimeMap.put(methodName, new Object[]{methodName, i});
                    }
                }
                //修改第一行标题
                methodOvertimeMap.put("method", new Object[]{"方法名", "超时总数"});
                //各时段各方法超时数
                Map<String, Integer> tempMap = new HashMap<>();
                if (cell1.getCellTypeEnum() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell1)) {
                    Date date = cell1.getDateCellValue();
                    if (date.before(dataFormatter.parse("2017_12_07 00:59:59")) && date.after(dataFormatter.parse("2017_12_07 00:00:00"))) {
                        if (tempMap.containsKey(methodName)) {
                            tempMap.put(methodName, tempMap.get(methodName) + 1);
                        } else {
                            int i = 1;
                            tempMap.put(methodName, i);
                        }
                    }
                    overTimeList.add(tempMap);
                }
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellTypeEnum() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                        Date date = cell.getDateCellValue();
                        //统计各时段调用
                        if (date.before(dataFormatter.parse("2017_12_07 00:59:59")) && date.after(dataFormatter.parse("2017_12_07 00:00:00"))) {
                            // System.out.println(dataFormatter.format(date)+"\t");
                            numHour1++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 01:59:59")) && date.after(dataFormatter.parse("2017_12_07 01:00:00"))) {
                            numHour2++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 02:59:59")) && date.after(dataFormatter.parse("2017_12_07 02:00:00"))) {
                            numHour3++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 03:59:59")) && date.after(dataFormatter.parse("2017_12_07 03:00:00"))) {
                            numHour4++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 04:59:59")) && date.after(dataFormatter.parse("2017_12_07 04:00:00"))) {
                            numHour5++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 05:59:59")) && date.after(dataFormatter.parse("2017_12_07 05:00:00"))) {
                            numHour6++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 06:59:59")) && date.after(dataFormatter.parse("2017_12_07 06:00:00"))) {
                            numHour7++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 07:59:59")) && date.after(dataFormatter.parse("2017_12_07 07:00:00"))) {
                            numHour8++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 08:59:59")) && date.after(dataFormatter.parse("2017_12_07 08:00:00"))) {
                            numHour9++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 09:59:59")) && date.after(dataFormatter.parse("2017_12_07 09:00:00"))) {
                            numHour10++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 10:59:59")) && date.after(dataFormatter.parse("2017_12_07 10:00:00"))) {
                            numHour11++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 11:59:59")) && date.after(dataFormatter.parse("2017_12_07 11:00:00"))) {
                            numHour12++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 12:59:59")) && date.after(dataFormatter.parse("2017_12_07 12:00:00"))) {
                            numHour13++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 13:59:59")) && date.after(dataFormatter.parse("2017_12_07 13:00:00"))) {
                            numHour14++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 14:59:59")) && date.after(dataFormatter.parse("2017_12_07 14:00:00"))) {
                            numHour15++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 15:59:59")) && date.after(dataFormatter.parse("2017_12_07 15:00:00"))) {
                            numHour16++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 16:59:59")) && date.after(dataFormatter.parse("2017_12_07 16:00:00"))) {
                            numHour17++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 17:59:59")) && date.after(dataFormatter.parse("2017_12_07 17:00:00"))) {
                            numHour18++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 18:59:59")) && date.after(dataFormatter.parse("2017_12_07 18:00:00"))) {
                            numHour19++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 19:59:59")) && date.after(dataFormatter.parse("2017_12_07 19:00:00"))) {
                            numHour20++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 20:59:59")) && date.after(dataFormatter.parse("2017_12_07 20:00:00"))) {
                            numHour21++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 21:59:59")) && date.after(dataFormatter.parse("2017_12_07 21:00:00"))) {
                            numHour22++;
                        } else if (date.before(dataFormatter.parse("2017_12_07 22:59:59")) && date.after(dataFormatter.parse("2017_12_07 22:00:00"))) {
                            numHour23++;
                        } else {
                            numHour24++;
                        }
                        //Date psrseDate = dataFormatter.parse(dataFormatter.format(date));
                    }
                }
            }
            //各时段调用
            methodCallPerhourMap.put("0", new Object[]{"时段", "调用总数"});
            methodCallPerhourMap.put("1", new Object[]{1, numHour1});
            methodCallPerhourMap.put("2", new Object[]{2, numHour2});
            methodCallPerhourMap.put("3", new Object[]{3, numHour3});
            methodCallPerhourMap.put("4", new Object[]{4, numHour4});
            methodCallPerhourMap.put("5", new Object[]{5, numHour5});
            methodCallPerhourMap.put("6", new Object[]{6, numHour6});
            methodCallPerhourMap.put("7", new Object[]{7, numHour7});
            methodCallPerhourMap.put("8", new Object[]{8, numHour8});
            methodCallPerhourMap.put("9", new Object[]{9, numHour9});
            methodCallPerhourMap.put("10", new Object[]{10, numHour10});
            methodCallPerhourMap.put("11", new Object[]{11, numHour11});
            methodCallPerhourMap.put("12", new Object[]{12, numHour12});
            methodCallPerhourMap.put("13", new Object[]{13, numHour13});
            methodCallPerhourMap.put("14", new Object[]{14, numHour14});
            methodCallPerhourMap.put("15", new Object[]{15, numHour15});
            methodCallPerhourMap.put("16", new Object[]{16, numHour16});
            methodCallPerhourMap.put("17", new Object[]{17, numHour17});
            methodCallPerhourMap.put("18", new Object[]{18, numHour18});
            methodCallPerhourMap.put("19", new Object[]{19, numHour19});
            methodCallPerhourMap.put("20", new Object[]{20, numHour20});
            methodCallPerhourMap.put("21", new Object[]{21, numHour21});
            methodCallPerhourMap.put("22", new Object[]{22, numHour22});
            methodCallPerhourMap.put("23", new Object[]{23, numHour23});
            methodCallPerhourMap.put("24", new Object[]{24, numHour24});
            //Blank workbook
            XSSFWorkbook workbookResult = new XSSFWorkbook();
            //数据写入sheet
            LogAnalysis poiWriter = new LogAnalysis();
            XSSFSheet sheet1 = workbookResult.createSheet("各接口调用总数");
            poiWriter.logWrite(sheet1, methodCallMap);
            XSSFSheet sheet2 = workbookResult.createSheet("各时段调用总数");
            poiWriter.logWrite(sheet2, methodCallPerhourMap);
            XSSFSheet sheet3 = workbookResult.createSheet("各方法超时总数");
            poiWriter.logWrite(sheet3, methodOvertimeMap);
            try {
                //Write the workbook in file system
                FileOutputStream out = new FileOutputStream(new File("F:\\result.xlsx"));
                workbookResult.write(out);
                out.close();
                System.out.println("result.xlsx written successfully on disk.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            //System.out.print("0-1调用总数：" + numHour1 + "\t\n");
            // System.out.println("各方法调用总数："+methodCallMap+"\t\n");
            System.out.println("超时总数：" + overTimeNum + "\t\n");
            System.out.println("各方法超时总数：" + methodOvertimeMap + "\t\n");
            System.out.println("各时段各方法超时：" + overTimeList.size() + "\t\n");
            System.out.println("各时段调用总数：" + methodCallPerhourMap + "\t\n");
            System.out.println("各方法调用总数：" + methodCallMap + "\t\n");
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void logWrite(XSSFSheet sheet, Map<String, Object[]> data) {
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            //create a row of excelsheet
            Row row = sheet.createRow(rownum++);
            //get object array of prerticuler key
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
    }
    //写入sheet

    private void PoiWrite(XSSFSheet sheet, Map<String, Integer> data) {
        //Iterate over data and write to sheet
        Set<String> keySet = data.keySet();
        int rowNum = 0;
        for (String key : keySet) {
            //create a row of excelSheet
            Row row = sheet.createRow(rowNum++);
            //int cellNum = 0;
            int numValue = data.get(key);
            Cell cell = row.createCell(0);
            cell.setCellValue(numValue);
        }
    }
}


*/
