package Bai1;

public class MathFunc {
	int calls;

	public int getCalls() {
		return calls;
	}

	public long factorial(int n) {
		calls++;
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		long res = 1;
		if (n > 1) {
			for (int i = 1; i <= n; i++) {
				res *= i;
			}
		}
		return res;
	}

	public long plus(int n1, int n2) {
		calls++;
		return n1 + n2;
	}
}
