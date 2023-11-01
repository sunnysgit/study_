package odinueStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class round9_Mootube {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());
        }
//        => 저장해야하는데, 이걸 미리 구해두는 것보단 깊이탐색 돌면서 그떄그때 하는게 낫나..?
//        근데 건너건너서 연결되는건 어떻게하지? 
    }
}
