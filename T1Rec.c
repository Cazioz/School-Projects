/* Task One In C implement a recursive and an iterative version of a function 
 * which reads characters from stdin until a newline character is read and
 * then prints them on stdout in reverse order. Hint: use getchar(), putchar() (or getc(), putc()). 
 * For the iterative version you may assume a fixed max length of the input.
 * Written by Oscar Eklund
 * Last edited 2018-09-10
 * The first char is saved in rev (if rev != '\n') and then main is called again 
 * and the next char is also saved in rev, however rev is an instance variable
 * and as such it is not saved into the same memory space
 * and as such as soon as the nth rev == '\n' the nth - 1 (the last) instance of main executes putchar(rev)
 * and then the nth - 2 executes and so forth until all instances of main have been executed
 * and as such all chars have been printed - in the reverse order.
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