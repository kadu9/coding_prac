package string;

import java.util.HashMap;
import java.util.Map;

public class StringEncodingSimple {
    Map<Integer,String> m = new HashMap<>();
    int i =0;

    /**
     * Performance Analysis

     The number of URLs that can be encoded is limited by the range of \text{int}int, since \text{hashCode}hashCode uses integer calculations.
     * @param longurl
     * @return
     */
    public  String encode(String longurl){
        m.put(longurl.hashCode(),longurl);
        return "http://tinyurl.com/"+longurl.hashCode();
    }

    public String decode(String shorturl){
        return m.get(Integer.parseInt(shorturl.replace("http://tinyurl.com/","")));
    }

    public static void main(String[] args){
        String s = "https://leetcode.com/problems/subtree-of-another-tree/description/";
        StringEncodingSimple stringEncodingSimple = new StringEncodingSimple();
//        stringEncodingSimple.encode(s);
        System.out.println(stringEncodingSimple.encode(s));
        System.out.println(stringEncodingSimple.decode("http://tinyurl.com/-280004362"));
    }

    /**
     *another approach using random
     * The number of URLs that can be encoded is limited by the range of
     public String encode(String longUrl) {
     while (map.containsKey(key)) {
     key = r.nextInt(Integer.MAX_VALUE);
     }
     map.put(key, longUrl);
     return "http://tinyurl.com/" + key;
     }

     public String decode(String shortUrl) {
     return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
     }
     */
}
