/* Task Six
 * Written By Oscar Eklund
 * Last Edited 2018-09-30
 * resize(String[] array) doubles size of array
 * positions(String[] array, String word) prints out all positions of word (characters from beginning)
 */
public class CharCounter {
	
	public static void main(String[] args) {
		String wordIn = args[0];
		String words[] = new String[4];
		int count = 0;
		while(!StdIn.isEmpty()) { // inserts words from stdin to words-array
			if(count >= words.length) {
				words = resize(words);
			}
			words[count] = StdIn.readString();
			count++;
		}
		/*for(int i = 0; i < 10; i++) {
			StdOut.print(words[i] + " ");
		}*/
		positions(words, wordIn);
	}
	
	public static String[] resize(String[] array) { // double array size
		String newarray[] = new String[(array.length * 2)];
		for(int i = 0; i < array.length; i++) { // copies all values
			newarray[i] = array[i];
		}
		return newarray;
	}
	
	public static void positions(String[] array, String word) {
		int pos = 0;
		StdOut.print("Found at following positions: ");
		for(int i = 0; i < array.length; i++) {
			if(array[i] != null) {
				if(array[i].equals(word)) { // if found correct words, print pos
					StdOut.print(pos + " ");
				}
				pos = pos + array[i].length();
			}
			else pos++;
		}
	}
}
