import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class MatrixDuplication{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter number of rows");
        int rows= sc.nextInt();
        System.out.println("enter number of columns");
        int cols= sc.nextInt();
        int[][] matrix=new int[rows][cols];
        Set<Integer> duplicate = new HashSet<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.println("enter value");
                int n=sc.nextInt();
                if(duplicate.contains(n)){
                    System.out.println("entered duplicated value, enter a valid number: ");
                    j=j-1;
                }else{
                    matrix[i][j]=n;
                    duplicate.add(n);
                }
            }
        }
        System.out.println("the matrix is: ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}