package dataStructures.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组必须是有序的
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,89,1000,1000,1234};
        ArrayList<Integer> resIndexs=binarySearch2(arr,0,arr.length-1,1000);
        System.out.println(resIndexs);

    }
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        if (left>right)
            return -1;
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(findVal>midVal){
         return    binarySearch(arr, mid+1, right, findVal);
        }else if(findVal<midVal){
            return    binarySearch(arr, left, mid-1, findVal);
        }else
            return mid;
    }

    //找到多个相同的数的下标
    //			 * 思路分析
//			 * 1. 在找到mid 索引值，不要马上返回
//			 * 2. 向mid 索引值的左边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 3. 向mid 索引值的右边扫描，将所有满足 1000， 的元素的下标，加入到集合ArrayList
//			 * 4. 将Arraylist返回
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        if (left>right)
            return new ArrayList<>();
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if(findVal>midVal){
            return    binarySearch2(arr, mid+1, right, findVal);
        }else if(findVal<midVal){
            return    binarySearch2(arr, left, mid-1, findVal);
        }else{
            ArrayList<Integer> resIndexlist = new ArrayList<Integer>();
            int temp=mid-1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                   resIndexlist.add(temp--);
            }
            resIndexlist.add(mid);
            temp=mid+1;
            while (true){
                if (temp>0||arr[temp]!=findVal){
                    break;
                }
                resIndexlist.add(temp++);
            }
            return resIndexlist;
        }

    }
}
