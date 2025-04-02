import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int H, W;
    static int[] map;
		static int res = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < W ; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < W-1 ; i++) {
            int left = 0; int right = 0;

            for(int j = 0 ; j < i ; j++) { // 왼쪽에서부터 탐색
                left = Math.max(map[j], left);
            }

            for(int j = i+1 ; j < W ; j++) { // 오른쪽에서부터 탐색
                right = Math.max(map[j], right);
            }

            if(map[i] < left && map[i] < right) {
                res += Math.min(left, right) - map[i]; // 높이가 더 적은 쪽의 높이만큼 고임
            }
        }

        System.out.println(res);

    }
}


