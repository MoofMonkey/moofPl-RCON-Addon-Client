package moofPlClient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Main {
	public static final BufferedReader inS = new BufferedReader(new InputStreamReader(System.in));
	public static final BufferedWriter outS = new BufferedWriter(new OutputStreamWriter(System.out));
	public static final String pwd = "okQT4tn*)6O0#8o(i3**6FJl%25cc2g%R&v*3x12st*(feZ49i()UFP882#4y*0fCE%4#XZ4M(254V*R";
	public static final int port = 10032;
	
	
	public static void main(String[] args) throws Throwable {
		Socket s = null;
		String ip = assertNotNull(args, 0);
		BufferedReader br;
		BufferedWriter bw;
		
		
		System.out.println("Trying to connect to IP " + ip + "...");
		
		try {
			s = new Socket(ip, port);
		} catch(Throwable t) {
			new Throwable("Cannot connect to moofPl's RCON.", t).printStackTrace();
			System.exit(-1);
		}
		
		System.out.println("Connected!");
		
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		new Reader(br).start();
		
		String line;
		bw.write("PWD " + pwd + "\n");
		while(!s.isClosed() && (line = inS.readLine()) != null)
			bw.write(line + "\n");
	}



	private static String assertNotNull(String[] s, int i) throws Throwable {
		if(s == null || s.length-1 < i)
			throw new Throwable("Incorrect argument");
		
		
		return s[i];
	}
}
