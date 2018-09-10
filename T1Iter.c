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