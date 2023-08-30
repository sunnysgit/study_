package odinueStudy;

import java.util.*;


public class day6_과제진행하기 {
    public static void main(String[] args) {
//        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"},{"math", "12:30", "40"}};
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        System.out.println(solution(plans));
    }
    // 순서대로 과제 시작
    // 새로운 과제 시작할 시간이 되서, 진행 중이던 과제가 아직 안 끝났다면, 진행 중이던거 stack에 넣고 새로 시작
    // 진행중이던거 끝냈는데 다음 시작시간까지 시간이 있다면, (단, 넣어둔 과제는 맨 끝 부터)=> 그럼 stack에 넣어둔 과제 진행.
    static class Study {
        int index;
        String name;
        int start;
        int playtime;

        public Study(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    public static int getTime(String time) {
        // string 시간을 integer 분으로 환산
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

    public static List<String> solution(String[][] plans) {
        String[] answer = new String[plans.length-1];
        List<String> end = new ArrayList<String>();
        // start 시작 시간 순으로 정렬 필요
        Arrays.sort(plans, Comparator.comparing((String[] o) -> o[1]));


        // 멈춰둘 과제 넣을 stack
        Stack<Study> hold = new Stack<>();

        // 1. 모든 과제 순서대로 한 번 씩 + 1번 과제 시작
        for (int i = 0; i < plans.length - 1; i++) {
        // 2. 다음 과제 진행시간 ㄱㅊ은지 체크 ( => 시간 메소드 따로
            // 현재 진행 중인 과제의 시작시간과 경과시간 구하기
            int start = getTime(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);
            // 다음 진행 예정 과제의 시작시간
            int startNext = getTime(plans[i+1][1]);

            // 2-1. 아직 안 끝났는데, 다음 과제 시간이 된다면, 과제를 멈추고(stack에 넣고) 1번으로 돌아감.
                // 현재의 시작시간+경과시간이 다음 과제의 시작시간보다 크다면 못 끝난채로 hold에 보관해야함. playtime은 경과시간 차감해서 넣어줘여함.
            if (start+playtime > startNext) {                      // 1번의 경우 30-(730-700) = 0
                hold.push(new Study(plans[i][0].toString(), start, playtime-(startNext-start)));
                System.out.println(i + "번 : " + plans[i][0].toString());
                System.out.println(playtime-(startNext-start));
            }

            // 3. 현재 과제 완료 (=> 시작시간+경과시간이 다음과목 시작시간 보다 작다면 과제 완료니까 end에 넣어.
                // 현재의 시작시간+경과시간이 다음 과제 시작시간보다 작거나 같다면, 현재 과제는 완료됨.
            if (start+playtime <= startNext) {
//                end.add(Arrays.toString(plans[i]));
                end.add(plans[i][0].toString());
                System.out.println(i + "번 : " + plans[i][0].toString());

                int timeRemaining = startNext - (start+playtime);

                // 4. 현재 과제 완료하고도, 다음 과제 시작 전까지 시간이 남으면서 멈춰둔 과제가 있어? 그러면 stack에 넣어둔 과제 다시 꺼내.
                if (timeRemaining > 0 && !hold.isEmpty()) {
                    Study std = hold.pop();


                    // 남은 시간이 꺼낸거의 playtime보다 크거나 같다면, 과제 끝낼 수 있으니까 end에 넣어
                    if (timeRemaining > std.playtime) {
    //                    end.add(study.toString());
                        end.add(std.name);
                    } else {    // 아니라면 못 끝낸거니까 다시 hold에 넣어, playtime은 남은시간만큼 차감해서 변경해서 넣어!
                        std.playtime = std.playtime - timeRemaining;
                        hold.push(std);
                    }
                }

            }
            // 마지막 번째 과제는 무조건 끝내는거니까 그냥 end에 넣어주기 (=> 근데 이게 마지막에 1번만 들어가야하는데.. 반복문 돌 때 마다 들어가는 듯..?
//            end.add(plans[plans.length-1][0]);
        }
            // 마지막 번째 과제는 반복문 밖에서 넣어주기
        end.add(plans[plans.length - 1][0]);
        System.out.println("마지막!");
        System.out.println(plans[plans.length - 1][0]);
        System.out.println("마지막!");
        // 반복
        // 5. 모든 과제 한 번씩 탐색했으니, 멈춰둔 과제들 있으면 마지막에 넣었던 것부터 순서대로 꺼내.
        while (!hold.isEmpty()) {
            Study std = hold.pop();
            end.add(std.name);
            System.out.println("홀딩!");
            System.out.println(std.name);
            System.out.println("홀딩!");
        }
        System.out.println("**********************************");
        for (int i = 0; i < end.size(); i++) {
            System.out.println(end.get(i));
        }
//        for (int i = 0; i < end.size(); i++) {
//            for (int j = 0; j < 1; j++) {
//                answer[i] = end.get(i).get(0);
//            }
//
//        }
//        for(int k = 0; k < end.size(); k++) {
//            answer[k] = end.get(k);
//        }
        return Arrays.asList(end.toArray(new String[end.size()]));
    }
}
