package com.nayan;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nayan.service.BookService;
import com.nayan.model.BookModel;

@SpringBootApplication
public class BooksMsApplication {

//	private static String readAll(Reader rd) throws IOException {
//	    StringBuilder sb = new StringBuilder();
//	    int cp;
//	    while ((cp = rd.read()) != -1) {
//	      sb.append((char) cp);
//	    }
//	    return sb.toString();
//	  }
//
//	  public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
//	    InputStream is = new URL(url).openStream();
//	    try {
//	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//	      String jsonText = readAll(rd);
//	      JSONArray json = new JSONArray(jsonText);
//	      return json;
//	    } finally {
//	      is.close();
//	    }
//	  }

	  public static void main(String[] args) throws IOException, JSONException {
		 SpringApplication.run(BooksMsApplication.class, args);
//		  JSONArray json = readJsonFromUrl("https://s3-ap-southeast-1.amazonaws.com/he-public-data/books8f8fe52.json");
//	 
//	    try (FileWriter file = new FileWriter("./src/main/resources/books.json")) {
//            //We can write any JSONArray or JSONObject instance to the file
//            file.write(json.toString()); 
//            file.flush();
// 
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
	   
	    
	  }
	

	@Bean
	CommandLineRunner runner(BookService bookService) {
		return args -> {
			// read JSON and load json
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<BookModel>> typeReference = new TypeReference<List<BookModel>>() {
			};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/books.json");
			try {
				List<BookModel> books = mapper.readValue(inputStream, typeReference);
				bookService.saveBooks(books);
				;
				System.out.println("Books Saved!");
			} catch (IOException e) {
				System.out.println("Unable to save books: " + e.getMessage());
			}
		};
	}
}
