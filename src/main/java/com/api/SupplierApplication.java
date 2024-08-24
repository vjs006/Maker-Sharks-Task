package com.api;

// import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.api.service.CSVFileOperations;

@SpringBootApplication
public class SupplierApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierApplication.class, args);

		// CSVFileOperations ops = new CSVFileOperations("src/main/resources/static/Suppliers.csv");
		// List<List<String>> records = ops.getRecords();

		// if (records != null){
		// 	for (List<String> record: records){
		// 		for (String value: record){
		// 			System.out.print(value + "\t");
		// 		}
		// 		System.out.print("\n");
		// 	}
		// }
	}

}
