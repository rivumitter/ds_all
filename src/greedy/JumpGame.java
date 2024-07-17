package greedy;

public class JumpGame {

    public static void main(String[] args) {

        // https://leetcode.com/problems/jump-game/description/
        int[] arr = {2,3,1,0,4};

        System.out.println(canJump(arr));
    }

    private static boolean canJump(int[] arr) {

        int maxIndex = 0, totalJumpIndex = 0;

        for (int i=0;i<arr.length;i++) {
            if(i > maxIndex)
                return false;
            totalJumpIndex = i + arr[i];
            maxIndex = Math.max(maxIndex, totalJumpIndex);
        }
        return true;
    }
}
