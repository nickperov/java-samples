package com.nickperov.stud.java_samples.json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

public class JavaToJSONObject {
	
	public static void main(String[] args) {
		
		Product prd1 = new Product(777, "Handbag", 1000.00);
		
		String fileName = "product_from_object_" + new Date().getTime() + ".json";
		
		try(OutputStream fos = new FileOutputStream(fileName);
				JsonWriter jsonWriter = Json.createWriter(fos)) {
			
			
			JsonObjectBuilder prdBuilder = Json.createObjectBuilder();
			
			prdBuilder.add("id", prd1.id);
			prdBuilder.add("name", prd1.name);
			prdBuilder.add("price", prd1.price);
			
			JsonObject prdJsonObject = prdBuilder.build();
			
			System.out.println("prdJsonObject: " + prdJsonObject);
			
			jsonWriter.writeObject(prdJsonObject);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Read and parse newly created file back
		try(InputStream fis = new FileInputStream(fileName);
				JsonReader jsonReader = Json.createReader(fis)) {
			
			System.out.println("Read Object:" + jsonReader.readObject());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
