package com.green.rfp.qa.base;

public class stringreg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String st = "Showing 1 - 2 of 2 entries";

		System.out.println(st.matches("Showing.*") && st.matches(".*entries") && st.contains(" of "));
		System.out.println(st.matches(".*entries"));
		System.out.println();
	}

}
