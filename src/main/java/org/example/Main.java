package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Rectangle> rectangles = ExcelRead.readRectanglesFromExcel("Example.xlsx");
        double sortArea = ExcelRead.calcSortArea(rectangles);
        ArrayList<Rectangle> sortRec = ExcelRead.sortRectanglesByArea(rectangles);

        System.out.println("Средняя площадь всех прямоугольников: " + sortArea);
        System.out.println("Сортировка по площади: ");
        for (Rectangle rect : sortRec) {
            System.out.println(rect);
        }

    }
}