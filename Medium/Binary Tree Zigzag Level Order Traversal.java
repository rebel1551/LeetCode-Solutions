/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        int depth = 0;
        while(!Q.isEmpty()) {
            int len = Q.size();

            Integer[] dummy = new Integer[len];
            
            if(depth%2 == 0) {
                for(int index = 0; index < len; ++index) {
                    root = Q.poll();
                    dummy[index] = root.val;
                    
                    if(root.left != null) {
                        Q.add(root.left);
                    }
                    if(root.right != null) {
                        Q.add(root.right);
                    }
                }    
            }
            else {
                 for(int index = 0; index < len; ++index) {
                    root = Q.poll();
                    dummy[len - 1 - index] = root.val;
                    
                    if(root.left != null) {
                        Q.add(root.left);
                    }
                    if(root.right != null) {
                        Q.add(root.right);
                    }
                }
            }
            
            result.add(Arrays.asList(dummy));
            ++depth;
        }
    return result;
    }
}

