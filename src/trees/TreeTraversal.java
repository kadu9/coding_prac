package trees;

import apple.laf.JRSUIUtils;
import graph.Graph;

import java.util.*;

public class TreeTraversal {

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(" " + root.data);
            inorder(root.right);
        }
    }

    public void nonRecursiveInorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return;
        stack.push(root);
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (stack.size() > 0) {
            //System.out.println("size"+stack.size());
            root = stack.pop();
            if (stack.isEmpty()) return;
            System.out.print(" " + root.data);
            if (root.right != null) {
                root = root.right;

                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
    }

    public void nonRecursivePreorder1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return;
        //stack.push(root);
        //System.out.print(" "+root.data);
        while (root != null) {
            System.out.print(" " + root.data);
            stack.push(root);
            root = root.left;
        }
        while (stack.size() > 0) {
            //System.out.println("size"+stack.size());
            root = stack.pop();
           // if (stack.isEmpty()) return;

            if (root.right != null) {
                root = root.right;

                while (root != null) {
                    stack.push(root);
                    System.out.print(" "+root.data);
                    root = root.left;
                }
            }
        }
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(" "+root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public  void postOrder(TreeNode root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" "+root.data);
    }

    public void printLeverOrder(TreeNode root){
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            TreeNode temp = q.poll();
            System.out.print(" "+temp.data);
            if(temp.left != null) q.add(temp.left);
            if (temp.right !=null) q.add(temp.right);
        }
    }
// O(n) time and space complexity. This can also be solved using level order traversal
    public Integer findMax(TreeNode root){
        int max = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        int rootVal = Integer.MIN_VALUE;
        if(root != null){
            rootVal = root.data;
            left = findMax(root.left);
            right = findMax(root.right);
            if(left > right){
                max = left;
            } else{
                max = right;
            }
            if(rootVal > max){
                max = rootVal;
            }
        }
        return max;
    }

    //This can be solved using level order traversal as well
    public boolean searchInBinaryTree(TreeNode root, int ele){
        if (root != null){
            if(root.data == ele){
                return true;
            } else {
                return (searchInBinaryTree(root.left,ele) || searchInBinaryTree(root.right,ele));
            }
        }
    return false;
    }

    public int countLeafNodes(TreeNode root){
        int count = 0;
        if (root == null) {
            return  0;
        }
            if (root.right == null && root.left == null){
            return 1;
            }
             else return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();

        if(root == null) return paths;

        if(root.left == null && root.right == null){
            paths.add(root.data+"");
            return paths;
        }

        for (String path : binaryTreePaths(root.left)) {
            paths.add(root.data + "->" + path);
        }

        for (String path : binaryTreePaths(root.right)) {
            paths.add(root.data + "->" + path);
        }

        return paths;

    }

    public List<String> binaryTreePathsIterative(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) searchBT(root, "", answer);
        return answer;
    }
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.data);
        if (root.left != null) searchBT(root.left, path + root.data + "->", answer);
        if (root.right != null) searchBT(root.right, path + root.data + "->", answer);
    }

    public boolean isPathSum(TreeNode root, int sum){
        if(root == null) return false;
        return isPathSumHelper( root, 0,sum);
    }
    public boolean isPathSumHelper(TreeNode root, int temp, int totalSum){

        if (root != null){
            totalSum = totalSum - root.data;
            if ((root.left==null && root.right == null)) return 0 == totalSum ;

            if (root.left != null)
                if(isPathSumHelper(root.left,temp, totalSum) == true) return true ;

            if (root.right != null)
                if(isPathSumHelper(root.right,temp,totalSum)== true) return true;
        }
        return false;
    }

    /**
     * https://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
     * @param inorder
     * @param preorder
     * @return
     */
    public TreeNode buildTreeFromInorderPreorder(int[] inorder, int[] preorder){
       return buildTreeHelper(0,0,inorder.length-1,inorder,preorder);
    }
//refer geeksforgeeks/leetcode for running version
    private TreeNode buildTreeHelper(int preStart, int inStart, int inEnd, int[] inorder, int[] preorder) {
        if (preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);


        int inIndex = 0;
        for(int i=inStart ; i<=inEnd;i++){
            if (inorder[i] == root.data ){
                inIndex = i;
            }
        }
        root.left =(buildTreeHelper(preStart++,inStart,inIndex-1,inorder,preorder));
        root.right = buildTreeHelper(preStart++, inIndex+1,inEnd,inorder,preorder);
        return root;
    }

    public boolean findAncestors(TreeNode root, int val){
        if (root == null) return false;

        if (root.data == val){
            System.out.print(root.data);//if want to include the element itself as its ancestors
            return true;
        } else {
            if (findAncestors(root.left,val) || findAncestors(root.right,val)){
                System.out.print(" "+ root.data);
                return true;
            }
        }
    return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        if (root == p || root == q) return root;

       TreeNode left = lowestCommonAncestor(root.left,p,q);
       TreeNode right = lowestCommonAncestor(root.right,p,q);

       if (left == null && right == null) return null;
       if (left !=null && right != null) return root;

       return left!=null? left:right;

    }
    public static int getHeight(TreeNode root){
        if(root ==null){
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if(l>r){
            return l+1;
        } else return r+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left -right) > 1){
            return false;
        }
        //System.out.println(Math.abs(left -right));
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(queue.size() > 0){
            //get size here
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode top = queue.remove();

                //the first element in the queue (right-most of the tree)
                if(i==0){
                    result.add(top.data);
                }
                //add right first
                if(top.right != null){
                    queue.add(top.right);
                }
                //add left
//                if(top.left != null){
//                    queue.add(top.left);
//                }
            }
        }

        return result;
    }
    public TreeNode kthSmallestElement(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return null;
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty()){
            while(node !=null && node.left != null){
                stack.push(node);
                node = node.left;
            }
            TreeNode temp = stack.pop();
            k--;
            if(k ==0){
                return node;
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return root;

    }


    public static void main(String args[]){
        /*
             1
          /     \
        2        3
                / \
      /  \     6   7
     4    5

     */
        System.out.println("Original Tree is :");
        System.out.println("   \n" +
                "             1\n" +
                "          /     \\\n" +
                "        2        3\n" +
                "                / \\\n" +
                "      /  \\     6   7\n" +
                "     4    5\n" +
                "\n" +
                "     ");

        TreeNode root1 = new TreeNode(1);

       TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
TreeNode root6 = new TreeNode(6);
      TreeNode root7 = new TreeNode(7);

        root1.left=root2;
       root1.right=root3;
       root2.left=root4;
        root2.right = root5;
     root3.left=root6;
        root3.right=root7;

        TreeTraversal  treeTraversal = new TreeTraversal();
        System.out.print("Inorder : ");
        treeTraversal.inorder(root1);
        System.out.println();
//        treeTraversal.nonRecursiveInorder(root1);
        System.out.print("Preorder: ");
          treeTraversal.preOrder(root1);
        System.out.println();
        treeTraversal.nonRecursivePreorder1(root1);
        //treeTraversal.postOrder(root1);

//        treeTraversal.printLeverOrder(root1);
     //   System.out.println(treeTraversal.findMax(root1));s

      //  System.out.println(treeTraversal.searchInBinaryTree(root1,4));
      //  System.out.println(treeTraversal.countLeafNodes(root1));

        System.out.println(treeTraversal.binaryTreePathsIterative(root1).toString());
//        System.out.println("11 is present in tree :"+treeTraversal.isPathSum(root1,11));
             /*
             1
          /     \
        2        3
                / \
      /  \     6   7
     4    5

     */

//             treeTraversal.findAncestors(root1,5);

//        System.out.println(treeTraversal.lowestCommonAncestor(root1,root1,root6).data);
        System.out.println("right side view");
          treeTraversal.rightSideView(root6).stream().forEach( integer -> {
              System.out.println(integer);
          });

        System.out.println(3*0.1);
        System.out.println(3*0.1 == 0.3);
        Integer i1 = 260;//will work only for values between -127 to 127∂
        Integer i2 = 260;

        if (i1 == i2) {
            System.out.println("i1 and i2 is equal");
        } else {
            System.out.println("i1 and i2 is not equal ");
        }

        if(i1.equals(i2)){
            System.out.println("i1 and i2 is equal");
        } else {
            System.out.println("i1 and i2 is not equal ");
        }

    }

}
