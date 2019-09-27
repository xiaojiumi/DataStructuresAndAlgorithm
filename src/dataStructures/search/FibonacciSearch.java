package dataStructures.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize=20;
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1234};
        System.out.println(fibonacciSearch(arr,1234));

    }
    public static int[] fib(){
        int[] f=new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<maxSize;i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    public static int fibonacciSearch(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        int k=0;//斐波那契下标
        int mid=0;
        int f[]=fib();
        while (high>f[k]-1){
            k++;
        }
        //因为 f[k] 值 可能大于 a 的 长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        //不足的部分会使用0填充
        int[] temp= Arrays.copyOf(arr,f[k]);
        //实际上需求使用a数组最后的数填充 temp
        for (int i=high+1;i<temp.length;i++){
            temp[i]=arr[high];
        }
        while (low<=high){
            mid=low+f[k-1]-1;
            if (key<temp[mid]){
                high=mid-1;
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //因为 前面有 f[k-1]个元素,所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                //即 在 f[k-1] 的前面继续查找 k--
                //即下次循环 mid = f[k-1-1]-1
                k--;
            }else if(key>temp[mid]){
                low=mid+1;
                // 因为后面我们有f[k-2]个元素
                k-=2;
            }else {
                if (mid<=high)
                    return mid;
                else
                    return high;
            }
        }
        return -1;
    }
}
