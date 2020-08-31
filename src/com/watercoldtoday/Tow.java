package com.watercoldtoday;

import java.util.Arrays;
import java.util.Scanner;

public class Tow {
    static int n,m;
    static char [][]board=new char[100][100];
    public static void solve(char board[][]){
        //横向坐标长度
       // n=board.length;
        if(n==0)
            return;
        //纵向坐标长度
       // m=board[0].length;
        //根据题目所述，不能被覆盖的岛屿是边界为O，或与边界为O直接和间接相连的，所以从边界开始找
        //先从第一行和最后一行查起
        for(int i=0;i<n;i++){//n代表横坐标，所以横坐标都是i,进行第一行和最后一行的调节
            DFS(board,i,0);//第一行查起
            DFS(board,i,m-1);//最后一行查起
        }
        for(int i=0;i<m;i++){
            //i为什么不等于0？因为第一行第一个元素已经筛选过了，为什么i不小于m？因为最后一行第一个元素也已经筛选过了
            DFS(board,0,i);
            DFS(board,n-1,i);
        }

        //由于我们之前把在边界的O以及与边界直接和间接相邻的O改成了A所以需要进行对二维数组进行恢复
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }
            }
        }
    }

    private static void DFS(char [][]board,int x,int y) {
        //如果从边界查起，如果越界了或者边界的元素不等于O就不用覆盖，所以直接返回
        if(x<0||x>=n||y<0||y>=m||board[x][y]!='O'|| board[x][y] == '\u0000'){
            return;
        }
        //从边界继续从上下左右四个方向扩展
        board[x][y]='A';
        System.out.println("x ,y" + x + "," + y);
        DFS(board,x+1,y);//向右扩展
        DFS(board,x-1,y);//向左扩展
        DFS(board,x,y+1);//向上扩展
        DFS(board,x,y-1);//向外扩展
    }

    public static void main(String[] args) {
        //开辟数组大小的横坐标n,开辟数组纵坐标m
        Scanner input=new Scanner(System.in);
        n=input.nextInt();
        m=input.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                String s=input.next();
                char c=s.charAt(0);
                board[i][j]=c;
            }
        }
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(board[3][1]);
        solve(board);
        System.out.println(board[3][1]);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
