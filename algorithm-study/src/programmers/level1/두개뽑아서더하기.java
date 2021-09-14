package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/68644
public class �ΰ��̾Ƽ����ϱ� {
	public int[] solution(int[] numbers) {
		// ��
		int[] answer = {};
		// ��� List �ߺ� üũ ����
		int chk = 0;
		// ���ϱ� ��� ���� List
		List ansList = new ArrayList();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int ans = numbers[i] + numbers[j];
				// �ߺ�üũ
				Iterator it = ansList.iterator();
				while (it.hasNext()) {
					if ((Integer) it.next() == ans) {
						chk = 1;
					}
				}
				if (chk == 0) {
					ansList.add(ans);
				}
				chk = 0;
			}
		}
		Collections.sort(ansList);
		answer = new int[ansList.size()];
		int size = 0;
		Iterator it = ansList.iterator();
		while (it.hasNext()) {
			answer[size++] = (Integer) it.next();
		}
		return answer;
	}
}
