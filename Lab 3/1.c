/*Task One
* Written by Oscar Eklund
* Last edited 2018-09-26
* Program takes an text input through command line and
* replaces every other non alphabetical, blank or new line, with a blank.
*/

#include <stdio.h>
#include <ctype.h>

int main() {
	char ch;
	FILE *filepointer;
	int count = 0;
	filepointer = fopen("output.txt", "w");
	
	while((ch = getchar()) != EOF) { // while input is not empty
		if (isalpha(ch)) { // if char is not an alphabetic character, blank or new line
			putc(ch, filepointer); // add it to output file
		}
		else {
			/*count++; // counter to replace only every other with a blank
			if(count % 2 == 0) {
			putc(' ', filepointer);
			}*/
			putc(' ', filepointer);
		}
	}
}