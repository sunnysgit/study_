package odinueStudy;

import java.util.Arrays;

// 1. 탐색을 위해 2차원 배열로 만들어주기
// 2-1. P가 있는 경우 => P를 기준으로 8방 탐색
    // 2-1-1. P => return 0
    // 2-1-2. X => return 1
    // 2-1-3. O
        // 2-1-3-1. P => return 0
        // 2-1-3-2. X => return 1
        // 2-1-3-3. O => return 1
// 2-2. P가 없는 경우 => 바로 return 1
public class round9_거리두기확인하기 {
    public static void main(String[] args) {
//        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "POPOP", "XPXPX"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        // 정답 저장용 배열
        int[] result = new int[places.length];

        for (int i = 0; i < places.length; i++) {
//            System.out.println(Arrays.toString(places[i]));
            result[i] = isOk(places[i]);
        }
        System.out.println(Arrays.toString(result));
    }

    private static int isOk(String[] place) {   // place = {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
        // 1. 탐색을 위해 2차원 배열로 만들어주기
        char[][] target = new char[5][5];
        for (int i = 0; i < target.length; i++) {
            target[i] = place[i].toCharArray();
//            System.out.println(target[i]);      // target[0] = POOOP
//            System.out.println("------------------------------");
        }
        // [[P, O, O, O, P], [O, X, X, O, X], [O, P, X, P, X], [O, O, X, O, X], [P, O, X, X, P]]
//        System.out.println(Arrays.deepToString(target));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (target[i][j] == 'P') {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];

                        if (ni < 0 || ni >= 5 || nj < 0 || nj >=  5 || (ni == i && nj == j)) {
                            continue;
                        }
                        if (ni >= 0 && nj >= 0 && ni < 5 && nj < 5) {

                            if (target[ni][nj] == 'P') {
                                return 0;
                            } else if (target[ni][nj] == 'O') {
                                for (int l = 0; l < 4; l++) {
                                    int ni1 = ni + dx[l];
                                    int nj1 = nj + dy[l];
                                    if (ni1 < 0 || ni1 >= 5 || nj1 < 0 || nj1 >= 5 || (ni1 == i && nj1 == j)) {
                                        continue;
                                    }
                                    if (ni1 >= 0 && nj1 >= 0 && ni1 < 5 && nj1 < 5) {
                                        if (target[ni1][nj1] == 'P') {
                                            return 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}
