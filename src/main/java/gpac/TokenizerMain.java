package gpac;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

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
		}

	}

	public static void tokenizeFile(String fileUrl)throws Exception {

		// the model we trained
		InputStream modelIn = new FileInputStream("models/en-token.model");
		File file = new File(fileUrl);
		FileReader fileContent = new FileReader(file);
		
		fileContent.
		try {
			TokenizerModel model = new TokenizerModel(modelIn);

			Tokenizer tokenizer = new TokenizerME(model);

			/*
			 * note what happens with the "three depending on which model you
			 * use
			 */
			String[] tokens = tokenizer.tokenize("A ranger journeying with Oglethorpe, founder of the Georgia Colony, "
					+ " mentions \"three Mounts raised by the Indians over three of their Great Kings"
					+ " who were killed in the Wars.\"");

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
	}
}
