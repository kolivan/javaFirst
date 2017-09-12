package helpers;

import au.com.bytecode.opencsv.CSVReader;
import org.hellojavaer.poi.excel.utils.ExcelUtils;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by bigdrop on 9/12/2017.
 */
public class CsvReader {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("src/main/resources/location.csv");
        Scanner testScanner = new Scanner(new BufferedReader(new FileReader("src/main/resources/location.csv")));

        while (testScanner.hasNextLine())
        {
            System.out.println(testScanner.nextLine());
        }
    }


}
