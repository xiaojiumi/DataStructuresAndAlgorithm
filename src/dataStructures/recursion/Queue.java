package dataStructures.recursion;

public class Queue {

    int max=4;
    int[] array=new int[max];
    static int count=0;
    public static void main(String[] args) {

        Queue queue=new Queue();
        queue.check(0);
        System.out.println(count);
    }
    private void check(int n){
        if(n==max){
            count++;
            return;
        }
         for (int i=0;i<max;i++){
              array[n]=i;
              if (judge(n)){
                  check(n+1);
              }

         }
    }

    //判断第n个皇后和之前的有没有冲突
    private boolean judge(int n){
        for (int i=0;i<n;i++){
            //array[i]==array[n]判断是否在同一列
            //Math.abs(n-i)==Math.abs(array[n]-array[i]，斜率的绝对值为1说明在同一斜线
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    private void print(){

        for (int i=0;i<array.length;i++)
            System.out.println(array[i]+" ");
        System.out.println();
    }
}
