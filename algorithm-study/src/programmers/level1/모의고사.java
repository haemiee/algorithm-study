package programmers.level1;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42840
public class ���ǰ�� {
	public int[] solution(int[] answers) {
		int[] answer = {};

		// �� �л��� �����
		int[] n1 = { 1, 2, 3, 4, 5 };
		int[] n2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] n3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		// for�� ������ �� �л��� �ε��� (�ʱ�ȭ �ʿ�)
		int idx1 = 0;
		int idx2 = 0;
		int idx3 = 0;

		// �� �л��� ������ ������ �迭
		int[] scores = { 0, 0, 0 };

		for (int i = 0; i < answers.length; i++) {
			// �л����� ���� ��ġ�ϸ� ���� ���� +1
			if (answers[i] == n1[idx1++]) {
				scores[0]++;
			}
			if (answers[i] == n2[idx2++]) {
				scores[1]++;
			}
			if (answers[i] == n3[idx3++]) {
				scores[2]++;
			}

			// �ε��� �ʱ�ȭ
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
