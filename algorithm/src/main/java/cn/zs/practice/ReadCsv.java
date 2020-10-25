package cn.zs.practice;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ReadCsv {
    static ArrayList<ArrayList<String>> data = new ArrayList<>();
    public static void main(String args[]){
        readCsv("D:\\data\\data2.csv");
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i < data.size(); i++) {
            String s = data.get(i).get(1);
            String[] s1 = s.split(" ");
            for (int j = 0; j < s1.length; j++) {
                set.add(s1[j]);
            }
        }
        System.out.println(set.size());
    }
    public  static void readCsv(String path) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(new File(path)));
            CSVReader csvReader = new CSVReader(new InputStreamReader(in, "UTF-8"), CSVParser.DEFAULT_SEPARATOR,
                    CSVParser.DEFAULT_QUOTE_CHARACTER, CSVParser.DEFAULT_ESCAPE_CHARACTER, 0);
            String[] strs;
            while ((strs = csvReader.readNext()) != null) {
               data.add(new ArrayList<>(Arrays.asList(strs)));
            }

            csvReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
