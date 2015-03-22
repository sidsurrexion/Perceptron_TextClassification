import java.util.HashMap;
import java.util.Map;
public class PerceptronTrainingRule {
	public static void perceptronprocess(Variables variables, FileReader filereader){
		float delta_weight = 0.0f;
		float weight = 0.0f;
		float output_weight = 0.0f;
		float subtraction = 0.0f;
		for (int i = 0; i < variables.number_iterations; i++){
			for (String filepath: filereader.File_Boolean.keySet()){
				Map<String, Integer> Vocabulary = new HashMap<String, Integer>();
				if (filereader.Vocabulary_Spam.containsKey(filepath)){
					Vocabulary = filereader.Vocabulary_Spam.get(filepath);
				} else if (filereader.Vocabulary_Ham.containsKey(filepath)) {
					Vocabulary = filereader.Vocabulary_Ham.get(filepath);
				} else {
					continue;
				}
				for (String word: filereader.Word_Life.keySet()){
					if (Vocabulary.containsKey(word)){
						output_weight = output_weight + filereader.Word_Life.get(word) * (float)Vocabulary.get(word);
					} else {
						output_weight = output_weight + filereader.Word_Life.get(word) * 0.0f;
					}
				}
				output_weight = output_weight + filereader.weight_initial;
				if (output_weight > 0){
					subtraction = (float) (variables.learning_rate * (filereader.File_Boolean.get(filepath) - 1.0));
				} else {
					subtraction = (float) (variables.learning_rate * (filereader.File_Boolean.get(filepath) + 1.0));
				}
				for (String word: filereader.Word_Life.keySet()){
					if (Vocabulary.containsKey(word)){
						delta_weight = subtraction * Vocabulary.get(word);						
					} else {
						delta_weight = subtraction * 0.0f;
					}
					weight = filereader.Word_Life.get(word);
					weight = weight + delta_weight;
					filereader.Word_Life.put(word, weight);
					weight = 0.0f;
					delta_weight = 0.0f;					
				}
				output_weight = 0.0f;
				subtraction = 0.0f;
			}
		}
	}
}
