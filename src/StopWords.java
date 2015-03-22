import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class StopWords {
	public static void stopwords(FileReader filereader, Variables variables){
		int count = 0;
		String filedirectory = new File("").getAbsolutePath();
		String filepath = filedirectory + "\\" + "stopwords.txt";
		String set;
		BufferedReader reader = null;
	    FileInputStream fis = null;
	    try{
			fis = new FileInputStream(filepath); 
	        reader = new BufferedReader(new InputStreamReader(fis));
	        String line;
	        StringTokenizer stringtokenizer = null;
	        while ((line = reader.readLine()) != null){
	        	stringtokenizer = new StringTokenizer(line, " ");
	        	while(stringtokenizer.hasMoreTokens()){
	        		count++;
	        		set = stringtokenizer.nextToken();
	        		filereader.StopWords.put(set, count);
	        	}
	        }
	       FileReader filereader2 = new FileReader();
	       filereader2 = FileReader.WordBuilder(filereader);
	       PerceptronTrainingRule.perceptronprocess(variables, filereader2);
		   Result.result(filereader2);
		} catch (Exception E){
			// In case of any error
	    	E.printStackTrace();
		}
	}
}
