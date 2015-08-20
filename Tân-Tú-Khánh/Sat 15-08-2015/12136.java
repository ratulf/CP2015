package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int n = in.nextInt();
		for (int i = 1; i <= n; i++) {
			String a = in.next();
			String b = in.next();
			String c = in.next();
			String d = in.next();
			String[] k = a.split(":");
			int wife1 = Integer.parseInt(k[0])*60 + Integer.parseInt(k[1]);
		
			k = b.split(":");
			int wife2 = Integer.parseInt(k[0])*60 + Integer.parseInt(k[1]);
			
			k = c.split(":");
			int meet1 = Integer.parseInt(k[0])*60 + Integer.parseInt(k[1]);
		
			k = d.split(":");
			int meet2 = Integer.parseInt(k[0])*60 + Integer.parseInt(k[1]);
			
			if(wife1 > meet2){
				System.out.println("Case " + i +": Hits Meeting");
			}else if(wife2 < meet1){
				System.out.println("Case " + i +": Hits Meeting");
			} else {
				System.out.println("Case " + i +": Mrs Meeting");
			}
			
		}
	}
}
class InputReader {
	StringTokenizer tokenizer;
	BufferedReader reader;

	public InputReader(InputStream stream) {
		tokenizer = null;
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
	}

	public String next() {
		while ((tokenizer == null) || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}
