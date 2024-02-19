package POM;

import io.cucumber.java.sl.Ce;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DeleteThisClass {
    public static void main(String[] args) throws IOException {
     getDataFromExel();
    }


    public static void getDataFromExel() throws IOException {
        ArrayList<String>arrayListusername=new ArrayList<>();
        ArrayList<String>arrayListPassword=new ArrayList<>();
        ArrayList<String>arrayListProducts=new ArrayList<>();
       FileInputStream f=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Exel\\Exeldocuments2.xlsx");
       XSSFWorkbook workbook=new XSSFWorkbook(f);
       XSSFSheet sheet=workbook.getSheetAt(2);
       int countofrow=sheet.getPhysicalNumberOfRows();
        Row row=sheet.getRow(0);
        Iterator<Cell>cellIterator =row.cellIterator();
        cellIterator.next();
        while (cellIterator.hasNext()){
            arrayListusername.add(cellIterator.next().getStringCellValue());
        }
        Row rowpassword= sheet.getRow(1);
        Iterator<Cell>cellIteratorPassword=rowpassword.cellIterator();
        cellIteratorPassword.next();
        while (cellIteratorPassword.hasNext()){
            arrayListPassword.add(cellIteratorPassword.next().getStringCellValue());
        }
        Row rowProducts=sheet.getRow(2);
        Iterator<Cell>cellIteratorProducts=rowProducts.cellIterator();
        cellIteratorProducts.next();
        while (cellIteratorProducts.hasNext()){
            arrayListProducts.add(cellIteratorProducts.next().getStringCellValue());
        }


    }
}
