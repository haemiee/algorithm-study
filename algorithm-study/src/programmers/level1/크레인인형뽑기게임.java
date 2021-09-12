package programmers.level1;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/64061
public class 크레인인형뽑기게임 {

	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<moves.length; i++) {
			for(int j=0; j<board.length; j++) {
				int tmp = board[j][moves[i]-1];
				if(tmp > 0) {
					if(!stack.empty()) {
						if(stack.peek() == tmp) {
							stack.pop();
							answer+=2;
						} else {
							stack.push(tmp);
						}
					}
					else {
						stack.push(board[j][moves[i]-1]);
					}
					board[j][moves[i]-1] = 0;
					break;
				}
			}
		}
        return answer;
    }
	
}
