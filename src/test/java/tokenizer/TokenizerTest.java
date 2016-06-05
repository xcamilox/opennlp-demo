package tokenizer;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import gpac.TokenizerMain;
import junit.framework.AssertionFailedError;



public class TokenizerTest {
	
	String fileInput;
	String[] expectedResult ={"I", "was", "born",
		"in",
		"the",
		"year",
		"1632",
		",",
		"in",
		"the",
		"city",
		"of",
		"York",
		",",
		"of",
		"a",
		"good",
		"family"};
	
	/**
	 * This method initialize the URL file for data tokenizer's test 
	 * @return void
	 */
	
	@Before
	public void setUp() throws Exception {
		this.fileInput = "demo_data/data.txt";
				
	}
	
	/**
	 * This method tested the tokenizer class,
	 * a give URL of English text file and print a list of tonkens and compere with expected tonkens  
	 * @return void
	 */
	
	@Test
	public void testTokenizer() throws Exception {
		try{
			String[] tokens = TokenizerMain.tokenizeFile(this.fileInput);
			for(int i = 0; i < tokens.length; i++){
				 assertEquals(expectedResult[i], tokens[i]);
			}
		}catch(IOException e){
			System.out.println("Error reading file");
		}
	}
	
	/**
	 * This method tested the tokenizer class and expected an error, due not match tonkens list
	 *   
	 * @return void
	 */
	@Test()
	public void failtTestTokenizer() throws Exception{
		String[] expectedResultErro ={"error","tokens"};
		try{
			String[] tokens = TokenizerMain.tokenizeFile(this.fileInput);
			for(int i = 0; i < tokens.length; i++){
				 assertEquals(expectedResultErro[i], tokens[i]);
			}
		}catch(AssertionFailedError e){
			System.out.println("Error:tonkens not match ");
			
		}
		catch(IOException e){
			System.out.println("Error reading file");
		}
	} 
	
}
