package fileWriting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class FileManager {
	
	private File file;
	private String name;
	
	private String path = "GameData";
	
	private File dataFolder;
	
	public FileManager(String fileName) {
		dataFolder = new File(path);
		
		if (!(dataFolder.isDirectory())) {
			dataFolder.mkdir();
		}
		
		this.file = new File(dataFolder.getPath() + "/" + fileName);
		this.name = file.getName();
	}
	
	public void clear() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(file);
			try {
				out.flush();
			} catch (IOException e) {
				System.err.println("Could not clear the file!");
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
		}
	}
	
	public void delete() {
		file.delete();
	}
	
	public void dump() {
			Properties propperties = getCurrentProperty();
			System.out.println(propperties);
	}
	
	public String read(String path) {
		checkFile();
		String data = "";
		try {
			FileInputStream in = new FileInputStream(file);
			Properties properties = new Properties();
			try {
				properties.load(in);
			} catch (IOException e) {
				System.err.println("Could not load the file!");
			}
			
			try {
				data = properties.getProperty(path);
			} catch (NullPointerException e) {
				throw new NullPointerException("Could not find property: " + path);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Could not find the file: " + file.getName());
		}
		return data;
	}

	public void write(String path, String data) {
		checkFile();
		Properties properties = getCurrentProperty();
		try {
			OutputStream out = new FileOutputStream(file);
			//System.out.println("done");
			
			properties.setProperty(path, data);
			properties.store(out, null);
			out.close();
		} catch(IOException e) {
			System.err.println("Could not find file: " + name);
			System.out.println();
			e.printStackTrace();
		}
	}
	
	private Properties getCurrentProperty() {
		Properties inp = new Properties();
		try {
				FileInputStream in = new FileInputStream(file);
			inp.load(in);
			for (Object key : inp.keySet()) {
				//System.out.println(key.toString());
				inp.setProperty((String) key, inp.getProperty((String)key));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inp;
	}
	
	private void checkFile() {
		if (!(file.exists())) {
			try {
				file.createNewFile();
			} catch(IOException e) {
				System.err.println("Could not create file: " + name);
				e.printStackTrace();
			}
		}
	}
	
}
