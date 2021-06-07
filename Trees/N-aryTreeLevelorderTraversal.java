/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
   public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        LinkedList<Node> que = new LinkedList<>();
        List<List<Integer>> ans  = new ArrayList<>();
        que.addLast(root);
        while(que.size() != 0){
            int size = que.size();
            List<Integer> res = new ArrayList<>();
            while(size -- > 0){
                Node vtx = que.removeFirst();
                res.add(vtx.val);

                for(Node child : vtx.children){
                    que.addLast(child);
                }
            }
            System.out.print(res);
            List<Integer> an = new ArrayList<>(res);
            ans.add(an);
        }
        return ans;
    }

}