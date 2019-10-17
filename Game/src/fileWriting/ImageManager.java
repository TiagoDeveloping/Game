package fileWriting;

import java.io.File;
import java.io.IOException;

public class ImageManager {

	private String dataPath = "GameData";
	
	private File dataFolder;
	
	private String pathToFile;
	
	private File file;
	
	public ImageManager() {
		return;
	}
	
	public ImageManager(String path) {
		try {
			dataFolder = new File(dataPath);
			
			if (!(dataFolder.isDirectory())) {
				dataFolder.mkdir();
			}
			
			file = new File(dataFolder.getPath() + "/" + path);
			
			this.pathToFile = file.getPath();
			
			if (!(file.exists())) {
				file.createNewFile();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void downloadRemoteImage(String fileName, String url) {
		RemoteFile rf = new RemoteFile(url, fileName);
		this.pathToFile = dataPath + "/" + fileName;
		rf.download();
	}
	
	public File getFile() {
		this.file = new File(this.pathToFile);
		checkCurrentFile();
		return this.file;
	}
	
	public void setFile(String fileName) {
		this.pathToFile = dataPath + "/" + fileName;
		this.file = new File(fileName);
	}
	
	public boolean exists() {
		return this.file.exists();
	}
	
	private void checkCurrentFile() {
		if (!(this.file.exists())) {
			try {
				this.file.createNewFile();
			} catch (IOException e) {
				System.err.println("Could not create file!");
				e.printStackTrace();
			}
		}
	}
	
	
}
