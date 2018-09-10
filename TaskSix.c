/* Task Six 
 * Written by Oscar Eklund
 * Last edited 2018-09-10
 * The program is implemented using a while loop which continuously runs getchar
 * if getchar equals EOF (end of file) then print whether file is balanced
 * if getchar equals left ( ({[ ) then adds one to countleft
 * and the same for right ( )}] ). Last it checks whether countright equals countleft
 * and prints result. 
 */
#include <stdio.h>

int main() {
	int countleft;
	int countright;
	char c;
	while(1) {
		c = getchar();
		if(c ==  EOF) { break; }
		if(c == '(' || c == '{' || c == '[') {
			countleft++;
		}
		if (c == '}' || c == ']' || c == ')') {
			countright++;
		}
	}
	if(countright == countleft) {printf("balanced");}
	else if(countright < countleft) {printf("check )}]");}
	else if(countleft < countright) {printf("check ({[");}
}