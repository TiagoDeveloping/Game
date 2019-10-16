package fileWriting;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class RemoteFile {

	private File file;
	
	private String url;
	private String fileName;
	
	public RemoteFile(String urlToWebContent, String fileName) {
		this.url = urlToWebContent;
		this.fileName = fileName;
	}
	
	public void download() {
		try {
			file = new File(ConfigurationFileManager.getPathInDataFolder(fileName));
			
			if (!(file.exists())) {
				file.createNewFile();
			}
			
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
}
