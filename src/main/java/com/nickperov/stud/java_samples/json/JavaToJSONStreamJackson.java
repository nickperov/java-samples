package com.nickperov.stud.java_samples.json;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class JavaToJSONStreamJackson {
	
	public static void main(String[] args) {
		
		Product prd1 = new Product(777, "Handbag", 1000.00);
		JsonFactory factory = new JsonFactory();
		
		try (OutputStream fos = new FileOutputStream("product_from_stream_" + new Date().getTime() + ".json");
				JsonGenerator jsonGenerator = factory.createGenerator(fos, JsonEncoding.UTF8);) {
			
			jsonGenerator.writeStartObject();
			
			jsonGenerator.writeNumberField("id", prd1.id);
			jsonGenerator.writeStringField("name", prd1.name);
			jsonGenerator.writeNumberField("price", prd1.price);
			
			jsonGenerator.writeEndObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
