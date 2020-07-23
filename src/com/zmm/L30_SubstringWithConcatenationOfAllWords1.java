package com.zmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class L30_SubstringWithConcatenationOfAllWords1 {
    public static void main(String[] args) {
        List<Integer> result = new L30_SubstringWithConcatenationOfAllWords1().findSubstring(
                "wordgoodgoodgoodbestword",
                        new String[]{"word","good","best","good"});
        /*List<Integer> result = new L30_SubstringWithConcatenationOfAllWords1().findSubstring("ababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "babababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa" +
                        "bababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab",
                new String[]{"ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba","ab","ba"});
        */
        System.out.println(result);
    }

    public void dealWords(List<String> wordList, String starWord, List<String> words, int remIndex){
        List<String> tempList = new ArrayList<String>(words);
        if(remIndex !=-1) tempList.remove(remIndex);
        if(tempList.isEmpty()){
            if(!wordList.contains(starWord) && !starWord.equals("")){
                wordList.add(starWord);
            }
            return;
        }
        String temp = null;
        List<String> currWord = new ArrayList<>();
        for(int i = 0; i < tempList.size(); i++){
            if(!currWord.contains(tempList.get(i))){
                currWord.add(tempList.get(i));
                temp = starWord + tempList.get(i);
                dealWords(wordList, temp, tempList, i);
            }
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if(s == null || words == null || words.length == 0){
            return result;
        }
        int size = words.length * words[0].length();
        if(size > s.length()){
            return result;
        }
        List<String> wordList = new ArrayList<>();
        dealWords(wordList, "", Arrays.asList(words), -1);

        String temp = null;
        for(int i = 0; i <= s.length() - size; i++){
            temp = s.substring(i);
            for(String word : wordList){
                if(temp.startsWith(word)){
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

}
