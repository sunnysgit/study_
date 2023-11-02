package odinueStudy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class round9_Mootube {
    static int[][] array ;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("test"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        array = new int[N-1][3];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

            array[i-1] = new int[]{p, q, usado};
        }
//        2차원 배열 print
//        System.out.println();
//        for (int i = 0; i < array.length; i++) {
//            int[] inArr = array[i];
//            for (int j = 0; j < inArr.length; j++) {
//                System.out.print(inArr[j] + " ");
//            }
//            System.out.println();
//        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int cnt = bfs(k, v);
//            System.out.println(cnt);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());

//        => 저장해야하는데, 이걸 미리 구해두는 것보단 깊이탐색 돌면서 그때그때 하는게 낫나..?
//        근데 건너건너서 연결되는건 어떻게하지? => 그냥 위에 usado정리된 배열만 탐색하면 되므로 신경 X
//        => 배열로든 뭘로든 저장하고, p 또는 q에 v가 있다면 usado가 k보다 큰게 있는지 확인, k보다만 크면 usado가 몇인지는 상관없으므로 바로 cnt+1 하고 빠져나오기. 또 안가도록 방문 체크하기.
    }

    private static int bfs(int k, int v) { // 1, 2
        int cnt = 0;

        for (int i = 0; i < array.length; i++) {
            // 1. array의 p또는 q에 v있는지 확인
            if (v == array[i][0] || v == array[i][1] ) {
                // 1-1. 있다면 array의 usado가 k보다 큰지 확인.
                if (k <= array[i][2]) {
                    // 1-1-1. 크다면 cnt+1하며 빠져나가기.
                    cnt++;
                }
                    // 1-1-2. 작다면 계속 돌기.
            }
                // 1-2. 없다면 빠져나가기.
        }
        return cnt;
    }
}
