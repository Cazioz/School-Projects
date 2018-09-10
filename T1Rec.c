#include <stdio.h>

int main() {
	char rev;
	if((rev = getchar()) != '\n')
	{
		main();
		putchar(rev);
	}
}