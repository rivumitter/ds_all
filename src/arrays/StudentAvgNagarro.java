package arrays;

public class StudentAvgNagarro {

    public static void main(String[] args) {

        int m = 3, n = 5;

        int[][] marks = {
                {75, 76, 65, 87, 87},
                {78, 76, 68, 56, 89},
                {67, 87, 78, 77, 65}
        };

        int[] ans = totalMarksExceptLowest(m, n, marks);

        for (int num : ans)
            System.out.print(num + " ");
    }

    private static int[] totalMarksExceptLowest(int m, int n, int[][] marks) {
        int[] ans = new int[m];

        // visit column wise
        int lowestColumn = 0;

        int lowest = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) { // col
            int sum = 0;
            for (int j = 0; j < m; j++) {  // row
                sum+=marks[j][i];
            }
            int avg = sum / m;
            if(avg < lowest) {
                lowest = avg;
                lowestColumn = i;
            }
        }
        int k = 0;
        for(int i=0;i<m;i++){
            int sum = 0;
            for(int j=0;j<n;j++) {
                if(lowestColumn == j)
                    continue;
                sum+=marks[i][j];
            }
            ans[k++] = sum;
        }

        return ans;
    }
}
