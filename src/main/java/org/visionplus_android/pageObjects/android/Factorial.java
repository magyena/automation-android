package org.visionplus_android.pageObjects.android;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Factorial {
	
	private int numItems;
    private int itemPrice;
    
    public Factorial(int numItems, int itemPrice) {
    	this.numItems = numItems;
    	this.itemPrice = itemPrice;
    }

	
	public int vendingMachine(int reqItems, int money) {
		if(reqItems > numItems) {
			throw new IllegalArgumentException("Not enough items in the machine");
		}
		
		int totalPrice = reqItems * itemPrice;
		
		if(money < totalPrice) {
			throw new IllegalArgumentException("Not enough money");
		}
		
		int kembalian = money - totalPrice;
		numItems = numItems - reqItems;
		
		return kembalian;
	}
	
	public int getItems() {
		return numItems;
	}
	

	public static void main(String[] args) {
		
		System.out.println(compression2("aaabbbccc"));

	}
	
	public static void compression(String a) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String compression2(String s) {
	    String ans = "";
	    for (int i = 0 ; i < s.length(); i++) {
	      int count = 1;
	      while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
	        count++;
	        i++;
	      }
	      ans += s.charAt(i);
	      if (count > 1) {
	        ans += count;
	      }
	    }
	    return ans;
	  }
	
	 public static String compression1(String s) {
		    String ans = "";
		    for (int i = 0 ; i < s.length(); i++) {
		      while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
		        i++;
		      }
		      ans += s.charAt(i);
		    }
		    return ans;
		  }

	public static boolean palindrom(String a) {
		
		Boolean ans = false;
		String rev = "";
		
		for(int i = a.length() - 1;i >= 0; i--) {
			rev = rev + a.charAt(i);
		}
		
		if (a.equals(rev)) {
			ans = true;
		}
		
		return ans;
		
	}
	
	public static void splitArray(int[] arr) {
		Set<Integer> arr1 = new HashSet<>();
		Set<Integer> arr2 = new HashSet<>();
		
		int less45 = 0;
		int more45 = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] <= 45) {
				arr1.add(arr[i]);
			} else if(arr[i] >= 45) {
				arr2.add(arr[i]);
			}
		}
		
		for(int num1 : arr1) {
			less45 += num1;
		}
		
		for(int num2 : arr2) {
			more45 += num2;
		}
		
		int average1 = less45 / arr1.size();
		int average2 = more45 / arr2.size();
		
		System.out.println("Less Than 45: " + arr1 + " average is: " + average1);
		System.out.println("More Than 45: " + arr2 + " average is: " + average2);
		
	}
	
	public static Set<Integer> hapus(int[] arr, int a) {
		Set<Integer> hasil = new HashSet<>();
		
		for(int i = 0; i < arr.length;i++) {
			if(arr[i] != a) {
				hasil.add(arr[i]);
			}
		}
		
		return hasil;
	}
	
	public static List<Integer> terbalik(int[] arr1) {
		List<Integer> hasil = new ArrayList<>();
		
		for(int i = 0; i < arr1.length; i++) {
			int length = arr1.length;
			hasil.add(arr1[length  - 1 - i]);
		}
		
		return hasil;
		
	}
	
	public static void totalUnik(int[] arr) {
		Set<Integer> hasil = new HashSet<>();
		
		for (int i = 0; i < arr.length;i++) {
			hasil.add(arr[i]);
		}
		
		System.out.println("yang unik" + hasil + hasil.size());
		
	}
	
	public static Set<Integer> gabungan(int[] arr1, int[] arr2) {
		Set<Integer> hasil = new HashSet<>();
		
		for(int i = 0; i < arr1.length;i++) {
			hasil.add(arr1[i]);
			for(int j = 0; j < arr2.length;j++) {
				hasil.add(arr2[j]);
			}
		}
		
		return hasil;
	}
	
	public static void keduaTerbesar(int[] arr) {
		List<Integer> simpan = new ArrayList<>();
		
		Arrays.sort(arr);
		int index = arr.length - 1;
		simpan.add(index);
		System.out.println(simpan);
		
		
	}
	
	public static void arraySama(String[] arr1, String[] arr2) {
		Set<String> sama = new HashSet<>();
		
		for(int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					sama.add(arr1[i]);
				}
			}
		}
		System.out.println(sama);
	}
	
	public static int vokalArray(String[] arr) {
		int total = 0;
		
		for(int i = 0; i < arr.length; i++) {
			String w = arr[i].toLowerCase();
			if (w.equals("a") || w.equals("i") || w.equals("u") || w.equals("e")) {
				total++;
			}
		}
		
		return total;
	}
	
	public static int vokal(String vokals) {
		int total= 0;
		
		for(int i = 0; i < vokals.length(); i++) {
			String huruf = vokals.toLowerCase();
			if (huruf.charAt(i) == 'a' ||huruf.charAt(i) == 'i' ||huruf.charAt(i) == 'u' ||huruf.charAt(i) == 'e') {
				total++;
			}
		}
		
		return total;
	}
	
	public static void besarKecil(int[] input) {
		int besar = input[0];
		int kecil = input[0];
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] > besar) {
				besar = input[i];
			} else if (input[i] < kecil) {
				kecil = input[i];
			}
			}
		
		System.out.println("terbesar : " + besar + "terkecil : " + kecil);
		
		}
	
	public static boolean test(int a, int b, int c) {
		if (b > a && c > b) {
			return true;
		} else if (a > b || b > c) {
			return false;
		}
		
		return false;
	}
	
	public static void vowels(String[] arr) {
		Set<String> wadah = new HashSet<>();
		
		for (String wadah1 : arr) {
			wadah.add(wadah1);
		}
		
		System.out.println(wadah);
	}
	
	
	
	public static int factorial(int a) {
		int total = 1;
		
		for(int i = 1; i <= a; i++) {
			total = total * i;
		}
		
		return total;
		
	}

}