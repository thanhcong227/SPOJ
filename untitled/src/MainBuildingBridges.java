import java.io.*;

public class MainBuildingBridges {

    int n;
    pi a[1001];
    int dp[1001][3000];

    int solve(int id , int lst){
        if(id == n)
            return 0;
        int &res = dp[id][lst];
        if(res != -1)
            return res;
        res = 0;
        res = max(res , solve(id + 1 , lst));
        if(a[id].second >= lst)
            res = max(res , solve(id + 1 , a[id].second) + 1);
        return res;
    }

    public static void main(String[] args) {
        int t;
        sc(t);
        while(t--){
            mem(dp , -1);
            sc(n);
            for(int i = 0 ; i  <n ; ++i){
                sc(a[i].first);
                a[i].first += 1005;
            }
            for(int i = 0 ; i < n ; ++i){
                sc(a[i].second);
                a[i].second += 1005;
            }
            sort(a , a + n);
            int ans = solve(0 , 0);
            printf("%d\n" , ans);
        }
    }
}

