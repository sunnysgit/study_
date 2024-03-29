package odinueStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class day6_더맵게 {
    //  Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
    //  섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    //  Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
    //  Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
    //  모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
//        int[] scoville = {0, 0, 1, 2};
        int K = 7;


        System.out.println(solution(scoville, K));

    }
    static List<Integer> nums = new ArrayList<>();
    static int answer = 0;
    static List<Integer> minList = new ArrayList<>();
    static int min = 0;
    static int index = 0;
    static int cnt = 0;
    static int newFood = 0;

    //  섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    public static int solution(int[] scoville, int K) {
//        nums = Arrays.stream(scoville)
//                .boxed()
//                .collect(Collectors.toList());
        for (int n : scoville) {
            nums.add(n);
        }


        // 반복문으로 배열(->리스트)의 각 요소가 K보다 큰지 확인, K보다 작은게 1개라도 있다면 음식섞기.
        for (int i = nums.size() - 1; i >= 0; i--) {
            int n = nums.get(i);
            if ( n < K ) {
                // 음식 섞기를 위해서 스코빌지수가 가장 작은 거 2개 뽑기 후 식에 대입.
                //최소값 구하기 메서드로 구한 후 그거 제외한 배열 다시 넣어서 2개될때까지 반복.
                while (cnt < 2) {
                    min = getMin(nums);
                    minList.add(min);
                    if (min == -2) {
                        answer = -1;
                        return answer;
                    }
                    index = nums.indexOf(min);
                    nums.remove(index);
                    cnt += 1;
                }
//                do {
//                    min = getMin(nums);
//                    minList.add(min);
//                    //                 index = getMin(nums).index;
//                    index = nums.indexOf(min);
//                    nums.remove(index);
//                    cnt += 1;
//                } while (cnt < 2);
                newFood = minList.get(0) + (minList.get(1) * 2);
                nums.add(newFood);
                minList.clear();
                cnt = 0;
                answer += 1;
            }

        }
        if (newFood < K) {
            answer = -1;
        }

        return answer;
    }
//    static class Minimum {
//        public int min;
//        public int index;
//        public Minimum(int min, int index) {
//            this.min = min;
//            this.index = index;
//        }
//    }
    //최소값 구하기.
    static int getMin(List<Integer> nums) {
        if (nums.size() != 0) {
            return -2;
        }
        // 초기값
        min = nums.get(0);
//        index = 0;
        // 최소값 구하기
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < min) {
                min = nums.get(i);
//                index = i;
            }
        }
//        for (int num : nums) {
//            if (num < min) {
//                min = num;
//            }
//        }

        return min;
    }
}
