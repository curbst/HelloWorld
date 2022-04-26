package AAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TalkClient_twothread2 {
	public static void main(String args[]) {

		try {
			Socket socket = new Socket("www.sierracollege.edu", 80); //http: 80
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			SendThd send = new SendThd(os, sin);

			ReceiveThd receive = new ReceiveThd(is);

			send.start();
			receive.setDaemon(true);
			receive.start();
			
			try {
				send.join();
				receive.join();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			os.close();
			is.close();
			socket.close();
			

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class SendThd extends Thread
{
	
	private PrintWriter os;
	private BufferedReader sin;
	public SendThd(PrintWriter os, BufferedReader sin) {
		this.os=os;
		this.sin=sin;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run()
	{
		
		String readline = null;
		try {
			//System.out.println("Me: ");
			readline = sin.readLine();
			while (!readline.equals("bye")) {
				if(readline.equals("HTTP")) {
					String req = "GET / HTTP/1.1\r\n" + 
						"Host: www.sina.com.cn\r\n" + 
						"User-Agent: Mozilla/5 MSIE\r\n" + 
						"Accept: */*\r\n" + 
						"Accept-Language: zh-CN,en\r\n"+
						"\r\n";
				
					char [] charry = req.toCharArray();
					os.write(charry,0,charry.length);
					os.flush();
				}
				System.out.println("...send '" + readline + "' success!");

				//System.out.println("Me: ");
				readline = sin.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}



class ReceiveThd extends Thread
{
	private BufferedReader br_is;
	
	public ReceiveThd(BufferedReader is){
		br_is = is;
	}
	public void run()
	{
		try {
			while (true) {
				String line = br_is.readLine();
				System.out.println(line);
				if (line == null) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}