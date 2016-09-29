package moofPlClient;

import java.io.BufferedReader;

public class Reader extends Thread {
	BufferedReader in;
	
	public Reader(BufferedReader in) {
		this.in = in;
	}
	
	@Override
	public void run() {
		String line;
		
		
		try {
			while((line = in.readLine()) != null) {
				System.out.println(line);
				if(line.equals("Server shutting down. BYE =3") || line.equals("Bad password!"))
					System.exit(0);
			}
		} catch(Throwable t) {
			t.printStackTrace();
			System.exit(-1000);
		}
	}
}
