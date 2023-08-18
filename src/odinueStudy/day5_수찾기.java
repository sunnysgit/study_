package odinueStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class day5_수찾기 {
    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < M; i++) {
            System.out.println(bSearch(targetArr[i], 0, N-1));
        }
    }

    static int N;
    static int M;
    static int[] arr;
    static int[] targetArr;

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        targetArr = new int[M];

        for (int i = 0; i < M; i++) {
            targetArr[i] = Integer.parseInt(st.nextToken());
        }

    }

    public static int bSearch(int n, int start, int end) {
        if (start > end) {
            return 0;
        }


        int mid = (start + end)/2;

        if (arr[mid] < n) {
            return bSearch(n,mid + 1, end);
        } else if (arr[mid] > n) {
            return bSearch(n, start, mid - 1);
        } else {
            return 1;
        }

    }
}
