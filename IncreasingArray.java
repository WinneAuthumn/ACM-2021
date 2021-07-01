import java.util.*;
import java.io.*;

public class IncreasingArray {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder outputBuffer = new StringBuilder();
		List<Long> list = new ArrayList<Long>();

		int number = reader.nextInt();
		long moves = 0;

		for (int i = 0; i < number; i++) {
			list.add(reader.nextLong());
		}
		for (int i = 1; i < number; i++) {
			if (list.get(i) < list.get(i - 1)) {
				long distance = list.get(i - 1) - list.get(i);
				moves += distance;
				list.set(i, list.get(i) + distance);
			}
		}
		
		outputBuffer.append(moves);
		System.out.println(outputBuffer);
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
