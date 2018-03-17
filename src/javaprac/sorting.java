package javaprac;

import trees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class sorting {
    public static void main(String args[]){
        TreeNode root1 = new TreeNode(1);

        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);

        HashMap<Integer,TreeNode> map = new HashMap<Integer, TreeNode>();
        map.put(11,root1);
        map.put(2,root2);
        map.put(4,root4);
        map.put(3,root3);
        map.put(5,root5);
        for (Map.Entry<Integer,TreeNode> m: map.entrySet()){
            System.out.println(m.getKey()+" -> "+m.getValue().data);
        }
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
    /* 
        System.out.println("Original...");
        System.out.println(unsortMap);

        //sort by values, and reserve it, 10,9,8,7,6...
        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        //Alternative way
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
        System.out.println(result);
        System.out.println(result2);

        */

        Set<Map.Entry<Integer,TreeNode>> set= map.entrySet();

        List<Map.Entry<Integer,TreeNode>> lst = new ArrayList<>(set);

        Collections.sort(lst, new Comparator<Map.Entry<Integer, TreeNode>>() {
            @Override
            public int compare(Map.Entry<Integer, TreeNode> o1, Map.Entry<Integer, TreeNode> o2) {
                return o2.getValue().comparaeTo(o1.getValue());
            }
        });


        System.out.println("after soriting");
        lst.stream().forEach(m -> {
            System.out.println(m.getKey()+" -> "+m.getValue().data);
        });



    }



}
