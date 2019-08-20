package net.rooban;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private static final String SAMPLE_CSV_FILE_PATH = "./file.csv";

    public void readFileOneByOne() throws Exception {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Id : " + nextRecord[0]);
                System.out.println("Value : " + nextRecord[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entity readFileAll(Integer id) throws Exception {
        Entity entity = new Entity();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
            // Reading Records One by One in a String array
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                if (Integer.parseInt(record[0]) == id) {
                    entity.setId(id);
                    entity.setValue(record[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entity;
    }
}
