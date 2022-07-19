public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
             Node(int data){
                this.data=data;
                this.left=null;
                this.right=null;
             }
        }
    static class binaryTree{
        static int idx=-1;
        //buliding tree using preorder i.e Root Left Right
        public static Node BuildTree(int nodes []){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left=BuildTree(nodes);
            newNode.right=BuildTree(nodes);
            return newNode;

            }
        // traversing
        
        //Preorder
        public static void Preorder(Node root){
            if(root==null){
                System.out.print(-1+" ");
                return;
            }
            System.out.print(root.data+" ");
            Preorder(root.left);
            Preorder(root.right);
        }

        //Inorder
        public static void Inorder(Node root){
            if(root==null){
                System.out.print(-1+" ");
                return ;
            }
            Inorder(root.left);
            System.out.print(root.data+" ");
            Inorder(root.right);
        }   

        //Postorder
        public static void Postorder(Node root){
            if(root==null){
                System.out.print(-1+" ");
                return ;
            }
            Postorder(root.left);
            Postorder(root.right);
            System.out.print(root.data+" ");
        }
        
        //Levelorder
        public static void Levelorder(Node root){
            if(root==null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node current =q.remove();
                if(current==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                    q.add(null);
                    }
                }else{
                    System.out.print(current.data);
                    if(current.left!=null){
                    q.add(current.left);
                    }
                    if(current.right!=null){
                    q.add(current.right);
                    }
                }
            }
        }

        }
        public static void main(String[] args) {
            int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            binaryTree tree = new binaryTree();
            Node root=tree.BuildTree(nodes);
            System.out.println(root.data);
        }

    }

