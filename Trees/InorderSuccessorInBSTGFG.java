class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    Node pre = null;
    Node post = null;
    int color = 0;
    public void inorderSuccesorH(Node root,Node x){
      if(root == null)return;


          inorderSuccesorH(root.left,x);

          if(color == 1){
             color = 2;
             post = root;
            }
          if(color == 0){
              if(root.data == x.data){
                  color = 1;
              }
              else if(root.data != x.data) {
                  pre = root;
              }
         }
          inorderSuccesorH(root.right,x);


    }
    public Node inorderSuccessor(Node root,Node x)
    {
          //add code here.
         inorderSuccesorH(root,x);
         return post;



    }
}