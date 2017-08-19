/**
 * Created by jackie on 17-8-19.
 */
public class burstBalloons {
    public int maxCoins(int[] nums) {
        int number[] = nums;
        int num[] = new int[number.length+2];
        num[0]=num[number.length+1]=1;
        for(int i=1;i<=number.length;i++){
            num[i]=number[i-1];
        }

        int dp[][] = new int[num.length][num.length];

        // init part
        for(int i=0;i<num.length;i++){
            for(int j=0;j<num.length;j++){
                dp[i][j]=0;
            }
        }

        int N = number.length;
        num[0]=num[N+1]=1;
        for(int len=1;len<=N;len++){
            for(int start =1;start<=N-len+1;start++){
                int end = start+len-1;
                for(int k = start;k<=end;k++){
                    int coin = dp[start][k-1]+dp[k+1][end]+ num[start-1]*num[k]*num[end+1];
                    if(coin>dp[start][end]){
                        dp[start][end] = coin;
                    }
                }
            }
        }
        return dp[1][N];
    }
}
