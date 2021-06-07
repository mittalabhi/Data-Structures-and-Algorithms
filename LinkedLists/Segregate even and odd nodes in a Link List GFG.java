// { Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node ans = ob.divide(n, head);
            printList(ans); 
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java

/* 
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution{
    Node divide(int N, Node head){
        // code here
        Node dummyOdd=new Node(-1);
        Node dummyEven=new Node(-1);
        Node OddTail=dummyOdd;
        Node EvenTail=dummyEven;
        Node curr=head;
        while(curr!=null)
        {
            if(curr.data%2!=0)
            {
                OddTail.next=curr;
                OddTail=OddTail.next;
            }
            else
            {
                EvenTail.next=curr;
                EvenTail=EvenTail.next;
            }
            curr=curr.next;
        }
        EvenTail.next=dummyOdd.next;
        OddTail.next= null;
        return dummyEven.next;
    }
}