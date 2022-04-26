package AAA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;

public class Test {

	public static void main(String[] args) throws IOException {
		
		
		Runnable r =null;
		Thread t =null;
		// TODO Auto-generated method stub
//		OutputStream  os = new FileOutputStream("C:\\Users\\m1380\\Documents\\Garmin\\aaa.txt");
//		os.write(0x31); //ASCII '1'
//		os.flush();
//		os.close();
		
		String filename = "C:\\\\Users\\\\m1380\\\\Documents\\\\Garmin\\\\"; //1我
		File f = new File(filename);
		sop(f.canRead()); 
		sop(f.exists());

		//String filename = "C:\\\\Users\\\\m1380\\\\Documents\\\\Garmin\\\\aaa.txt"; //1我
		InputStream is = new FileInputStream(filename);
//		int a = -1;
//		do {
//			a = is.read();
//			if (a != -1)
//				sop("0x" + Integer.valueOf(a).toHexString(a));
//		} while (a != -1);
//		is.close();

		sop(Charset.defaultCharset());
		Reader rd = new FileReader(filename,Charset.forName("ISO8859-1"));
		int b = -1;
		do {

			b = rd.read();
			if (b != -1)
				System.out.println("0x" + Integer.valueOf(b).toHexString(b));
		} while (b != -1);
		rd.close();

	}

	public static void sop(Object o) {
		System.out.println(o);
	}

}
