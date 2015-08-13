package reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem12195 {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		String str = "";
		while(!str.equals("*")){
			str = in.next();
			if(str.equals("*")){
				break;
			}
			double sum = 0;
			int  sum_res = 0;
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '/'){
					if(sum ==1){
						sum_res += 1;
					}
					sum = 0;
				}
				switch (str.charAt(i)) {
				case 'W':
					sum +=1;
					break;

				case 'H':
					sum +=0.5;
					break;
				case 'Q':
					sum +=0.25;
					break;
				case 'E':
					sum += 0.125;
					break;
				case 'S':
					sum += 0.0625;
					break;
				case 'T':
					sum += 0.03125;
					break;
				case 'X':
					sum += 0.015625;
					break;
				
				}
			}
			System.out.println(sum_res);
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
