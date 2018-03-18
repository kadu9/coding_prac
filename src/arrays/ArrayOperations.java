package arrays;

import java.util.*;

public class ArrayOperations {

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
     * Given nums = [1,1,2],Your function should return length = 2,
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        if (nums.length < 2) {
            return nums.length;
        }

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    /**
     * https://leetcode.com/problems/remove-element/description/
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) {
                if (nums[end] == val) {
                    end--;
                } else {
                    int temp = nums[end];
                    nums[end] = nums[start];
                    nums[start] = end;
                    end--;
                    start++;

                }
            }
        }
        return start;
    }

    /**
     * https://leetcode.com/problems/maximum-subarray/description/
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     * <p>
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     *
     * @param a
     * @return
     */
    public int maxSubArray(int[] a) {
        if (a.length == 0) return 0;
        int currSum = a[0];
        int maxSum = a[0];
        for (int i = 1; i < a.length - 1; i++) {
            currSum = Math.max(a[i], currSum + a[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /**
     * https://leetcode.com/problems/maximum-product-subarray/description/
     * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
     * <p>
     * For example, given the array [2,3,-2,4],
     * the contiguous subarray [2,3] has the largest product = 6.
     *
     * @param arr
     * @return
     */
    //TODO
    public int maxProduct(int[] arr) {
        if (arr.length == 0) return 0;
        int currSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(arr[i], currSum * arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /**
     * https://leetcode.com/problems/move-zeroes/description/
     * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int k = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int j = 0; j < count; j++) {
            nums[k] = 0;
            k++;
        }
    }

    /**
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     * .e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You may assume no duplicate exists in the array.
     *
     * @param arr
     * @return
     */
    public int searchInSortedRotatedArray(int[] arr, int data, int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == data) {
            return mid;
        } else if (data < arr[mid] && data > arr[low]) {
            return searchInSortedRotatedArray(arr, data, low, mid - 1);
        } else
            return searchInSortedRotatedArray(arr, data, mid + 1, high);
    }
    public boolean findTwiceElement(int[] nums){
        Map<Integer,Integer> m = new HashMap<>();
        for(int ele : nums){
            if(!m.containsKey(nums[ele])){
                m.put(nums[ele],1);
            } else{
                return true;
                //m.put(num,m.get(ele)+1);
            }
        }
        return false;
    }

    public int bestTimeBuySellStock(int[] prices){
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    /**
     * https://leetcode.com/problems/product-of-array-except-self/description/
     * @param nums
     * @return
     * todo
     */
    public int[] productExceptSelf(int[] nums) {

        int n  = nums.length;

        int[] res = new int[n];
        res[0] = 1;
        for(int i=1;i<n;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int right =1;
        for(int i=n-1;i>=0;i--){
            res[i] = res[i]*right;
            right = right *nums[i];
        }
        return res;
    }

    public int fibonacciRecursive(int n){
        if(n<=1){
            return n;
        } else return fibonacciRecursive(n-1) +fibonacciRecursive(n-2);
    }

    /**
     * https://leetcode.com/problems/compare-version-numbers/description/
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {

        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }

    public String longestCommonPrefix(String[] str){
        StringBuilder  sb = new StringBuilder();
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        return sb.toString();

    }

    /**
     * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
     * Given "abcabcbb", the answer is "abc", which the length is 3.

     Given "bbbbb", the answer is "b", with the length of 1.
     * @param str
     * @return
     */
    public int lengthOfLongestSubString(String str){
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        if (len ==0 || str==null) return 0;
        char[] s = str.toCharArray();
        Map<Character,Boolean> m = new HashMap<>();
        int count=0;
        int maxcount=0;
        for (int i = 0; i < len; i++) {
            if(!m.containsKey(s[i])){
                m.put(s[i],true);
                count++;
            } else {
                m.clear();
                maxcount = Math.max(count,maxcount);
                count=0;
            }
        }
        return Math.max(maxcount,count);

    }

    public List<String> stringPermutations(String s){
        return permute(new ArrayList<String>(),"",s);
    }

    private List<String> permute(List<String> lst,String perm, String word) {
        if (word.isEmpty()){
            if(!lst.contains(perm)) {//if the string contains repeated characters and to avoid printing duplicates
                lst.add(perm);
            }
        } else{
            for (int i = 0; i < word.length();   i++) {
                permute(lst,perm+word.charAt(i),word.substring(0,i)+word.substring(i+1,word.length()));
            }
        }
        return lst;
    }

//https://www.programcreek.com/2013/02/leetcode-permutations-java/
    public ArrayList<ArrayList<Integer>> intpermute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permute(num, 0, result);
        return result;
    }

    void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {

        if (start >= num.length) {
            ArrayList<Integer> item = convertArrayToList(num);
//            if(result.contains(item)) return;//if want to skip duplicates
            result.add(item);
        }

        for (int j = start; j <= num.length - 1; j++) {
            swap(num, start, j);
            permute(num, start + 1, result);
            swap(num, start, j);
        }
    }

    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * https://leetcode.com/problems/house-robber/description/
     * @param num [2,3,4,1,6,9,6,3]
     * @return 18
     */
    public int rob(int[] num) {

        if(num==null || num.length == 0)
            return 0;

        int even = 0;
        int odd = 0;

        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                even += num[i];
                even = even > odd ? even : odd;
            } else {
                odd += num[i];
                odd = even > odd ? even : odd;
            }
        }

        return even > odd ? even : odd;

    }
    public static void main(String[] args){
        ArrayOperations arrayOperations = new ArrayOperations();

        int[] arr1 = new int[]{1,1,1,2,3};
        System.out.println(arrayOperations.removeDuplicates(arr1));

        int[] arr2 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(arrayOperations.maxSubArray(arr2));

        int[] arr3 = new int[]{-4,3};
        System.out.println(arrayOperations.maxProduct(arr3));

        int[] arr4 = new int[]{0, 1, 0, 3, 12};
        System.out.println(arrayOperations.maxProduct(arr4));
        for (int i = 0; i < arr4.length-1; i++) {
            System.out.println(arr4[i]);

        }

        System.out.println("Max profit: "+arrayOperations.bestTimeBuySellStock(new int[]{7, 1, 5, 3, 6, 4}));
        Arrays.stream(arrayOperations.productExceptSelf(new int[]{1, 2, 3, 4})).forEach(k -> System.out.print(" "+k));

        System.out.println("Fib"+arrayOperations.fibonacciRecursive(9));

        System.out.println(arrayOperations.compareVersion("1.3.0","1.4"));

        arrayOperations.longestCommonPrefix(new String[]{"abcdefgh","aefghijk","abc"});

        System.out.println("Length of longest substring : "+arrayOperations.lengthOfLongestSubString("pwwkew"));
        List<String> stringList = arrayOperations.stringPermutations("112");
        for (String s:
             stringList) {
            System.out.println(s);

        }

//        System.out.println("abc".substring(0,));
        arrayOperations.intpermute(new int[]{1,2,2}).forEach(integers -> {
            System.out.println(integers);
        });

        System.out.println(arrayOperations.rob(new int[]{2,3,4,1,6,9,6,3}));
    }
}
