package dataStructures.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList{
    private Boy first=new Boy(-1);
    public void addBoy(int nums){

        Boy curBoy=null;

        for(int i=1;i<=nums;i++){
            Boy boy=new Boy(i);
            if(i==1){
                first=boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }
    public void showBoy(){
        Boy curBoy=first;
        while(true){
            System.out.println(curBoy.getNo());
            if(curBoy.getNext()==first)
                break;
            curBoy=curBoy.getNext();
        }
    }

    public void countBoy(int startNo,int countNum,int nums){

        Boy helper=first;
        while (true){
            if(helper.getNext()==first)
                break;
            helper=helper.getNext();    //将helper指向first之前的结点
        }

        for (int j=0;j<startNo-1;j++){
            first=first.getNext();
            helper=helper.getNext();
        }    //移动到开始位置

        while (true){
             if (helper==first)
                 break;
            for (int j=0;j<countNum-1;j++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println(first.getNo()+"out");
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.println("last"+helper.getNo());
    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}