package AAA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DownloadSong {
	public static void main(String[] args) {
		String path = "/Users/weilezheng/Desktop/TesterSong.mp3";
		sop("Tester");
		//try-with-resource
		try (
			 FileInputStream  input = new FileInputStream(path);
			 FileOutputStream output = new FileOutputStream(new File("/Users/weilezheng/Desktop/TesterSong2.mp3"))
			) 
		   {
			int n;
			while ((n = input.read()) != -1) { // 0-255 1byte
				output.write(n);
			//  assertEquals(path, "/Users/weilezheng/Desktop/TesterSong2.mp3");
			}
		} catch (Exception e) {
			sop(e.getStackTrace());
		}
	}

	public static void main2(String[] args) throws Exception {
		String path = "/Users/weilezheng/Desktop/TesterSong.mp3";
		sop("Tester");
		FileInputStream input = null;
		FileOutputStream output = null;

		try {
			input = new FileInputStream(path);

			output = new FileOutputStream(new File("/Users/weilezheng/Desktop/TesterSong2.mp3"));

			int n;
			while ((n = input.read()) != -1) { // 0-255 1byte
				output.write(n);

				// assertEquals(path, "/Users/weilezheng/Desktop/TesterSong2.mp3");
			}
		} catch (Exception e) {
			sop(e.getStackTrace());
		} finally {
			try {
				input.close();
				output.close();
			} catch (Exception e) {

			}
		}
	}

	static void sop(Object line) {
		System.out.println(line);

	}

}