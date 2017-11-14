package test;
import java.io.IOException;
import java.io.OutputStream;

public class OutPutStreamTest {

	public static void generateChar(OutputStream out) throws IOException{
		int firstPrintableChar = 33;
		int numOfPrintableChars = 94;
		int numOfCharPerLine = 72;
		
		int start = firstPrintableChar;
		while(true) {
			for (int i = start; i < start + numOfCharPerLine; i++) {
				out.write(( (i - firstPrintableChar) % numOfPrintableChars) + firstPrintableChar);
			}
			out.write('\r');
			out.write('\n');
			
			start = ((start + 1) - firstPrintableChar)
					% numOfPrintableChars + firstPrintableChar;
		}
	}
	public static void main(String[] args) throws IOException {
		
		OutPutStreamTest outT = new OutPutStreamTest();
		OutputStream out = null;
		OutPutStreamTest.generateChar(out);

	}

}
