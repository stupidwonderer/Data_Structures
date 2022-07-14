// stack implementation using Linked List 
public class StackClass {
    static class Node{
        int data;
        Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
    }
    static class Stack{
        public static Node head=null;
        public static boolean isEmpty(){
            return (head==null);
        }
        
        public void push(int data){
            Node newNode = new Node(data);
            if (head==null) {
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;


        }

        public static int pop(){
            if (isEmpty()==true) return -1;
            Node top=head;
            head=head.next;
            return (top.data);
        }

        public static int peek(){
            if (isEmpty()==true) return -1;
            Node top= head;
            return ((top.data));
        }
     }
     public static void main(String[] args) {
        Stack stc = new Stack();
        System.out.println(stc.isEmpty());
        stc.push(1);
        stc.push(2);
        stc.push(3);
        stc.push(4);
        stc.push(5);
        while(!stc.isEmpty()) {
            System.out.println(stc.peek());
            stc.pop();
        }
        System.out.println(stc.isEmpty());

     }
    
}
