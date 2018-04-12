public class Solution {

	public int replaceBlank(char[] string, int length) {
		if ( 0 == length) return length;
		int blankNums = 0;
		for (int i = 0; i < length; i++) {
			if (string[i] == " ") blankNums++;
		}
		int strlen = length + 2 * blankNums;
		int j = 1;
		for (int i = length - 1; i >= 0; i--) {
			if (string[i] != " ") {
				strlen[strlen - j] = strlen[i];
				j++;
			} else {
				string[strlen-j] = '0';  
                j++;  
                string[strlen-j] = '2';  
                j++;  
                string[strlen-j] = '%';  
                j++;  
			}
		}

		return strlen;
	}

}