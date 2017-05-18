import java.util.Arrays;
import java.util.Stack;

/**
 * Created by jackie on 17-5-18.
 */

/**
 * LeetCode 85. Maximal Rectangle
 * Change it to "Largest Rectangle in Histogram"
 * Every raw runs above algorithm, then you'll get the max Rectangele
 *
 * */
public class largestRectangle {
    public static void main(String args[]){
        char str[][]={{'1','0','1','0','0'},
                {'1','0','0','1','1'},
                {'1','1','1','0','1'}};
        System.out.println(maximalRectangle(str));

    }

    public static int maximalRectangle(char[][] matrix) {
        int number[][]=new int[matrix.length][];
        int i,j;
        for( i=0;i<matrix.length;i++){
            number[i] = new int[matrix[i].length];
            for( j=0;j<matrix[i].length;j++){
                number[i][j] = matrix[i][j]-'0';
                if(i>=1){
                    if(number[i][j]!=0)
                        number[i][j]+=number[i-1][j];
                }
            }
        }
        int maxarea=0;
        for(i=0;i<number.length;i++){
            maxarea = Math.max(maxarea,largestRectangleArea(number[i]));
        }

        return maxarea;
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int newheights[] = new int[heights.length+1];
        int i;
        for(i=0;i<heights.length;i++){
            newheights[i] = heights[i];
        }
        newheights[i]=0;
        i=0;
        int area=0;
        while(i<newheights.length){
            if(s.empty()||newheights[s.peek()]<=newheights[i]){
                s.push(i);
                i++;
            }else{
                int t=s.pop();
                area = Math.max(area,newheights[t]*(s.empty()?i:i-s.peek()-1));
            }
        }
        return area;
    }
}
