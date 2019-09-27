package dataStructures.tree;

public class ArrBInaryTreeDemo {


    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0); // 1,2,4,5,3,6,7
    }
}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //index数组下标
    public  void preOrder(int index){
        if(arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);
        if ((index*2+1)<arr.length){
            preOrder(2*index+1);
        }
        //向右递归遍历
        if((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}