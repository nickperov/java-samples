package com.nickperov.stud.java_samples.json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.json.Json;
import javax.json.stream.JsonGenerator;


public class JavaToJSONStreaming {
	
	
	public static void main(String[] args) {
		
		Product prd1 = new Product(777, "Handbag", 1000.00);
		
		try (OutputStream fos = new FileOutputStream("product_from_stream_" + new Date().getTime() + ".json");
				JsonGenerator jsonGenerator = Json.createGenerator(fos);) {
			
			jsonGenerator.writeStartObject();
			
			jsonGenerator.write("id", prd1.id);
			jsonGenerator.write("name", prd1.name);
			jsonGenerator.write("price", prd1.price);
			
			jsonGenerator.writeEnd();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
