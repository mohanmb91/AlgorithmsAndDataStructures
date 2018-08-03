package leetCode79;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned1) {
        String pArr[] = paragraph.split(" ");
        Set<Character> avoidChars = new HashSet<>();
        avoidChars.add('!');
        avoidChars.add('?');
        avoidChars.add('\'');
        avoidChars.add(';');
        avoidChars.add(',');
        avoidChars.add('.');
          
        Set<String> banned = new HashSet<>();
        for(int i=0;i<banned1.length;i++){
            banned.add(banned1[i]);
        }
        HashMap<String,Integer> map = new HashMap<>();
        int max = -1;
        String answer = "";

        for(int i=0;i<pArr.length;i++){
            char cha[] = pArr[i].toLowerCase().toCharArray();
            StringBuilder eachString = new StringBuilder();
            for(int j =0;j<cha.length;j++){
                if(!avoidChars.contains(cha[j])){
                    eachString.append(cha[j]);
                }
            }
            if(banned.contains(eachString.toString()))
                continue;
            if(map.containsKey(eachString.toString()))
            {
                int temp=map.get(eachString.toString())+1;
                 map.put(eachString.toString(),temp); 
                if(max<=temp){
                    answer = eachString.toString();
                    max = temp;
                }
            }
            else{
                if(max<=1){
                    answer = eachString.toString();
                    max = 1;
                }
                map.put(eachString.toString(),1);
            }    
        }
        
       return answer; 
    }
}