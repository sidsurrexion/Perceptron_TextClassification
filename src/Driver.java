import java.util.Scanner;
import java.util.StringTokenizer;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		System.out.println("Enter the number of iterations and the learning rate");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();		
		StringTokenizer stringtokenizer = new StringTokenizer(string, " ");
		Variables variables = new Variables();
		while (stringtokenizer.hasMoreElements()){
			str = stringtokenizer.nextToken();
			if (str.equals(null)){
				variables.learning_rate = 0.04;
				variables.number_iterations = 40;
			} else {
				if (variables.number_iterations == 0){
					if(Integer.parseInt(str) == 0){
						variables.number_iterations = 40;
					} else {
						variables.number_iterations = (Integer.parseInt(str));
					}
				}
				else if (variables.learning_rate == 0.0){
					if (Double.parseDouble(str) == 0.0){
						variables.learning_rate = 0.04;
					} else{
						variables.learning_rate = Double.parseDouble(str);
					}				
				}
			}
		}
		System.out.println("\nAccuracy before removing the stopwords");
		FileReader filereader = new FileReader();
		FileReader filereader2 = new FileReader();
		filereader = FileReader.WordBuilder(filereader2);
		PerceptronTrainingRule.perceptronprocess(variables, filereader);
		Result.result(filereader);
		System.out.println("\nAccuracy after removing the stopwords");
		StopWords.stopwords(filereader2, variables);
	}

}
