
public class ReverseChars {
	
	public static void ReverseChars() {
		Stack ReverseStack = new Stack(100);
		while(true) {
			char a = StdIn.readChar();
			if(a != '\n') {
				ReverseStack.push(a);
			}
			else { break; }
		}
		
		for(int i = ReverseStack.size(); i > 0; i--) {
			StdOut.print(ReverseStack.pop());
		}
	}


}
