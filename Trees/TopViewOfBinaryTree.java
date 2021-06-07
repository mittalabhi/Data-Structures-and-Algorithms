// { Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}// } Driver Code Ends


//User function Template for Java



class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    class Pair{
        Node root;
        int dis;
        Pair(Node root,int dis){
            this.root = root;
            this.dis = dis;
        }
    }
    public ArrayList <Integer> topView(Node root)
    {
        // Code here
        int min = (int)1e9;
        int max = -(int)1e9;
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        LinkedList<Pair> que = new LinkedList<>();
        Pair newPair = new Pair(root,0);
        que.addLast(newPair);
        
       
        
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                Pair vtx = que.removeFirst();
                Node newNode = vtx.root;
                int dis = vtx.dis;
                min = Math.min(min,dis);
                max = Math.max(max,dis);
                
                if(newNode.left != null){
                    Pair newPair2 = new Pair(newNode.left,dis - 1);
                    que.addLast(newPair2);
                }
                if(newNode.right != null){
                    Pair newPair2 = new Pair(newNode.right,dis + 1);
                    que.addLast(newPair2);
                }
                
                if(hm.containsKey(dis)){
                    ArrayList<Integer> arr = hm.get(dis);
                    arr.add(newNode.data);
                    hm.put(dis,arr);
                }
                else{
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(newNode.data);
                    hm.put(dis,arr);
                }
                
                
            }
        }
        //System.out.println(hm.size());
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = min; i <= max; i++){
            ArrayList<Integer> res = hm.get(i);
           // System.out.println(res);
            ans.add(res.get(0));
        }
        return ans;
    }
}