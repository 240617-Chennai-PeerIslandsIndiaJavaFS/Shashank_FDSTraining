import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter rows of matrix 1: ");
        int rows1=sc.nextInt();
        System.out.println("enter columns of matrix 1: ");
        int cols1=sc.nextInt();
        System.out.println("enter of matrix 1: ");
        int[][] m1=new int[rows1][cols1];
        for(int i=0;i<rows1;i++){
            for(int j=0;j<cols1;j++){
                m1[i][j]= sc.nextInt();
            }
        }
        System.out.println("enter rows of matrix 2: ");
        int rows2=sc.nextInt();
        System.out.println("enter columns of matrix 2: ");
        int cols2=sc.nextInt();
        System.out.println("enter of matrix 2: ");
        int[][] m2=new int[rows2][cols2];
        for(int i=0;i<rows2;i++){
            for(int j=0;j<cols2;j++){
                m2[i][j]= sc.nextInt();
            }
        }
        int[][] m3=new int[rows1][cols2];
        for(int i=0;i<rows1;i++){
            for(int j=0;j<cols2;j++){
                int sum=0;
                for(int k=0;k<rows1;k++){
                    sum=sum+(m1[i][k]*m2[k][j]);
                    m3[i][j]=sum;
                }
            }
        }

        for(int i=0;i<rows1;i++){
            for(int j=0;j<cols2;j++){
                System.out.print(m3[i][j]+" ");
            }
            System.out.println();
        }
    }
}