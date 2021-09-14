package programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42840
public class 모의고사 {
	public int[] solution(int[] answers) {
		int[] answer = {};

		// 각 학생의 답안지
		int[] n1 = { 1, 2, 3, 4, 5 };
		int[] n2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] n3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		// for문 돌릴때 각 학생의 인덱스 (초기화 필요)
		int idx1 = 0;
		int idx2 = 0;
		int idx3 = 0;

		// 각 학생의 점수를 저장할 배열
		int[] scores = { 0, 0, 0 };

		for (int i = 0; i < answers.length; i++) {
			// 학생별로 답이 일치하면 맞은 개수 +1
			if (answers[i] == n1[idx1++]) {
				scores[0]++;
			}
			if (answers[i] == n2[idx2++]) {
				scores[1]++;
			}
			if (answers[i] == n3[idx3++]) {
				scores[2]++;
			}

			// 인덱스 초기화
			if (idx1 == n1.length) {
				idx1 = 0;
			}
			if (idx2 == n2.length) {
				idx2 = 0;
			}
			if (idx3 == n3.length) {
				idx3 = 0;
			}
		}

		int max = Arrays.stream(scores).max().getAsInt();
		// int max = Math.max(scores[0], Math.max(scores[1], scores[2]))

		if (max == scores[0] && max != scores[1] && max != scores[2]) {
			answer = new int[] { 1 };
		} else if (max != scores[0] && max == scores[1] && max != scores[2]) {
			answer = new int[] { 2 };
		} else if (max != scores[0] && max != scores[1] && max == scores[2]) {
			answer = new int[] { 3 };
		}

		else if (max == scores[0] && max == scores[1] && max != scores[2]) {
			answer = new int[] { 1, 2 };
		} else if (max != scores[0] && max == scores[1] && max == scores[2]) {
			answer = new int[] { 2, 3 };
		} else if (max == scores[0] && max != scores[1] && max == scores[2]) {
			answer = new int[] { 1, 3 };
		}

		else {
			answer = new int[] { 1, 2, 3 };
		}

		return answer;
	}
}
