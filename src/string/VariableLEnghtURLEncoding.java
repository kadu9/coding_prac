package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VariableLEnghtURLEncoding {
    String keyStr ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    Map<String, String> m = new HashMap<>();
    Random r = new Random();
    String key = getRand();

    public String getRand(){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<6;i++) {
            sb.append(keyStr.charAt(r.nextInt(62)));
        }
        return sb.toString();
    }

    public String encode(String longurl){
        while (m.containsKey(key)){
            key=getRand();
        }
        m.put(key,longurl);
        return "http://tinyurl.com/"+key;
    }

    public String decode(String shorturl){
        return m.get(shorturl.replace("http://tinyurl.com/",""));

    }

    public static void main(String[] args){
        String s = "https://leetcode.com/problems/subtree-of-another-tree/description/";
        VariableLEnghtURLEncoding v = new VariableLEnghtURLEncoding();
        v.encode(s);
        System.out.println(v.encode(s));

        System.out.println(v.decode(v.encode(s)));
    }
}
