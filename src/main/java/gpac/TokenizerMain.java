package gpac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class TokenizerMain {
	/**
	 * This print a list of tokens from a Text given. The url argument must
	 * specify an absolute {@link URL}. The name argument is a specifier that is
	 * relative to the url argument.
	 * <p>
	 * This method always returns immediately, whether or not the If the file
	 * donsen't exist will be throw an exception
	 *
	 * @param args
	 *            a List of URL giving the base location of the text file to
	 *            tokenizer
	 * @return void
	 * @see opennlp.tools.tokenize.Tokenizer
	 */
	public static void main(String[] args) throws Exception {

		// the provided model
		// InputStream modelIn = new FileInputStream( "models/en-token.bin" );
		if (args.length > 0 ){
			
			tokenizeFile(args[0]);
			//tokenizeFile("demo_data/data.txt");
			
		}

	}

	public static String[] tokenizeFile(String fileUrl)throws Exception {
		
		String[] tokens = null;
		// the model we trained
		InputStream modelIn = new FileInputStream("models/en-token.model");
		byte[] encoded = Files.readAllBytes(Paths.get(fileUrl));
		String textContent =  new String(encoded, Charset.defaultCharset());
		
		try {
			TokenizerModel model = new TokenizerModel(modelIn);

			Tokenizer tokenizer = new TokenizerME(model);

			/*
			 * note what happens with the "three depending on which model you
			 * use
			 */
			tokens = tokenizer.tokenize(textContent);

			for (String token : tokens) {
				System.out.println(token);
			}
			
		

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
				}
			}
		}
		System.out.println("\n-----\ndone");
		return tokens;
		
	}
}
