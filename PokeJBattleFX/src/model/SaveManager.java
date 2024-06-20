package model;

import java.util.*;
import java.io.*;
import java.lang.reflect.Type;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


public class SaveManager {
	
	public static boolean newSave(Allenatore trainer) {
		
		String savePath = "src/saves.json";
		Gson salvatore = new Gson();
		
		boolean result = true;
		
		try {
			if(SaveManager.loadSave(trainer.getNickname())!= null && loadSave(trainer.getNickname()).getNickname().equals(trainer.getNickname())) {
				System.out.println(trainer.getNickname() + " gia' esistente");
				return false;
			}
			
			FileReader saveFileToRead = new FileReader(savePath);
			BufferedReader reader = new BufferedReader(saveFileToRead);
			
			ArrayList<Allenatore> lista = salvatore.fromJson(reader.readLine(), ArrayList.class);
			reader.close();
			lista.add(trainer);		
			
			
			FileOutputStream saveFileToWrite = new FileOutputStream(savePath);
            BufferedOutputStream writer = new BufferedOutputStream(saveFileToWrite);
            
            writer.write(salvatore.toJson(lista).getBytes());
            writer.flush();
            writer.close();
			
		} catch (Exception e) {
			System.out.println("shit");
			 result = false;
		}
		
		return result;
	}
	
	public static Allenatore loadSave(String nickname) {
		
		String savePath = "src/saves.json";
		Gson salvatore = new Gson();
		
		Allenatore save = null;
		
		try {
			FileReader saveFileToRead = new FileReader(savePath);
			BufferedReader reader = new BufferedReader(saveFileToRead);
			
			Type listType = new TypeToken<ArrayList<model.Allenatore>>() {}.getType();
	        List<model.Allenatore> lista = salvatore.fromJson(reader.readLine(), listType);
			
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNickname().equals(nickname)) {
					save = lista.get(i);
				}
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return save;
	}
	
	public static void save(Allenatore trainer) {
		
		String savePath = "src/saves.json";
		Gson salvatore = new Gson();
		
		try {
			FileReader saveFileToRead = new FileReader(savePath);
			BufferedReader reader = new BufferedReader(saveFileToRead);
			
			Type listType = new TypeToken<ArrayList<model.Allenatore>>() {}.getType();
	        List<model.Allenatore> lista = salvatore.fromJson(reader.readLine(), listType);
	        
	        for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNickname().equals(trainer.getNickname())) {
					lista.set(i, trainer);
				}
			}
	        reader.close();
	        
	        FileOutputStream saveFileToWrite = new FileOutputStream(savePath);
            BufferedOutputStream writer = new BufferedOutputStream(saveFileToWrite);
            
            writer.write(salvatore.toJson(lista).getBytes());
            writer.flush();
            writer.close();
	        
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static List getSaves() {
		
		String savePath = "src/saves.json";
		Gson salvatore = new Gson();
		
		Type listType = new TypeToken<List<model.Allenatore>>() {}.getType();
		 List<model.Allenatore> dati = null;
		
		try {
			FileReader saveFileToRead = new FileReader(savePath);
			BufferedReader reader = new BufferedReader(saveFileToRead);
			
	        dati = salvatore.fromJson(reader.readLine(), listType);

		} catch (Exception e) {
			
		}	
		return dati;
	}	
	
}
