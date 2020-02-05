package zref.fileio.csv;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class CSVReaderExample {

    public static void main(String[] args) {

        String csvFile = "src\\test\\resources\\data\\csvdata\\country.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile),'#');
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Country [Field1= " + line[0] + ", code= " + line[4] + " , name=" + line[5] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
