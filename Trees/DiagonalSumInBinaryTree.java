public static ArrayList <Integer> diagonalSum(Node root) 
    {
        // code here.
         LinkedList<Node> que = new LinkedList<>();
           que.addLast(root);
           ArrayList<Integer> finres = new ArrayList<>();
           int sum = 0;
           while(que.size() != 0){
               ArrayList<Integer> res = new ArrayList<>();
               int size = que.size();
               while(size --> 0){
                   Node vtx = que.removeFirst();
                   res.add(vtx.data);
                   sum += vtx.data;
                   while(vtx != null){

                       if(vtx.left != null)que.addLast(vtx.left);
                       if(vtx.right != null){
                           res.add(vtx.right.data);
                            sum += vtx.right.data;
                        }
                        vtx = vtx.right;
                    }
                }
               finres.add(sum);
                    sum = 0;
           }
           return finres;
    }
