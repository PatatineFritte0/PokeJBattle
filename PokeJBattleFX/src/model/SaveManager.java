package model;
import com.google.gson.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;



public class SaveManager {
	
	private String genericPath;
	
	SaveManager() {
		this.genericPath = "src/saves/";
	}
	
	public Allenatore newSave(String nickname, Pokemon[] pokemon) {
		
		Gson c = new Gson();
		
		Allenatore a = new Allenatore(nickname, pokemon, 0, 0);
		
		String json = c.toJson(a);
		System.out.println(a);
		/*
		String path = this.genericPath + nickname + ".json";
		File f = new File(path);
		try {
			if(f.createNewFile()) {
				System.out.println("File creato");
			} else {
				System.out.println("File già esistente");
			}
		} catch (IOException e) {
			System.out.println("Errore nella creazione");
		}
		*/		
		return a;
	}
}
