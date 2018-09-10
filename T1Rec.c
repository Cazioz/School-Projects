/* Task One In C implement a recursive and an iterative version of a function 
 * which reads characters from stdin until a newline character is read and
 * then prints them on stdout in reverse order. Hint: use getchar(), putchar() (or getc(), putc()). 
 * For the iterative version you may assume a fixed max length of the input.
 * Written by Oscar Eklund
 * Last edited 2018-09-10
 *
 * 
 * 
 */

#include <stdio.h>

int main() {
	char rev;
	if((rev = getchar()) != '\n')
	{
		main();
		putchar(rev);
	}
}