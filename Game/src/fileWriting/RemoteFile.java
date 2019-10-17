package fileWriting;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import Main.MainGameClass;

public class RemoteFile {

	private File file;
	
	private String url;
	
	@SuppressWarnings("unused")
	private String fileName;
	
	public RemoteFile(String urlToWebContent, String fileName) {
		file = new File(MainGameClass.dataFolderPath + "/" + fileName);
		this.url = urlToWebContent;
		this.fileName = fileName;
	}
	
	public void download() {
		try {
			URL url = new URL(this.url);
			InputStream in = new BufferedInputStream(url.openStream());
			OutputStream out = new BufferedOutputStream(new FileOutputStream(file));

			for (int i; (i = in.read()) != -1; ) {
			    out.write(i);
			}
			
			in.close();
			out.close();
			
		} catch (IOException e) {
			System.err.println("Unable to download file. Please check your wifi conenction.");
			e.printStackTrace();
		}
	}
	
	public boolean fileExists() {
		return this.file.exists();
	}
	
	public void createFile() {
		try {
			this.file.createNewFile();
		} catch (IOException e) {
			System.err.println("Could not create file!");
			e.printStackTrace();
		}
	}
	
}
