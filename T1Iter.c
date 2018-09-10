/* Task One In C implement a recursive and an iterative version of a function 
 * which reads characters from stdin until a newline character is read and
 * then prints them on stdout in reverse order. Hint: use getchar(), putchar() (or getc(), putc()). 
 * For the iterative version you may assume a fixed max length of the input.
 * Written by Oscar Eklund
 * Last edited 2018-09-10
 * The program is implemented using a char array and a for loop which
 * adds chars to the array using getchar. If getchar equals a new line
 * the for loop breaks and a new for loop is executed. The second for loop
 * prints out chars from highest index to lowest which reverses input.
 */

#include <stdio.h>

int main() {
	int count;
	char ret[20] = "";
	
	for(int i = 0; i <= 20;) {
		char c = getchar();
	if(c != '\n') {
		ret[i] = c;
		i++;
	}
	else {break;}
	}
	for(int i = 20; i >= 0; i--) {
	
	putchar(ret[i]);
	}
		
}