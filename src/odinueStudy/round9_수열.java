package odinueStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*10 5
3 -2 -4 -9 0 3 7 13 8 -3
답 31*/
/*10 2
3 -2 -4 -9 0 3 7 13 8 -3
답 21*/
public class round9_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 10
        int K = Integer.parseInt(st.nextToken());   // 2

        // 입력받은 배열 N개
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 합을 저장하는 배열
        int[] hap = new int[N-K+1];
        // 각 라운드 시작값부터 K개까지 더하기
        for (int i = 0; i < (N-K+1); i++) {
            for (int j = i; j < (i+K); j++) {
                hap[i] += arr[j];
            }
        }

        Arrays.sort(hap);
        int max = hap[hap.length-1];

        System.out.println(max);
    }
}
