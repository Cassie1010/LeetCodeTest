package com.zmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class L30_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        List<Integer> result = new L30_SubstringWithConcatenationOfAllWords().findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
        /*List<Integer> result = new L30_SubstringWithConcatenationOfAllWords().findSubstring("ababababababababababababababababababababababababababababababa" +
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
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || words == null || words.length == 0){
            return result;
        }
        String temp = null;
        final int cpuCore = Runtime.getRuntime().availableProcessors();
        final int poolSize = cpuCore+1;
        ExecutorService service = Executors.newFixedThreadPool(poolSize);
        ArrayList<Future<Integer>> results = new ArrayList<Future<Integer>>();
        for(int i = 0; i < s.length() - (words[0].length() * words.length - 1); i++){
            temp = s.substring(i);
            for(int j = 0 ; j < words.length && !results.contains(i) ; j++){
                if(temp.startsWith(words[j]) && !results.contains(i)){
                    results.add(service.submit(new dealCallable(temp, new ArrayList<>(Arrays.asList(words)), j, i)));
                }
            }
        }
        if(!results.isEmpty()){
            Integer re = null;
            for(Future<Integer> future: results){
                if(!future.isDone()){
                    try {
                        re = future.get();
                        if(re != null && !result.contains(re)){
                            result.add(re);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.println("get: "+future.get());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }

    class dealCallable implements Callable{
        private String subStr;
        private List<String> tempWords;
        private int remIndex;
        private int oriIndex;

        public dealCallable(String subStr, List<String> tempWords, int remIndex, int oriIndex) {
            this.subStr = subStr;
            this.tempWords = tempWords;
            this.remIndex = remIndex;
            this.oriIndex = oriIndex;
        }

        @Override
        public Object call() {
            return deal(subStr, tempWords, remIndex, oriIndex);
        }
    }

    public Integer deal(String subStr, List<String> tempWords, int remIndex, int oriIndex){
        tempWords.remove(remIndex);
        if(tempWords.isEmpty()){
            return oriIndex;
        }
        subStr = subStr.substring(tempWords.get(0).length());
        for(int j = 0 ; j < tempWords.size() ; j++){
            if(subStr.startsWith(tempWords.get(j))){
                return deal(subStr, tempWords, j, oriIndex);
            }
        }
        return null;
    }
}
