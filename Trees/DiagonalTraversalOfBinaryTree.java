//User function Template for Java

/* Node is defined as
class TreeNode
{
    int data; //node data
    TreeNode left, right; //left and right child's reference

    // Tree node constructor
    public TreeNode(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/
class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           LinkedList<Node> que = new LinkedList<>();
           que.addLast(root);
           ArrayList<Integer> res = new ArrayList<>();

           while(que.size() != 0){
               int size = que.size();
               while(size --> 0){
                   Node vtx = que.removeFirst();
                   res.add(vtx.data);
                   while(vtx != null){

                       if(vtx.left != null)que.addLast(vtx.left);
                       if(vtx.right != null){
                           res.add(vtx.right.data);
                        }
                        vtx = vtx.right;
                    }
               }
           }
           return res;

      }
}
