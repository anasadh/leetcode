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
    class pair{
        TreeNode node;
        int id;

        pair(TreeNode node,int id){
            this.node = node;
            this.id = id;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;

        int ans=0;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root,0));

        while(!q.isEmpty()){
            int s = q.size();
            // int mmin = q.peek().id;
            int f=0,l=0;
            for(int i=0;i<s;i++){
                TreeNode cur_Node = q.peek().node;
                int cur_id = q.peek().id;
                q.poll();

                if(i==0)
                f=cur_id;
                if(i==s-1)
                l=cur_id;

                if(cur_Node.left!=null)
                q.offer(new pair(cur_Node.left,cur_id*2+1));
                if(cur_Node.right!=null)
                q.offer(new pair(cur_Node.right,cur_id*2+2));
            }
            ans = Math.max(ans,l-f+1);
        }
        return ans;
    }
}