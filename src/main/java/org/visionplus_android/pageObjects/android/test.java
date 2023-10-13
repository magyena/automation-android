package org.visionplus_android.pageObjects.android;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "Hello world";
		String[] kata = test.split(" ");
		StringBuilder reversed = new StringBuilder();
		
		for (String word : kata) {
			String terbalik = new StringBuilder(word).reverse().toString();
			reversed.append(terbalik);
		}
		System.out.println(reversed.toString().trim());
	}
	
	
	public static void reverse(String a) {
		String[] kata = a.split(" ");
		for (int i = kata.length -1; i>= 0; i--) {
			String b = kata[i];
			for(int j = b.length() - 1; j>= 0; j--) {
				System.out.print(b.charAt(j));
			}
			System.out.print(" ");
		}
		
	}
	
	

}
