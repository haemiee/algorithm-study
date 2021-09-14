package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/68644
public class 두개뽑아서더하기 {
	public int[] solution(int[] numbers) {
		// 답
		int[] answer = {};
		// 결과 List 중복 체크 변수
		int chk = 0;
		// 더하기 결과 담을 List
		List ansList = new ArrayList();

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int ans = numbers[i] + numbers[j];
				// 중복체크
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
