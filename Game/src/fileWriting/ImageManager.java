package fileWriting;

import java.io.File;
import java.io.IOException;

public class ImageManager {

	private String dataPath = "GameData";
	
	private File dataFolder;
	
	public ImageManager() {
		return;
	}
	
	public ImageManager(String path) {
		try {
			dataFolder = new File(dataPath);
			
			if (!(dataFolder.isDirectory())) {
				dataFolder.mkdir();
			}
			
			File file = new File(dataFolder.getPath() + "/" + path);
			
			if (!(file.exists())) {
				file.createNewFile();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void downloadRemoteImage(String fileName, String url) {
		RemoteFile rf = new RemoteFile(url, fileName);
		rf.download();
	}
	
}
