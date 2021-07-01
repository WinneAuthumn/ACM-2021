import java.util.*;
import java.io.*;

public class TwoSets {

	public static void main(String[] args) {
		StringBuilder outputBuffer = new StringBuilder();
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();

		int number = ni();
		double sum =(double) number * (number + 1) / 2;
		if (sum % 2 == 1) {
			outputBuffer.append("NO");
		} else {
			outputBuffer.append("YES\n");
			int i = 1;
			int j = number;
			int temp = number / 2;
			while (i < j) {
				if (temp != 0) {
					listA.add(j);
					j--;
					temp--;
				}
				if (temp != 0) {
					listA.add(i);
					i++;
					temp--;
				}

				if (temp == 0) {
					listB.add(i);
					listB.add(j);
					i++;
					j--;
				}
			}
			Collections.sort(listA);
			Collections.sort(listB);

			int size = listA.size();
			outputBuffer.append(size).append("\n");
			for (i = 0; i < listA.size(); i++) {
				outputBuffer.append(listA.get(i)).append(" ");
			}
			size = listB.size();
			outputBuffer.append("\n").append(size).append("\n");
			for (i = 0; i < listB.size(); i++) {
				outputBuffer.append(listB.get(i)).append(" ");
			}
		}
		System.out.println(outputBuffer);
	}

	static InputStream is = System.in;

	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static float nf() {
		return Float.parseFloat(ns());
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}
