package odinueStudy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
    class Study {
        int index;
        int start;
        int playtime;
        public Study(int index, int start, int playtime) {
            this.index = index;
            this.start = start;
            this.playtime = playtime;
        }
    }
    public static String[] solution(String[][] plans) throws ParseException {
        List<String> answer = new ArrayList<>();
        // 멈춰둘 과제 넣을 stack
        Stack<String[]> hold = new Stack<>();
        // start 시작 시간 순으로 정렬 필요
        Arrays.sort(plans, Comparator.comparing((String[] o) -> o[1]));
//        List<String> plans = (List<String>) new ArrayList<>(Arrays.asList(plan));
        // 1. 1번 과제 진행
        for (int i = 0; i < plans.length; i++) {
        // 2. 다음 과제 진행시간 ㄱㅊ은지 체크 (=> 시간 메소드 따로 뺼까?
            LocalTime startNow = LocalTime.parse(plans[i][1]);
            LocalTime startNext = LocalTime.parse(plans[i+1][1]);
            // startNow + playtime
            LocalTime timeLapse = startNow.plusMinutes(Long.parseLong(plans[i][2]));

            //2-1. 시작시간+경과시간이 다음과목 시작시간 보다 작다면 과제 끝낸거니까 answer에 넣어.
            if (timeLapse.isBefore(startNext)) {
                answer.add(plans[i][0]);
            } else {
            // 2-2. 아직 안 끝났는데, 다음 과제 시간이 된다면, 과제를 멈추고(stack에 넣고) 1번으로 돌아감.
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                Date dateNow = sdf.parse(String.valueOf(startNow));
                Date dateNext = sdf.parse(String.valueOf(startNext));

                long diffMin = Long.parseLong((dateNow.getTime() - dateNext.getTime())/60000 + plans[i][2]);

                plans.get(i).set(2, diffMin);
                hold.add(plans[i]);
            }


        }
        // 3. 현재 과제 완료
        // 4. 다음 과제 시작 전까지 시간이 남아? 그러면 stack에 넣어둔 과제 다시 진행.

        // 반복
        // 5. 모든 과제 탐색했다면, 멈춰둔 과제 순서대로 진행.


        return answer;
    }
}
