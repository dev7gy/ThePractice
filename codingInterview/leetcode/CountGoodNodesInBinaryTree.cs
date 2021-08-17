/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int GoodNodes(TreeNode root) {
        int count = 0;
        RecursiveCountGoodNodes(root, root.val, ref count);
        
        return count;
    }
    
    public void RecursiveCountGoodNodes(TreeNode current, int maxValue, ref int count)
    {
        if (current == null)
        {
            return;
        }
        
        if (current.val > maxValue)
        {
            maxValue = current.val;
            count++;
        }
        else if (current.val == maxValue)
        {
            count++;
        }
        else
        {
            ;
        }
        RecursiveCountGoodNodes(current.left, maxValue, ref count);
        RecursiveCountGoodNodes(current.right, maxValue, ref count);
    }
}
