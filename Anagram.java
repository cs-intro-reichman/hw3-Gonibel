/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(randomAnagram(""));
		System.out.println(isAnagram("silenttt","silentii"));  // true
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.

	// Returns true if the two given strings are anagrams, false otherwise.
	// Returns true if the two given strings are anagrams, false otherwise.

		// Returns true if the two given strings are anagrams, false otherwise.
		public static boolean isAnagram(String str1, String str2) {
			// Replace the following statement with your code
			str1 = str1.replaceAll(" ", "");
			str2 = str2.replaceAll(" ", "");
			if(str1.length() != str2.length()) {return false;}

			str1 = preProcess(str1).replaceAll(" ", "");
			str2 = preProcess(str2).replaceAll(" ", "");
			char c;
			if(str1.length() != str2.length()) {return false;}
			else {
				while (str1.length() > 0) {
					c = str1.charAt(0);
					if (str2.indexOf(c) == -1) {return false;}
					str1 = DeleteOne(str1, c);
					str2 = DeleteOne(str2, c);
				}
	
			}
			return true;
		}
		   
		// Returns a preprocessed version of the given string: all the letter characters are converted
		// to lower-case, and all the other characters are deleted, except for spaces, which are left
		// as is. For example, the string "What? No way!" becomes "whatnoway"
		public static String preProcess(String str) {
			// Replace the following statement with your code
			String change ="";
			str = str.toLowerCase();
			if (str.length() > 0) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (96 < c && c < 123) {
					change = change + c;
				}
				if (str.charAt(i) == 32) {change = change + c;}
			}
		}
			return change;
		} 
		   
		// Returns a random anagram of the given string. The random anagram consists of the same
		// characters as the given string, re-arranged in a random order. 
		public static String randomAnagram(String str) {
			// Replace the following statement with your code
			String randagram = "";
			char c;
			int index;
			if(str.length() <= 0) {return randagram;}
			else{
			while (str.length() != 1) {
				index = RandomQ(0, str.length());
				c = str.charAt(index);
				randagram = randagram + c;
				str = DeleteOne(str, c);
			}
			c = str.charAt(0);
			randagram = randagram + c;
	
			return randagram;
		}
		}
	
		public static String DeleteOne(String str, char c) {
			int index;
			if (str.indexOf(c) == -1) {return "";}
			else {
				index = str.indexOf(c);
				str = str.substring(0, index) + str.substring(index + 1);
	
			}
			return str;
		}
	
		public static int RandomQ(int min, int max) {
			double x;
			x = ((Math.random() *(max - min)) + min);
			int y = (int) x;
			return y;
		}
			
		
	}
