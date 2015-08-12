import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		InputStream iStream = System.in;
		OutputStream oStream = System.out;
		InputReader in = new InputReader(iStream);
		PrintWriter out = new PrintWriter(oStream);
		Task solver = new Task();
		solver.solve(1, in, out);
		out.close();
	}

}

class Task {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int T = in.nextInt();
		StringBuilder res = new StringBuilder();
		for(int it = 1; it <= T; it++){
			int n = in.nextInt();
			long mikeCost = 0;
			long juiceCost = 0;
			for (int i = 0; i < n; i++) {
				int foo = in.nextInt();
				mikeCost += ((foo + 30) / 30) * 10;
				juiceCost += ((foo + 60) / 60) * 15;
			}
			res.append("Case " + it + ": ");
			if (mikeCost < juiceCost) {
				res.append("Mile " + mikeCost);
			} else if(juiceCost < mikeCost) {
				res.append("Juice " + juiceCost);
			} else {
				res.append("Mile Juice " + juiceCost);
			}
			res.append("\n");
		}
		out.print(res);
	}
}

class InputReader {
	BufferedReader reader;
	StringTokenizer token;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		token = null;
	}

	public String next() {
		while (token == null || !token.hasMoreTokens()) {
			try {
				token = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return token.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}
