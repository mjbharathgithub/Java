import java.util.*;

 class Node<T>{
     Node next;
     T data;
     
     Node(T data){
         this.data=data;
         next=null;
     }
     
 }
 class LinkedList<T>
{
    Node<T> head;
    
    void addNode(T data){
        Node<T> newNode= new Node<>(data);
        
        if(head==null){
            head=newNode;
            
        }else{
            Node<T> temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    
    void display(){
        Node<T> temp = head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
        System.out.println();
    }
    
    void insertNode(T data,int ind){
        Node<T> newNode= new Node<>(data);
        
        if(head==null) {
            head=newNode;
            return;
        }
        
        if(ind==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        Node<T> temp = head;
        while(ind>1){
            temp=temp.next;
            ind--;
        }
        if(temp==null){
            System.out.println("Index Out of bound  Joseph");
            return;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        
    
        
    }
    //      1 2 3 4 5
    
    void reverse(Node<T> node){
        Node<T> prev,upcom,current;
        prev=null;upcom=null;
        
        current=node;
        
        while(current!=null){
            upcom=current.next;
            current.next=prev;
            prev=current;
            current=upcom;
            
        }
        head=prev;
        
        System.out.println("Node has been reversed joseph");
    }
    Node<T> returnRerverse(Node<T> node){
        Node<T> prev,upcom,current;
        prev=null;upcom=null;
        
        current=node;
        
        while(current!=null){
            upcom=current.next;
            current.next=prev;
            prev=current;
            current=upcom;
            
        }
        // head=prev;
        
        // System.out.println("Node has been reversed joseph");
        return prev;
    }
    
    T returnMiddle(){
        Node<T> slow=head,fast= head;
        
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow.data;
        
        
    }
    
    boolean equals(LinkedList<T> ll){
        Node<T> temp2 = ll.head;
        Node<T> temp1=head;
        
        while(temp2!=null&&temp1!=null){
            if(temp1.data!=temp2.data) return false;
            temp2=temp2.next;
            temp1=temp1.next;
        }
        
        return true;
    }
    
    
	public static void main(String[] args) {
	
	
	LinkedList<Integer> intList= new LinkedList<>();
	intList.addNode(1);
	intList.addNode(2);
	intList.addNode(3);
	intList.addNode(2);
	intList.addNode(1);
	intList.display();
// // 	LinkedList<String> strList= new LinkedList<>();
// // 	strList.addNode("abc");strList.addNode("abhghgc");strList.addNode("absdc");
// // 	strList.display();
//     intList.insertNode(11,5);
//     intList.display();
    //intList.reverse(intList.head);
   // intList.display();
    
    System.out.println(intList.returnMiddle());
    LinkedList<Integer> revList=new LinkedList<>();
    revList.head=intList.returnRerverse(intList.head);
    
    revList.display();
    if(intList.equals(revList)) System.out.println("Palindrome");
    else System.out.println("Nope");
    
    
	

	}
}
