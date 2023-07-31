package odinueStudy;

import java.util.Stack;

public class day2_크래커인형뽑기 {
    public static void main(String[] args) {
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};

        System.out.println(solution(board, moves));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();   // 뽑힌 인형 담길 바구니
        stack.push(0);

//        for (int i = 0; i < moves.length; i++) {
//            int move = moves[i] - 1;
//            for (int j = 0; j < board.length; j ++) {
//                // moves[i] 그 위치헤 해당하는 0이 아닌 board[j][]를 뽑아서 저장. => board[j][moves[i]]
//                if (board[j][move] != 0) {
//                    if (stack.peek() == board[j][move]) {
//                        // 뽑힌거랑 stack에 제일 마지막에 있던거(peek)랑 같으면, 마지막거 제거하고 count++ => answer=count*2 => answer += 2
//                        stack.pop();
//                        answer += 2;
//                    } else {
//                        stack.push(board[j][move]);
//                    }
//                    board[j][move] = 0;
//                    // 0이면 넘어가기
//                    break;
//                }
//            }
//        }
//  확장 for문
//        for (int move : moves) {
//            for (int j = 0; j < board.length; j ++) {
//                // moves[i] 그 위치헤 해당하는 0이 아닌 board[j][]를 뽑아서 저장. => board[j][moves[i]]
//                if (board[j][move - 1] != 0) {
//                    if (stack.peek() == board[j][move - 1]) {
//                        // 뽑힌거랑 stack에 제일 마지막에 있던거(peek)랑 같으면, 마지막거 제거하고 count++ => answer=count*2 => answer += 2
//                        stack.pop();
//                        answer += 2;
//                    } else {
//                        stack.push(board[j][move - 1]);
//                    }
//                // 0이면 넘어가기
//                    board[j][move -1] = 0;
//                    break;
//                }
//            }
//        }
        return answer;
    }

}
