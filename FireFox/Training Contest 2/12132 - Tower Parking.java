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
		for (int it = 1; it <= T; it++) {
			int h = in.nextInt();
			int l = in.nextInt();
			List<Car>[] a = new List[h];
			int cnt = 0;
			HashMap<Integer, Integer> carAt = new HashMap<>();
			for (int i = 0; i < h; i++) {
				a[i] = new ArrayList<Car>();
				for (int j = 0; j < l; j++) {
					int foo = in.nextInt();
					if (foo != -1) {
						carAt.put(foo - 1, i);
						a[i].add(new Car(j, foo - 1));
						++cnt;
					}
				}
			}
			long cost = 0;
			for (int car = 0; car < cnt; car++) {
				int where = carAt.get(car);
				cost += where * 20;
				int sz = a[where].size();
				List<Car> cars = a[where];
				int curPos = -1;
				for (int j = 0; j < sz; j++) {
					if (a[where].get(j).car == car) {
						curPos = a[where].get(j).pos;
					}
				}
				int need = 0;
				if (curPos > (l - curPos)) {
					need = l - curPos;
				} else {
					need = -curPos;
				}
				cost += Math.abs(need) * 5;
				a[where] = new ArrayList<Car>();
				for (int j = 0; j < sz; j++) {
					int pos = ((cars.get(j).pos + need) + l) % l;
					a[where].add(new Car(pos, cars.get(j).car));
				}
			}
			res.append(cost);
			res.append("\n");
		}
		out.print(res);
	}
}

class Car {
	int pos;
	int car;

	public Car(int pos, int car) {
		this.pos = pos;
		this.car = car;
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
