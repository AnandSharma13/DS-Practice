package LeetCode;

import java.util.*;

/**
 * Created by Anand on 4/15/2016.
 */
public class WordLadder {

    class QItem{

        String word;
        int len;
    }

    public boolean isAdjacent(String word1, String word2){

        int count =0;
        for(int i =0;i<word1.length() ;i++){
            if(word1.charAt(i) != word2.charAt(i))
                count++;
            if(count>1)
                return false;
        }
        return count==1?true:false;
    }

    public  int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<QItem> myQueue = new LinkedList<>();
        QItem beginItem = new QItem();
        beginItem.word= beginWord;
        beginItem.len =1;
        myQueue.add(beginItem);

        while(!myQueue.isEmpty()){
            QItem item= myQueue.remove();
            Iterator<String> iterator = wordList.iterator();
            while (iterator.hasNext()) {
                String str = iterator.next();
                 if(isAdjacent(item.word, str)){
                    QItem newItem = new QItem();
                    newItem.word = str;
                    newItem.len = item.len +1;
                    myQueue.add(newItem);
                    iterator.remove();
                    if(str.equals(endWord))
                        return newItem.len;
                }
            }
        }
        return 0;
    }

    public static void main(String [] args){
    WordLadder wl = new WordLadder();
    Set mySet = new HashSet<>();
        mySet.add("hit");
    mySet.add("hot");
    mySet.add("dot");
    mySet.add("dog");
    mySet.add("lot");
    mySet.add("log");
        mySet.add("cog");
        System.out.println(wl.ladderLength("hit", "cog", mySet));
}
}