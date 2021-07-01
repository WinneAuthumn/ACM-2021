import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class NumberSpiral {

	public static void main(String[] args) {
		StringBuilder outputBuffer = new StringBuilder();
		int noOfTests = ni();

		while (noOfTests > 0) {
			long row = nl();
			long column = nl();
			long result = 0;

			long max = Long.max(row, column);
			long min = Long.min(row, column);

			if (max % 2 == 0) {
				long temp = row;
				row = column;
				column = temp;
			}

			if (column == max) {
				result = column * column - row + 1;
			} else {
				result = row * row - 2 * row + column + 1;
			}

			outputBuffer.append((result)).append("\n");
			noOfTests--;
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
//double row = nd();
//double column = nd();
//double result = 0;
//if (row > column) {
//	result = (Math.pow(row / column, 2) - 1 / column) * Math.pow(column, 2) + 1;
//}
//if (column > row) {
//	result = (Math.pow(column / row, 2) - 1 / row) * Math.pow(row, 2) + 1;
//	result = Math.pow(column, 2) - row + 1;
//}
//if (row == column) {
//	result = (Math.pow(row / column, 2) - 1 / column) * Math.pow(column, 2) + 1;
//}
//outputBuffer.append((long) result).append("\n");
//noOfTests--;