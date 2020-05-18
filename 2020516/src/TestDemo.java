/*
 * @program: 2020516
 * @description
 * 将数组分成相等的 三部分
 * @author: mrs.yang
 * @create: 2020 -05 -16 17 :11
 */

import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public boolean canThreePartsEqualSum(int[] A){
        int sum=0;
        for (int i:A) {
            sum+=i;
        }
        if(sum%3!=0){
            return false;
        }
        int tmp=0;
        int n=0;
        for (int i = 0; i <A.length ; i++) {
            tmp+=A[i];
            if(tmp==sum/3){
                tmp=0;
                n++;
            }
        }
        return n>=3;
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k){
        int[][] newGird=new int[grid.length][grid[0].length];
        while(k>0){
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length-1; j++) {
                    newGird[i][j+1]=grid[i][j];
                }
            }
            for (int i = 0; i <grid.length-1 ; i++) {
                    newGird[i][0]=grid[i][grid[0].length-1];
            }
            newGird[0][0]=grid[grid.length-1][grid[0].length-1];
            k--;
            grid=newGird;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> tmp = new ArrayList<>();
            result.add(tmp);
            for (int v : row)
                tmp.add(v);
        }
        return result;
    }

}
