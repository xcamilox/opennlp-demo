package tokenizer;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import gpac.TokenizerMain;



public class TokenizerTest {
	
	String fileInput;
	
	/**
	 * This method initialize the URL file for data tokenizer's test 
	 * @return void
	 */
	
	@Before
	public void setUp() throws Exception {
		this.fileInput = "demo_data/data.txt";	
	}
	
	/**
	 * This method tested the tokenizer class, a give URL of English text file and print a list of tonkens  
	 * @return void
	 */
	
	@Test
	public void testTokenizer() throws Exception {
		try{
			String[] tokens = TokenizerMain.tokenizeFile(this.fileInput);
			for (String token : tokens) {
				System.out.println(token);
			}
		}catch(IOException e){
			System.out.println("Error reading file");
		}
	}
	
}
