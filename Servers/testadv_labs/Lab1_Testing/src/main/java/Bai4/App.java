package main.java.Bai4;

import java.text.DecimalFormat;

public class App {
	public String ptBac1(double a, double b) {
		String res = "";
		if (a == 0) {
			if (b == 0) {
				res = "vsn";
			} else {
				res = "vn";
			}
		} else {
			res = String.valueOf(new DecimalFormat("#.##").format(-b / a));
		}
		return res;
	}
}
