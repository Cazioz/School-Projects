#include <stdio.h>
int count = 0;
char c = 'a';

int main() { 
    char a[15]; // char array which is used for reversing
	
	
	while (1) {
		if(count != 0) { // emptying buffer - otherwise might have problem with \n whenever pressing enter
			while ((getchar()) != '\n') {}
		}
		printf("Please enter character # %d", count + 1);
		printf(" : ");
		char c = getchar();	
		if(c != '\n'){
			a[count] = c;
			count++;
		}
		else break;
	}
	for(int i = count; i >= 0; i--) {
		putchar(a[i]);
		printf("\n");
	}
		
	
	
}


