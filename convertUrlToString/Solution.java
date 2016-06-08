package convertUrlToString;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Solution {
	public static void main(String[] args) {
		try {
			String webPage = "http://www.google.com";
			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			
			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			
			String result = sb.toString();
				
			System.out.println("BEGIN***");
			System.out.println(result);
			System.out.println("END*****");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
