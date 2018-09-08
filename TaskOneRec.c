#include <stdio.h>
int count = 0;

int main() { 
    char a[15]; // char array which is used for reversing
	
	void readterminal() { // recursive function for reading stdin
		if(count != 0) { // emptying buffer - otherwise might have problem with \n whenever pressing enter
			while ((getchar()) != '\n') {}
		}
				
		printf("Please enter character # %d", count + 1);
		printf("\n");
		char c = getchar();
		if(c != '\n') { // if character is not a new line, put into array and recall function
			a[count] = c;
			count++; // later used for reversing
			readterminal();
		}
	}
	
	readterminal();
	for(int i = count - 1; i >= 0; i--) { // for loop which begins at highest index
		putchar(a[i]);					  // and as such reverses the chars
		printf("\n");
	}
}


