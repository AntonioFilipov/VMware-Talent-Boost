import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class DownloadFromInternetViaSockets {

	public static void downloadFromNet(URL url, String filename) throws IOException{

		InputStream in = new BufferedInputStream(url.openStream());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		byte[] buf = new byte[2048];
		int n = 0;
		while ((n = in.read(buf)) != -1) {
			out.write(buf, 0, n);
		}
		
		out.close();
		in.close();
		
		byte[] response = out.toByteArray();
		
		FileOutputStream f = new FileOutputStream(filename);
		f.write(response);
		f.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		URL url = new URL("http://stylonica.com/wp-content/uploads/2014/04/Cat-Wallpaper.jpg");
		downloadFromNet(url, "car.jpeg");
	}

}
