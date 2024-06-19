package model;
import java.io.*;
import java.time.LocalDate;
import com.google.gson.*;


public class SaveManager {
	
	private String savePath;
	private Gson salvatore;
	
	SaveManager() {
		this.savePath = "src/saves.json";
		this.salvatore = new Gson();
	}
	
	public Allenatore newSave(String nickname, Pokemon[] pokemon) {
		
		Allenatore trainer = new Allenatore(nickname, pokemon, 0, 0);
		
		String trainerJson = salvatore.toJson(trainer);

		try {
			
			FileReader saveFileToRead = new FileReader(this.savePath);
			BufferedReader reader = new BufferedReader(saveFileToRead);

			String data = "";
            while(reader.readLine() != null) {
            	data += reader.readLine() + "\n";
            }
            data += trainerJson;
            System.out.println(data);
			
            FileOutputStream saveFileToWrite = new FileOutputStream(this.savePath);
            BufferedOutputStream writer = new BufferedOutputStream(saveFileToWrite);
            
            writer.write(data.getBytes());
            writer.close();
		} catch (Exception e) {
			
		}
		
		return trainer;
	}
}
