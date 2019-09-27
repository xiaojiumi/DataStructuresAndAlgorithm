package dataStructures.recursion;

public class migong {
    public static void main(String[] args) {

        // 先创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用1 表示墙
        // 上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;
//		map[1][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        System.out.println("====================== ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    //i,j起始点，终点（6，5）
    //0没走过，1墙，2表示通路，3表示走过但是走不通
    //策略：先下再右->上-》左
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5]==2)
                return true;
        else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (setWay(map,i+1,j))
                    return true;
               else if (setWay(map,i,j+1))
                    return true;
                else if (setWay(map,i-1,j))
                    return true;
                else if (setWay(map,i,j-1))
                    return true;
                else{
                    map[i][j]=3;
                    return false;
                }
            }else
                return false;
        }
    }
}
