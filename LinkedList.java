public class LinkedList {
    //Node creation
    class Node {
        String data;
        Node next;
        
        //Node constructor
        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
    // constructing head
    Node head;
    private int size;
    LinkedList(){
        size=0;
    }
    //add
    //1First
    public void addFirst(String data){
        Node newNode = new Node(data);
        newNode.next= head;
        head= newNode;
        size++;
    }
    //2Last
    public void addLast(String data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node currNode= head;
        while(currNode.next!=null){
            currNode= currNode.next;
        }
        currNode.next=newNode;
        size++;
    }
    //remove
    //remove from first
    public void removeFirst(){
        if(head==null){
            System.out.println("List is empty");
        }
        head=this.head.next;
         size--;
    }
    // remove from last
    public void removeLast(){
        if(head==null){
            System.out.println("List is empty");
        }
        Node currNode = head;
       Node lastNode = head.next;
       while(lastNode.next != null) {
        currNode = currNode.next;
        lastNode = lastNode.next;
    }

    currNode.next = null;
     size--;
    }
       
    // add at given position
    public void addAt(String data, int position){
        int i=0;
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node currNode= head;
        while(i<position-1){
            currNode= currNode.next;
            i++;
        }
        newNode.next=currNode.next;
        currNode.next=newNode;
        size++;
    }
    // to print size of list
    public void lSize(){
        System.out.println("");
        System.out.println(size+1); 
    }
    // PrintList
    public void printList(){
        System.out.println("");
        Node currNode= head;
        while(currNode!=null){
            System.out.print(currNode.data+"-->");
            currNode= currNode.next;
        }
        System.out.print("NULL");
        return;
    }
    // Main
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast("Hey");
        list.addLast("its");
        list.addLast("me");
        list.addLast("shivanshu");
        list.addLast("!");
        list.printList();
        list.removeLast();
        list.printList();
        list.addFirst("!!");
        list.printList();
        list.addAt("hello",5);
        list.printList();
        list.lSize();


    }
}
