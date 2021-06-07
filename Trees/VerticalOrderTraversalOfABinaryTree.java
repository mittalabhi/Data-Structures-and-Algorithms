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
      class Pair{
        TreeNode root;
        int level;
        Pair(TreeNode root, int level){
            this.level = level;
            this.root = root;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,ArrayList<int[]>> hm = new HashMap<>();
        LinkedList<Pair> que = new LinkedList<>();
        Pair rootPair = new Pair(root,0);
        que.addLast(rootPair);
        int maxLevel = -(int)1e9;
        int minLevel =  (int)1e9;
        int step = 0;
        while(que.size() != 0){
            int size = que.size();
            while(size -- > 0){
                Pair p = que.removeFirst();
                TreeNode vtx = p.root;
                int dis = p.level;
                
                if(hm.containsKey(dis)){
                   ArrayList<int[]> arr = hm.get(dis);
                   arr.add(new int[] {vtx.val,step}); 
                }
                else{
                    ArrayList<int []> arr = new ArrayList<>();
                    arr.add(new int[] {vtx.val,step});
                    hm.put(dis,arr);
                }
                maxLevel = Math.max(dis,maxLevel);
                minLevel = Math.min(dis,minLevel);
                
                if(vtx.left != null){
                    Pair q = new Pair(vtx.left,dis - 1);
                    que.addLast(q);
                }
                if(vtx.right != null){
                    Pair q = new Pair(vtx.right,dis + 1);
                    que.addLast(q);
                }
                
            }
            step++;
        }
        for(int i = minLevel ; i <=  maxLevel ; i++){
            ArrayList<int[]> ar = hm.get(i);
            //Collections.sort(ar);
            Collections.sort(ar,(a,b)->{
            return a[1] != b[1] ? a[1] - (b[1]) : a[0] - b[0];
        });
            ArrayList<Integer> res = new ArrayList<>();
            for(int j = 0;j < ar.size() ; j++){
                int node[] = ar.get(j);
                res.add(node[0]);
            }
            ArrayList<Integer> ans2 = new ArrayList<>(res);
            ans.add(ans2);
        }
        return ans;
        
    }
    }