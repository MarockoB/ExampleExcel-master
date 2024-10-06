package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ExcelRead {
    public static ArrayList<Rectangle> readRectanglesFromExcel(String filePath) throws Exception {
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                double width = row.getCell(0).getNumericCellValue();
                double height = row.getCell(1).getNumericCellValue();
                rectangles.add(new Rectangle(width, height));
            }
        }
        return rectangles;
    }

    public static double calcSortArea(ArrayList<Rectangle> rec) {
        double totalArea = 0;
        for (Rectangle rectangles : rec) {
            totalArea += rectangles.getArea();
        }
        return totalArea / rec.size();
    }

    public static ArrayList<Rectangle> sortRectanglesByArea(ArrayList<Rectangle> sortRec) {
        sortRec.sort(Comparator.comparingDouble(Rectangle::getArea));
        return sortRec;
    }
}