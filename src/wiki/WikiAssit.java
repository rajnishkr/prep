package wiki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WikiAssit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String lines[] = input.split("\\.", -1);
        String[] questions = new String[5];
        for (int i = 0; i < 5; i++) {
            questions[i] = sc.nextLine();
        }
        String[] answers = sc.nextLine().split(";");

        List<HashMap<String, Integer>> result = new ArrayList<HashMap<String, Integer>>();
        List<HashMap<String, Integer>> questionScore = new ArrayList<HashMap<String, Integer>>();
        List<HashMap<String, Integer>> answerScore = new ArrayList<HashMap<String, Integer>>();
        getFrequencyMatrix(lines, result);
        getFrequencyMatrix(questions, questionScore);
        getFrequencyMatrix(answers, answerScore);
        boolean visited[] = new boolean[5];
        for (HashMap<String, Integer> map : questionScore) {
            int score = 0;
            HashMap<String, Integer> matchingtext = null;


            for (HashMap<String, Integer> textMap : result) {

                int currentScore = 0;
                for (String questionKey : map.keySet()) {
                    if (textMap.containsKey(questionKey)) {
                        currentScore += questionKey.length();
                    } else {
                        currentScore -= questionKey.length() / 2;
                    }
                }
                if (score < currentScore) {
                    score = currentScore;
                    matchingtext = textMap;
                }
            }

            int ansScore = 0, answerCurrentIndex = 0, answersIndex = 0;
            for (HashMap<String, Integer> ans : answerScore) {
                if (visited[answerCurrentIndex]) {
                    answerCurrentIndex++;
                    continue;
                }
                int currentScore = 0;
                for (String ansKey : ans.keySet()) {
                    if (matchingtext.containsKey(ansKey)) {
                        currentScore += ansKey.length();
                    } else {
                        currentScore -= ansKey.length() / 2;
                    }

                }
                if (currentScore > ansScore) {
                    ansScore = currentScore;
                    answersIndex = answerCurrentIndex;
                }
                answerCurrentIndex++;
            }
            //System.out.println(questions[itr]);
            System.out.println(answers[answersIndex]);
            visited[answersIndex] = true;
        }
    }


    private static void getFrequencyMatrix(String[] questions, List<HashMap<String, Integer>> questionScore) {
        for (String question : questions) {
            List<String> resultAfterStopWord = StopWordRemoval.removeStopWords(question);
            questionScore.add(new HashMap<>());
            resultAfterStopWord.stream().forEach(x -> {
                x = x.toLowerCase();
                Stemmer stemmer = new Stemmer();
                for (int i = 0; i < x.length(); i++) {
                    stemmer.add(x.charAt(i));
                }
                stemmer.stem();
                if (questionScore.get(questionScore.size() - 1).containsKey(stemmer.toString())) {
                    questionScore.get(questionScore.size() - 1).put(stemmer.toString(), questionScore.get(questionScore.size() - 1).get(stemmer.toString()) + 1);
                } else {
                    questionScore.get(questionScore.size() - 1).put(stemmer.toString(), 1);
                }
            });
        }
    }
}
