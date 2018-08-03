package contest81.third;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Solution {
    public int flipgame(int[] fronts, int[] backs) 
    {
        //Element,List<Index>
        TreeMap<Integer,List<Integer>> fMap = new TreeMap<>();        
        TreeMap<Integer,List<Integer>> bMap = new TreeMap<>();
        
        //index
        Set<Integer> noSwap = new HashSet<>();
        Set<Integer> notAllowed = new HashSet<>();
        
        int answer =0;
        
        for(int i=0;i<fronts.length;i++)
        {
            if(fronts[i]==backs[i])
            {
                notAllowed.add(fronts[i]);
                noSwap.add(i);
            }
            else
            {
                fMap.computeIfAbsent(fronts[i], (x -> new ArrayList<>())).add(i);
                bMap.computeIfAbsent(backs[i], (x -> new ArrayList<>())).add(i);
            }
        }
        
        
        
        //Find the unique Key
        int backUnique = -1;
        for(Map.Entry<Integer,List<Integer>> entry:bMap.entrySet())
        {
            if(!notAllowed.contains(entry.getKey()))
            {
                backUnique = entry.getKey();
                break;
            }
            //System.out.println(entry.getKey()+"  "+entry.getValue());
        }
        
        int frontUnique = -1;
        for(Map.Entry<Integer,List<Integer>> entry:fMap.entrySet())
        {
            if(!notAllowed.contains(entry.getKey()))
            {
                frontUnique = entry.getKey();
                break;
            }
            //System.out.println(entry.getKey()+"  "+entry.getValue());
        }
        if(backUnique == -1 && frontUnique ==-1)
            return 0;
        if(backUnique==-1)
            return frontUnique;
        if(frontUnique ==-1)
            return backUnique;
        if(backUnique<frontUnique)
            return backUnique;
        return frontUnique;
    }
}
