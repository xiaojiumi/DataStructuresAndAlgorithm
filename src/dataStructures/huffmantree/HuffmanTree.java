package dataStructures.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {


    public static void main(String[] args) {
        int arr[]={13,7,8,3,29,6,1};
      //  create(arr);
        Node root=create(arr);
        preOrder(root);
    }

    public static void preOrder(Node root){
        if(root!=null)
            root.preOrder();
    }

    public static Node create(int arr[]){
        List<Node> nodes=new ArrayList<>();
        for (int v:arr){
            nodes.add(new Node(v));
        }
        while (nodes.size()>1){
            Collections.sort(nodes);
            // System.out.println(nodes);
            Node left=nodes.get(0);
            Node right=nodes.get(1);
            Node parent=new Node(left.value+right.value);
            parent.left=left;
            parent.right=right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public void preOrder(){
        System.out.println(this);
        if (this.left!=null)
            this.left.preOrder();
       if(this.right!=null)
            this.right.preOrder();
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大
        return this.value-o.value;
    }
}