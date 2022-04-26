package AAA;

import java.io.*;
import java.net.*;

public class TalkServer {
	public static void main(String args[]) {
		try {
			ServerSocket server = null;
			try {
				server = new ServerSocket(4700);
			} catch (Exception e) {
				System.out.println("can not listen to:" + e);
			}

			System.out.println("Server listenning on port:4700");
			
			Socket socket = null;
			try {
				socket = server.accept();
			} catch (Exception e) {
				System.out.println("Error." + e);
			}

			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));//键盘输入

			Thread sinThd = new Thread() {
				public void run() {
					try {
						System.out.print("Me:");
						String sinLine = sin.readLine(); 
						while (sinLine != null && !sinLine.equals("bye")) {
							if (sinLine.length() > 0) {
								os.write(sinLine);
								os.flush();
							}
							sinLine = sin.readLine();
						}//while

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			sinThd.start();

			Thread isThd = new Thread() {
				public void run() {
					while (true) {
						try {
							String isLine = is.readLine();
							if (isLine != null && isLine.length() > 0)
								System.out.println("Client:" + isLine);
						} catch (IOException e) {
							e.printStackTrace();
							break;
						}
					}
				}
			};
			isThd.setDaemon(true);
			isThd.start();
			

			sinThd.join();

			os.close(); // 关闭Socket输出流
			is.close(); // 关闭Socket输入流
			socket.close(); // 关闭Socket
			server.close(); // 关闭ServerSocket
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}
	}
}
