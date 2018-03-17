

package trees;

import java.util.Objects;

public class TreeNode{
    public   int data;
    TreeNode left;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return data == treeNode.data &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data, left, right);
    }

    TreeNode right;

    public TreeNode(int data){
        this.data=data;
        left = null;
        right = null;
    }

   public int comparaeTo(TreeNode d){
        if(this.data > d.data){
            return 1;
        } else if(this.data<d.data){
            return -1;
        } else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}