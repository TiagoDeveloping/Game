package arenaCreator;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import fileWriting.ImageManager;

@SuppressWarnings("serial")
public class LoadingScreen extends JComponent {

	private String screenFileName = "loadingScreen.png";
	private String urlToLoadingScreen = "https://lh3.googleusercontent.com/yOkNXW96KJornR3Z3ETfG6RA3mKTwjGj9e_lNRRNJM65ZbqttOm4IIG8oYeahdJFKZ0n6OWrfKNFZMfmoB4zoBN3sGILiYEsP7coFxAwko4iNgaEbtYa0QQV0pmTZGuyJT_HUMbWBe_JWZE3S3l8VTrRKqmHPaQwVQBDm4NSP_h27nShoap4CN8rrALhNZl1O2_kj1WiL1e2CBW_PsUuvrKN0ld65hpVLa2LwJlhkYp4imCIusVgxS_lhUerDijM7ubHPkd3rS2SBGQWuQFfS_gD-e0K7xa8BpeSECBfInacrbXioprZPIkPRHaZG3wPr_IcD5MulGYfzc0PwyKxKQjFz0G2SpT4I7TYvJKfb1ovPl5dRqzvgTGa9lTG87KGGcprNMRngJLae2_yzYtAk9qQHNY-QU8dJ5Xm27JAlGA_sOPLmQ19hiQD78nZ6nTpikDCUu-HU5n9FsnJJA0UdjVHhAjiKCuNQdzdW61rBsb4bVZ1bC44EtvLJ8CceLY6yPqXXDXu2rKevEp1ctqLyibtgZNZ01rj6awWW6zKZ3JN8a33NksJFULk2fJMnVtuyMtw-VWjw0sufvGzQ14DaWfBhrFbzymZt_rQC9nJC0pZNyAp6Nq3786XDYk=w2880-h1678";
	
	private Image loadingScreen;
	
	private ImageManager iMng = new ImageManager(screenFileName);
	
	public LoadingScreen() {
		iMng.setFile(screenFileName);
		
		if (!(iMng.exists())) {
			iMng.downloadRemoteImage(screenFileName, urlToLoadingScreen);
		}
		
		try {
			loadingScreen = ImageIO.read(iMng.getFile());
		} catch (IOException e) {
			System.err.println("Could not read the loadingScreen file!");
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(loadingScreen, 0, 0, null);
		
	}
	
	public void update() {
		this.repaint();
	}
	
}
