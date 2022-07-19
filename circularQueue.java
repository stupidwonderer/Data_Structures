// circular Queue using Array
public class circularQueue {
    static class Queue{
        static int arr[];
        static int size;
        static int rear=-1;
        static int front=-1; 
        Queue(int n){
            arr= new int[n];
            this.size=n;
        }
        public static boolean isEmpty(){
             return front==-1&&rear==-1;
        }
        public static boolean isFull(){
            return (rear+1)%size==front;
        }
        public static void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(front==-1) front=0;
            rear=(rear+1)%size;
            arr[rear]=data;
        }
        public static int remove(){
            if(isEmpty()) {
                System.out.println("Queue is already empty");
                return -1;
            }
            int result=arr[front];
            if(front ==rear){
                front = rear=-1;
            }else front=(front+1)%size;
            return result;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }else {
                 return arr[front];
            }
        }

    }
    public static void main(String[] args) {
        Queue queue= new Queue(5);
        queue.peek();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.peek());
        queue.add(5);
        queue.add(6);
        queue.remove();
        queue.add(6);
    }

}
