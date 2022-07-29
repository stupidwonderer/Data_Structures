import java.util.*;
public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;
             Node(int data){
                this.data=data;
             }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root; 
        }

        if(root.data>val){
            //leftsubtree
            root.left=insert(root.left,val);
            return root;
        }

        else if(root.data<val){
            //leftsubtree
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static void Inorder(Node root){
        if (root==null){
            return ;
        }
        Inorder(root.left);
        System.out.print(root.data+" ");
        Inorder(root.right);
    }
    public static boolean search(Node root,int key){ // complexity = O(Hieght), O(logn)(Average case)
        if(root==null){
            return false;
        }
        boolean found=false;
        if(root.data==key){
            found=true;
        }
        if(root.data>key){
            search(root.left,key);
        }
        if(root.data<key){
            search(root.right,key);
        }
        return found;
    }
    public static Node inoredersuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }  
        return root; 
        }
    public static Node Delete(Node root, int val){
        if(root.data>val){
            root.left=Delete(root.left,val);
        }
        else if(root.data<val){
            root.right=Delete(root.right,val);
        }

        else{
            //root==val
            // case 1 No child 
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2 only one child 
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            Node IS = inoredersuccessor(root.right);
            root.data=IS.data;
            root.right=Delete(root.right,IS.data);
        }
        return root;
    }
    public static void printInRange(Node root, int x , int y){
        if(root==null){
            return;
        }
        if(root.data>=x && root.data<=y){
            printInRange(root.left,x,y);
            System.out.print(root.data+" ");
            printInRange(root.right,x,y);
        }
        else if(root.data>=y){
            printInRange(root.left,x,y);
        }
        else{
            printInRange(root.right,x,y);
        }
    }
    public static void printpath(ArrayList path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"-->");
        }
        System.out.println();
    }
    public static void rootToLeafPaths(Node root, ArrayList path){
        if(root==null){
            return;
        }
        path.add(root.data);
        // leaf Node
        if(root.left==null&&root.right==null){
            printpath(path);
        }
        else {
            ///Non leaf Node
            rootToLeafPaths(root.left,path);
            rootToLeafPaths(root.right,path);
        }
        path.remove(path.size()-1);
        
        

    }
    public static void main(String[] args) {
        int val[]={8,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<val.length;i++){
            root=insert(root,val[i]);
        }
        Inorder(root);
        System.out.println();
        System.out.println(search(root,1212343));
        Inorder(root);
        Delete(root,4);
        Inorder(root);
        printInRange(root,4,13);
        System.out.println();
        rootToLeafPaths(root, new ArrayList<>());
    }

}

