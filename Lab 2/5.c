 #include <stdio.h>
 int main() {
	int size = 7; // input of array is not stated to be a part of the task
	int array[] = {1, 4, -5, 3, -2, 0, -1}; // therefor i simply create an array and state its size
	sortNegative(array, size);
	printArray(array, size);
 }
 

 
int sortNegative(int arr[], int size) { // function checks whether a value is positive and if it is then
	for(int i = 0; i < size; i++) { // check whether there are any negative values in a higher index
		if(arr[i] > 0) { // if such a value exists then simply switch places and repeat for a higher index.
			for(int j = i + 1; j < size; j++) {
				if(arr[j] < 0) {
					int temp = arr[i];  // temp value required O(1) extra memory
					arr[i] = arr[j];
					arr[j] = temp;
					j = size;
				}
			}
		}
	}		
 }
 
 
 int printArray(int arr[], int size) { // simple function which prints the array, used for debugging and displaying 
	 for(int i = 0; i < size; i++){  // that the sortNegative function actually works.
		  printf("%d ", arr[i]);
	 }
 }