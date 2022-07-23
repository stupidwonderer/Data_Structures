import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class TreeQues {
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
        
        public static int CountOfNodes(Node root){
            if(root==null) return 0;
            int leftnodes= CountOfNodes(root.left);
            int rightnodes= CountOfNodes( root.right);
            return leftnodes+rightnodes+1;

        }
        public static int SumOfNodes(Node root){
            if(root==null) return 0;
            int leftNodeSum=SumOfNodes(root.left);
            int rightNodeSum=SumOfNodes(root.right);

            return leftNodeSum+rightNodeSum+root.data;
        } 
        public static int HieghtOfTree(Node root){
            if(root==null) return 0;
            int LeftHieght=HieghtOfTree(root.left);
            int RightHieght=HieghtOfTree(root.right);
            int Hieght = Math.max(LeftHieght,RightHieght)+1;
            return Hieght;
        } 
        //approach1
        public static int Diameter(Node root){
            if(root==null) return 0;
            int Rightdiameter=Diameter(root.left);
            int Leftdiameter=Diameter(root.right);
            int diameter3=HieghtOfTree(root.left)+HieghtOfTree(root.right)+1;
            int max1 = Math.max(Rightdiameter,Leftdiameter);
            return Math.max(max1,diameter3);
        }  
        //approach2
        static class Treeinfo{
            int ht;
            int diam;
              Treeinfo(int ht, int diam){
                this.ht=ht;
                this.diam=diam;
              }
        }
        public static Treeinfo Diameter2(Node root){
            if (root==null){
                return new Treeinfo(0,0);
            }
            Treeinfo lefttree=Diameter2(root.left);
            Treeinfo righttree=Diameter2(root.right);

            int hieght=Math.max(HieghtOfTree(root.left),HieghtOfTree(root.right))+1;
            int diameter=Math.max(Math.max(Diameter(root.left),Diameter(root.right)),HieghtOfTree(root.left)+HieghtOfTree(root.right)+1);
            Treeinfo info= new Treeinfo(hieght,diameter);
            return info;
        }
        public static int SumatkthLevel(Node root ,int k){
            ArrayList<Integer> list= new ArrayList<Integer>();
            int sum=0;
            if(root==null) return -1;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node current =q.remove();
                if(current==null){
                    list.add(sum);
                    sum=0;  
                    if(q.isEmpty()){
                        break;
                    }else{
                    q.add(null);
                    }
                }else{
                    sum+=current.data;
                    if(current.left!=null){
                    q.add(current.left);
                    }
                    if(current.right!=null){
                    q.add(current.right);
                    }
                }
            }
        return list.get(k-1);    
        }
        public static void main(String[] args) {
            int nodes1[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
            binaryTree tree = new binaryTree();
            Node root=tree.BuildTree(nodes1);
            System.out.println(root.data);
            System.out.println(tree.CountOfNodes(root));
            System.out.println(tree.SumOfNodes(root));
            System.out.println(tree.HieghtOfTree(root));
            System.out.println(tree.Diameter(root));
            System.out.println((tree.Diameter2(root)).diam);
            System.out.println(tree.SumatkthLevel(root,3));
            
        }

    }
    }
