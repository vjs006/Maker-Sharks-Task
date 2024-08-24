package com.api.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVFileOperations {
    private String filePath;
    private List<List<String>> records;

    public CSVFileOperations(String filePath) {
        this.filePath = filePath;
        this.records = new ArrayList<>();
        readFile();
    }
    
    private void readFile(){
        try (FileReader fileReader = new FileReader(this.filePath);
            CSVReader csvReader = new CSVReader(fileReader)){
            List<String[]> allData = csvReader.readAll();

            for (String[] nextRecord : allData) {
                ArrayList<String> record = new ArrayList<String>();
                for (String val : nextRecord) {
                    record.add(val);
                }
                this.records.add(record);
            }
        } catch (IOException e) {
            records = null;
            System.err.println("Error while reading CSV file: " + e.getMessage());
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public List<List<String>> getRecords() {
        return records;
    }
}
